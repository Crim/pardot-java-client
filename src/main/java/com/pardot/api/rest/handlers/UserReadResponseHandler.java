package com.pardot.api.rest.handlers;

import com.pardot.api.rest.responses.user.User;
import com.pardot.api.rest.responses.user.UserRead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 *
 */
public class UserReadResponseHandler extends BaseResponseHandler<User> {
    private static final Logger logger = LoggerFactory.getLogger(UserReadResponseHandler.class);

    @Override
    public User parseResponse(final String responseStr) {
        try {
            return getMapper().readValue(responseStr, UserRead.class).getUser();
        } catch (IOException e) {
            logger.error("Failed to parse: {}", e.getMessage(), e);
            return null;
        }
    }
}
