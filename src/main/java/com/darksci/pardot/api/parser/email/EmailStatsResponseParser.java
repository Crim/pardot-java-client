package com.darksci.pardot.api.parser.email;

import com.darksci.pardot.api.parser.JacksonFactory;
import com.darksci.pardot.api.parser.ResponseParser;
import com.darksci.pardot.api.response.email.EmailStatsResponse;

import java.io.IOException;

/**
 * Handles parsing EmailStats API responses into POJOs.
 */
public class EmailStatsResponseParser implements ResponseParser<EmailStatsResponse.Stats> {
    @Override
    public EmailStatsResponse.Stats parseResponse(final String responseStr) throws IOException {
        return JacksonFactory.newInstance().readValue(responseStr, EmailStatsResponse.class).getStats();
    }
}