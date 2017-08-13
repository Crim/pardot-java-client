package com.darksci.pardot.api;

/**
 * Represents when a request is invalid.
 */
public class InvalidRequestException extends RuntimeException {
    private final int errorCode;

    public InvalidRequestException(final String message, final int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public InvalidRequestException(final String message, final Throwable cause) {
        super(message, cause);
        this.errorCode = -1;
    }
}
