package com.coinbene.api.sdk.client;

import com.coinbene.api.sdk.config.APIConfiguration;

/**
 * API Credentials.<br/>
 * The api key and secret key will be randomly generated.
 *
 */
public class APICredentials {
    /**
     * The user's secret key.
     */
    private String apiKey;
    /**
     * The private key used to sign your request data.
     */
    private String secretKey;

    public APICredentials(APIConfiguration config) {
        super();
        this.apiKey = config.getApiKey();
        this.secretKey = config.getSecretKey();
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

}
