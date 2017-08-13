package com.darksci.pardot.api.rest;

/**
 * Exception when an underlying error occurs in a RestClient implementation.
 */
public class RestException extends RuntimeException {
    public RestException() {
    }

    public RestException(final String message) {
        super(message);
    }

    public RestException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public RestException(final Throwable cause) {
        super(cause);
    }

    public RestException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
