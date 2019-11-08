package com.coinbene.api.sdk;

import com.alibaba.fastjson.JSON;
import com.coinbene.api.sdk.config.APIConfiguration;
import org.slf4j.Logger;

/**
 * Junit base Tests
 */
public class BaseTests {

    public APIConfiguration config;

    public void toResultString(Logger log, String flag, Object object) {
        StringBuilder su = new StringBuilder();
        su.append("\n").append("<*> ").append(flag).append(": ").append(JSON.toJSONString(object));
        log.info(su.toString());
    }
}
