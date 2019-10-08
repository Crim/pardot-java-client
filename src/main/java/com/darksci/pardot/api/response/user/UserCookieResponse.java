package com.darksci.pardot.api.response.user;

/**
 * Represents a User cookie response.
 */
public class UserCookieResponse {

    private Cookie cookie;

    public Cookie getCookie() {
        return cookie;
    }

    @Override
    public String toString() {
        return "UserCookieResponse{" +
            "cookie=" + cookie +
            '}';
    }
}
