package com.coinbene.api.sdk.enums;

/**
 * internationalization
 */
public enum I18nEnum {
    ENGLISH("en_US"),
    SIMPLIFIED_CHINESE("zh_CN"),
;
    private String i18n;

    I18nEnum(String i18n) {
        this.i18n = i18n;
    }

    public String i18n() {
        return i18n;
    }
}
