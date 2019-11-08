package com.coinbene.api.sdk.config;

import com.coinbene.api.sdk.constant.APIConstants;
import com.coinbene.api.sdk.enums.I18nEnum;

/**
 * API configuration information
 *
 */
public class APIConfiguration {

    /**
     * The user's api key.
     */
    private String apiKey;
    /**
     * The user's secret key. The secret key used to sign your request data.
     */
    private String secretKey;
    /**
     * Rest api endpoint url.
     */
    private String endpoint;

    /**
     * Host connection timeout.
     */
    private long connectTimeout;
    /**
     * The host reads the information timeout.
     */
    private long readTimeout;
    /**
     * The host writes the information timeout.
     */
    private long writeTimeout;
    /**
     * Failure reconnection, default true.
     */
    private boolean retryOnConnectionFailure;

    /**
     * The print api information.
     */
    private boolean print;

    /**
     * internationalization  {@link com.coinbene.api.sdk.enums.I18nEnum}
     */
    private I18nEnum i18n;

    public APIConfiguration() {
        this(null);
    }

    public APIConfiguration(String endpoint) {
        super();
        this.apiKey = null;
        this.secretKey = null;
        this.endpoint = endpoint;
        this.connectTimeout = APIConstants.TIMEOUT;
        this.readTimeout = APIConstants.TIMEOUT;
        this.writeTimeout = APIConstants.TIMEOUT;
        this.retryOnConnectionFailure = true;
        this.print = false;
        this.i18n = I18nEnum.ENGLISH;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public long getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(long connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public long getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(long readTimeout) {
        this.readTimeout = readTimeout;
    }

    public long getWriteTimeout() {
        return writeTimeout;
    }

    public void setWriteTimeout(long writeTimeout) {
        this.writeTimeout = writeTimeout;
    }

    public boolean isRetryOnConnectionFailure() {
        return retryOnConnectionFailure;
    }

    public void setRetryOnConnectionFailure(boolean retryOnConnectionFailure) {
        this.retryOnConnectionFailure = retryOnConnectionFailure;
    }

    public boolean isPrint() {
        return print;
    }

    public void setPrint(boolean print) {
        this.print = print;
    }

    public I18nEnum getI18n() {
        return i18n;
    }

    public void setI18n(I18nEnum i18n) {
        this.i18n = i18n;
    }
}
