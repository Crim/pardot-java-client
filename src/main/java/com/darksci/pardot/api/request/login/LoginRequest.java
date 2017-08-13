package com.darksci.pardot.api.request.login;

import com.darksci.pardot.api.request.BaseRequest;

/**
 * Make a login request to API.
 */
public class LoginRequest extends BaseRequest<LoginRequest> {

    @Override
    public String getApiEndpoint() {
        return "login";
    }

    public LoginRequest withEmail(final String email) {
        return setParam("email", email);
    }

    public LoginRequest withPassword(final String password) {
        return setParam("password", password);
    }
}
