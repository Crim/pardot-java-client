package com.pardot.api.rest.handlers.user;

import com.pardot.api.response.user.UserQueryResponse;
import com.pardot.api.rest.handlers.BaseResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Handles parsing UserQuery API responses into POJOs.
 */
public class UserQueryResponseHandler extends BaseResponseHandler<UserQueryResponse.Result> {

    @Override
    public UserQueryResponse.Result parseResponse(final String responseStr) throws IOException {
        return getMapper().readValue(responseStr, UserQueryResponse.class).getResult();
    }
}
