package com.coinbene.api.sdk.capital;

import com.coinbene.api.sdk.BaseTests;
import com.coinbene.api.sdk.config.APIConfiguration;
import com.coinbene.api.sdk.enums.I18nEnum;

/**
 * exchange api basetests
 */
public class APIBaseTests extends BaseTests {

    public APIConfiguration config() {
        APIConfiguration config = new APIConfiguration();

        // 域名
        config.setEndpoint("http://127.0.0.1:8610");
//        config.setEndpoint("http://openapi-exchange.coinbene.com");
        /// api Key，api注册成功后页面上有
        config.setApiKey("API-KEY-10000886");
        // secret Key，api注册成功后页面上有
        config.setSecretKey("6e45d07fe2db4ea6816eacf3866eb5bc");

        // 详细打印
        config.setPrint(true);
        config.setI18n(I18nEnum.ENGLISH);

        return config;
    }

}
