package com.darksci.pardot.api.request.user;

import com.darksci.pardot.api.request.BaseRequest;

/**
 * Used to generate a User read request.
 */
public class UserReadRequest extends BaseRequest<UserReadRequest> {

    @Override
    public String getApiEndpoint() {
        return "user/do/read";
    }

    /**
     * Returns the data for the user specified by email.
     * @param email The email address of the target user.
     */
    public UserReadRequest selectByEmail(final String email) {
        if (email != null) {
            selectById(null);
        }
        return setParam("email", email);
    }

    /**
     * Returns the data for the user specified by id.
     * @param id The Pardot ID of the target user.
     */
    public UserReadRequest selectById(final Long id) {
        if (id != null) {
            selectByEmail(null);
        }
        return setParam("id", id);
    }
}
