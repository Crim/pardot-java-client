package com.pardot.api.rest.handlers.user;

import com.pardot.api.response.user.User;
import com.pardot.api.response.user.UserReadResponse;
import com.pardot.api.rest.handlers.BaseResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 *
 */
public class UserReadResponseHandler extends BaseResponseHandler<User> {
    private static final Logger logger = LoggerFactory.getLogger(UserReadResponseHandler.class);

    @Override
    public User parseResponse(final String responseStr) throws IOException {
        return getMapper().readValue(responseStr, UserReadResponse.class).getUser();
    }
}
