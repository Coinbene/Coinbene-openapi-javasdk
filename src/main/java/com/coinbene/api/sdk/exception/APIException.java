package com.coinbene.api.sdk.exception;

/**
 * API Exception
 *
 */
public class APIException extends RuntimeException {

    public APIException(String message) {
        super(message);
    }

    public APIException(Throwable cause) {
        super(cause);
    }

    public APIException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
