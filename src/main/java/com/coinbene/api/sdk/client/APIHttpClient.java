package com.coinbene.api.sdk.client;

import com.coinbene.api.sdk.config.APIConfiguration;
import com.coinbene.api.sdk.constant.APIConstants;
import com.coinbene.api.sdk.enums.ContentTypeEnum;
import com.coinbene.api.sdk.enums.HttpHeadersEnum;
import com.coinbene.api.sdk.exception.APIException;
import com.coinbene.api.sdk.utils.DateUtils;
import com.coinbene.api.sdk.utils.HmacSHA256Base64Utils;
import okhttp3.*;
import okio.Buffer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.concurrent.TimeUnit;

/**
 * API OkHttpClient.
 */
public class APIHttpClient {

    private static final Logger LOG = LoggerFactory.getLogger(APIHttpClient.class);

    private APIConfiguration config;
    private APICredentials credentials;

    public APIHttpClient(APIConfiguration config, APICredentials credentials) {
        this.config = config;
        this.credentials = credentials;
    }

    /**
     * Get a ok http 3 client object. <br/>
     * Declare:
     * <blockquote><pre>
     *  1. Set default client args:
     *         connectTimeout=30s
     *         readTimeout=30s
     *         writeTimeout=30s
     *         retryOnConnectionFailure=true.
     *  2. Set request headers:
     *      Content-Type: application/json; charset=UTF-8  (default)
     *      Cookie: locale=en_US        (English)
     *      ACCESS-KEY: (Your setting)
     *      ACCESS-SIGN: (Use your setting, auto sign and add)
     *      ACCESS-TIMESTAMP: (Auto add)
     *      ACCESS-PASSPHRASE: Your setting
     *  3. Set default print api info: false.
     * </pre></blockquote>
     */
    public OkHttpClient client() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.connectTimeout(this.config.getConnectTimeout(), TimeUnit.SECONDS);
        clientBuilder.readTimeout(this.config.getReadTimeout(), TimeUnit.SECONDS);
        clientBuilder.writeTimeout(this.config.getWriteTimeout(), TimeUnit.SECONDS);
        clientBuilder.retryOnConnectionFailure(this.config.isRetryOnConnectionFailure());
        clientBuilder.addInterceptor((Interceptor.Chain chain) -> {
            Request.Builder requestBuilder = chain.request().newBuilder();
            String timestamp = DateUtils.getUnixTime();
            requestBuilder.headers(headers(chain.request(), timestamp));
            Request request = requestBuilder.build();
            if (this.config.isPrint()) {
                printRequest(request, timestamp);
            }
            return chain.proceed(request);
        });
        return clientBuilder.build();
    }

    private Headers headers(Request request, String timestamp) {
        Headers.Builder builder = new Headers.Builder();
        builder.add(APIConstants.ACCEPT, ContentTypeEnum.APPLICATION_JSON.contentType());
        builder.add(APIConstants.CONTENT_TYPE, ContentTypeEnum.APPLICATION_JSON_UTF8.contentType());
        builder.add(APIConstants.COOKIE, getCookie());
        if (StringUtils.isNotEmpty(this.credentials.getSecretKey())) {
            builder.add(HttpHeadersEnum.ACCESS_KEY.header(), this.credentials.getApiKey());
            builder.add(HttpHeadersEnum.ACCESS_SIGN.header(), sign(request, timestamp));
            builder.add(HttpHeadersEnum.ACCESS_TIMESTAMP.header(), timestamp);
        }
        return builder.build();
    }

    private String getCookie() {
        StringBuilder cookie = new StringBuilder();
        cookie.append(APIConstants.LOCALE).append(this.config.getI18n().i18n());
        return cookie.toString();
    }

    private String sign(Request request, String timestamp) {
        String sign;
        try {
            sign = HmacSHA256Base64Utils.sign1(timestamp, method(request), requestPath(request),
                    queryString(request), body(request), this.credentials.getSecretKey());
        } catch (IOException e) {
            throw new APIException("Request get body io exception.", e);
        } catch (CloneNotSupportedException e) {
            throw new APIException("Hmac SHA256 Base64 Signature clone not supported exception.", e);
        } catch (InvalidKeyException e) {
            throw new APIException("Hmac SHA256 Base64 Signature invalid key exception.", e);
        } catch (Exception e) {
            throw new APIException("Hmac SHA256 Signature invalid key exception.", e);
        }
        return sign;
    }

    private String url(Request request) {
        return request.url().toString();
    }

    private String method(Request request) {
        return request.method().toUpperCase();
    }

    private String requestPath(Request request) {
        String url = url(request);
        url = url.replace(this.config.getEndpoint(), APIConstants.EMPTY);
        String requestPath = url;
        if (requestPath.contains(APIConstants.QUESTION)) {
            requestPath = requestPath.substring(0, url.lastIndexOf(APIConstants.QUESTION));
        }
        if(this.config.getEndpoint().endsWith(APIConstants.SLASH)){
            requestPath = APIConstants.SLASH + requestPath;
        }
        return requestPath;
    }

    private String queryString(Request request) {
        String url = url(request);
        String queryString = APIConstants.EMPTY;
        if (url.contains(APIConstants.QUESTION)) {
            queryString = url.substring(url.lastIndexOf(APIConstants.QUESTION) + 1);
        }
        return queryString;
    }

    private String body(Request request) throws IOException {
        RequestBody requestBody = request.body();
        String body = APIConstants.EMPTY;
        if (requestBody != null) {
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            body = buffer.readString(APIConstants.UTF_8);
        }
        return body;
    }

    private void printRequest(Request request, String timestamp) {
        String method = method(request);
        String requestPath = requestPath(request);
        String queryString = queryString(request);
        String body;
        try {
            body = body(request);
        } catch (IOException e) {
            throw new APIException("Request get body io exception.", e);
        }
        StringBuilder requestInfo = new StringBuilder();
        requestInfo.append("\n").append("\tSecret-Key: ").append(this.credentials.getSecretKey());
        requestInfo.append("\n\tRequest").append("(").append(DateUtils.timeToString(null, 4)).append("):");
        requestInfo.append("\n\t\t").append("Url: ").append(url(request));
        requestInfo.append("\n\t\t").append("Method: ").append(method);
        requestInfo.append("\n\t\t").append("Headers: ");
        Headers headers = request.headers();
        if (headers != null && headers.size() > 0) {
            for (String name : headers.names()) {
                requestInfo.append("\n\t\t\t").append(name).append(": ").append(headers.get(name));
            }
        }
        requestInfo.append("\n\t\t").append("Body: ").append(body);
        String preHash = HmacSHA256Base64Utils.preHash(timestamp, method, requestPath, queryString, body);
        requestInfo.append("\n\t\t").append("preHash: ").append(preHash);
        LOG.info(requestInfo.toString());
    }
}
