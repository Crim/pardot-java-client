package com.pardot.api.rest.handlers.user;

import com.pardot.api.response.user.UserAbilitiesResponse;
import com.pardot.api.rest.handlers.BaseResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 *
 */
public class UserAbilitiesHandler extends BaseResponseHandler<UserAbilitiesResponse.Result> {
    private static final Logger logger = LoggerFactory.getLogger(UserAbilitiesHandler.class);

    @Override
    public UserAbilitiesResponse.Result parseResponse(final String responseStr) throws IOException {
        return getMapper().readValue(responseStr, UserAbilitiesResponse.class).getResult();
    }
}
