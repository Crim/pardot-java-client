package com.darksci.pardot.api.response;

public enum ErrorCode {
    INVALID_API_OR_USER_KEY(1),
    INVALID_USER_ID(10);

    private final int code;

    ErrorCode(final int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
