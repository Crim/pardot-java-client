package com.darksci.pardot.api;

/**
 * Thrown if the Client is unable to login or authenticate properly.
 */
public class LoginFailedException extends InvalidRequestException {

    public LoginFailedException(final String message, final int errorCode) {
        super(message, errorCode);
    }

    public LoginFailedException(final String message, final int errorCode, final Throwable cause) {
        super(message, errorCode);
        this.initCause(cause);
    }
}
