package com.pardot.api.rest.handlers.email;

import com.pardot.api.response.email.Email;
import com.pardot.api.response.email.EmailReadResponse;
import com.pardot.api.rest.handlers.BaseResponseHandler;

import java.io.IOException;

/**
 * Parses Email Read Requests into an Email POJO.
 */
public class EmailReadResponseHandler extends BaseResponseHandler<Email> {
    @Override
    public Email parseResponse(final String responseStr) throws IOException {
        return getMapper().readValue(responseStr, EmailReadResponse.class).getEmail();
    }
}
