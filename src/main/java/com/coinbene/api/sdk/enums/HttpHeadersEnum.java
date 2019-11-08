package com.coinbene.api.sdk.enums;

/**
 * Http Headers Enum . <br/>
 */
public enum HttpHeadersEnum {

    ACCESS_KEY("ACCESS-KEY"),
    ACCESS_SIGN("ACCESS-SIGN"),
    ACCESS_TIMESTAMP("ACCESS-TIMESTAMP"),

    FROM("FROM"),
    TO("TO"),
    LIMIT("LIMIT"),;

    private String header;

    HttpHeadersEnum(String header) {
        this.header = header;
    }

    public String header() {
        return header;
    }
}
