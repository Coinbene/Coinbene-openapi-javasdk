package com.coinbene.api.sdk.contract;

import com.coinbene.api.sdk.BaseTests;
import com.coinbene.api.sdk.config.APIConfiguration;
import com.coinbene.api.sdk.enums.I18nEnum;

/**
 * contract api basetests
 */
public class APIBaseTests extends BaseTests {

    public APIConfiguration config() {
        APIConfiguration config = new APIConfiguration();

        // 域名
//        config.setEndpoint("http://openapi-contract.coinbene.com");
        config.setEndpoint("http://openapi-contract.coinbene.com");
        // api Key，api注册成功后页面上有
        config.setApiKey("API-KEY-10000886");
        // secret Key，api注册成功后页面上有
        config.setSecretKey("5f16b242c38f4732be9f4d8d73045ebe");


        // 详细打印
        config.setPrint(true);
        config.setI18n(I18nEnum.SIMPLIFIED_CHINESE);
//        config.setI18n(I18nEnum.ENGLISH);


        return config;
    }

}
