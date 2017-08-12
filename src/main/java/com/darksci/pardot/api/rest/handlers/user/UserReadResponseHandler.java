package com.pardot.api.rest.handlers.user;

import com.pardot.api.response.user.User;
import com.pardot.api.response.user.UserReadResponse;
import com.pardot.api.rest.handlers.BaseResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
