package com.darksci.pardot.api.parser.email;

import com.darksci.pardot.api.parser.JacksonFactory;
import com.darksci.pardot.api.parser.ResponseParser;
import com.darksci.pardot.api.response.email.Email;
import com.darksci.pardot.api.response.email.EmailReadResponse;

import java.io.IOException;

/**
 * Parses Email Read Requests into an Email POJO.
 */
public class EmailReadResponseParser implements ResponseParser<Email> {
    @Override
    public Email parseResponse(final String responseStr) throws IOException {
        return JacksonFactory.newInstance().readValue(responseStr, EmailReadResponse.class).getEmail();
    }
}
