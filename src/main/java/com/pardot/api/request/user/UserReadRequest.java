package com.pardot.api.request.user;

import com.pardot.api.request.BaseRequest;

/**
 * Used to generate a User read request.
 */
public class UserReadRequest extends BaseRequest<UserReadRequest> {

    @Override
    public String getApiEndpoint() {
        return "user/do/read";
    }


    public UserReadRequest selectByEmail(final String email) {
        if (email != null) {
            selectById(null);
        }
        return setParam("email", email);
    }

    public UserReadRequest selectById(final Long id) {
        if (id != null) {
            selectByEmail(null);
        }
        return setParam("id", id);
    }
}
