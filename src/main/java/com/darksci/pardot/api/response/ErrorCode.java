package com.darksci.pardot.api.response;

public enum ErrorCode {
    INVALID_API_OR_USER_KEY(1),
    INVALID_ACTION(2),
    INVALID_PROSPECT_ID(3),
    INVALID_PROSPECT_EMAIL_ADDRESS(4),
    INVALID_USER_ID(10),
    INVALID_ID(11),
    LOGIN_FAILED(15),
    INVALID_CAMPAIGN_ID(38),
    EMAIL_ADDRESS_IS_ALREADY_IN_USE(54),
    INVALID_LIST_ID(55),
    INVALID_EMAIL_FORMAT(65);

    private final int code;

    ErrorCode(final int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
