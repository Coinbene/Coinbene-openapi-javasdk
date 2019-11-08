package com.coinbene.api.sdk.bean;

/**
 * Http Result
 *
 */
public class HttpResult {

    private int statusCode;
    private String message;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String message(){
        return new StringBuilder().append(this.statusCode).append(" / ").append(this.message).toString();
    }
}
