package com.darksci.pardot.api.rest.handlers.user;

import com.darksci.pardot.api.response.user.User;
import com.darksci.pardot.api.response.user.UserReadResponse;
import com.darksci.pardot.api.rest.handlers.BaseResponseHandler;

import java.io.IOException;

/**
 * Handles parsing UserRead API responses into POJOs.
 */
public class UserReadResponseHandler extends BaseResponseHandler<User> {

    @Override
    public User parseResponse(final String responseStr) throws IOException {
        return getMapper().readValue(responseStr, UserReadResponse.class).getUser();
    }
}
