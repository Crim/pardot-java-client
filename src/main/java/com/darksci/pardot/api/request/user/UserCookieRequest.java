package com.darksci.pardot.api.request.user;

import com.darksci.pardot.api.request.BaseRequest;

/**
 * Used to generate a User Cookie request.
 */
public class UserCookieRequest extends BaseRequest<UserCookieRequest> {
    @Override
    public String getApiEndpoint() {
        return "user/do/cookie";
    }
}
