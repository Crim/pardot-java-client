package com.pardot.api.request.user;

import com.pardot.api.request.BaseRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Used to generate a User Read request.
 */
public class UserReadRequest extends BaseRequest<UserReadRequest> {
    private static final Logger logger = LoggerFactory.getLogger(UserReadRequest.class);

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

    @Override
    public String getApiEndpoint() {
        return "user/do/read";
    }
}
