package com.coinbene.api.sdk.client;

import com.alibaba.fastjson.JSON;
import com.coinbene.api.sdk.bean.HttpResult;
import com.coinbene.api.sdk.config.APIConfiguration;
import com.coinbene.api.sdk.constant.APIConstants;
import com.coinbene.api.sdk.enums.HttpHeadersEnum;
import com.coinbene.api.sdk.exception.APIException;
import com.coinbene.api.sdk.utils.DateUtils;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

/**
 * API Client
 *
 */
public class APIClient {

    private static final Logger LOG = LoggerFactory.getLogger(APIClient.class);

    private APIConfiguration config;
    private APICredentials credentials;
    private OkHttpClient client;
    private Retrofit retrofit;
    private ApiHttp apiHttp;

    /**
     * Initialize the apis client
     */
    public APIClient(APIConfiguration config) {
        if (config == null || StringUtils.isEmpty(config.getEndpoint())) {
            throw new RuntimeException("The APIClient params can't be empty.");
        }
        this.config = config;
        this.credentials = new APICredentials(config);
        this.client = new APIHttpClient(config, this.credentials).client();
        this.retrofit = new APIRetrofit(config, this.client).retrofit();
        this.apiHttp = new ApiHttp(config, this.client);
    }

    /**
     * Initialize the retrofit operation service
     */
    public <T> T createService(Class<T> service) {
        return this.retrofit.create(service);
    }

    public ApiHttp getApiHttp() {
        return apiHttp;
    }

    /**
     * Synchronous send request
     */
    public <T> T executeSync(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (this.config.isPrint()) {
                printResponse(response);
            }
            int status = response.code();
            String message = new StringBuilder().append(response.code()).append(" / ").append(response.message()).toString();
            if (response.isSuccessful()) {
                return response.body();
            } else if (APIConstants.resultStatusArray.contains(status)) {
                HttpResult result = JSON.parseObject(new String(response.errorBody().bytes()), HttpResult.class);
                result.setStatusCode(status);
                throw new APIException(result.message());
            } else {
                throw new APIException(message);
            }
        } catch (IOException e) {
            throw new APIException("APIClient executeSync exception.", e);
        }
    }


    private void printResponse(Response response) {
        StringBuilder responseInfo = new StringBuilder();
        responseInfo.append("\n\tResponse").append("(").append(DateUtils.timeToString(null, 4)).append("):");
        if (response != null) {
            String limit = response.headers().get(HttpHeadersEnum.LIMIT.header());
            if (StringUtils.isNotEmpty(limit)) {
                responseInfo.append("\n\t\t").append("Headers: ");
                responseInfo.append("\n\t\t\t").append(HttpHeadersEnum.FROM.header()).append(": ").append(response.headers().get(HttpHeadersEnum.FROM.header()));
                responseInfo.append("\n\t\t\t").append(HttpHeadersEnum.TO.header()).append(": ").append(response.headers().get(HttpHeadersEnum.TO.header()));
                responseInfo.append("\n\t\t\t").append(HttpHeadersEnum.LIMIT.header()).append(": ").append(limit);
            }
            responseInfo.append("\n\t\t").append("Status: ").append(response.code());
            responseInfo.append("\n\t\t").append("Message: ").append(response.message());
            responseInfo.append("\n\t\t").append("Body: ").append(JSON.toJSONString(response.body()));
        } else {
            responseInfo.append("\n\t\t").append("\n\tRequest Error: response is null");
        }
        LOG.info(responseInfo.toString());
    }
}
