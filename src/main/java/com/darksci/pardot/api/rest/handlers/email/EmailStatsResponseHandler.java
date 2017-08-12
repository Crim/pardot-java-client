package com.darksci.pardot.api.rest.handlers.email;

import com.darksci.pardot.api.rest.handlers.BaseResponseHandler;
import com.darksci.pardot.api.response.email.EmailStatsResponse;

import java.io.IOException;

/**
 * Handles parsing EmailStats API responses into POJOs.
 */
public class EmailStatsResponseHandler extends BaseResponseHandler<EmailStatsResponse.Stats> {
    @Override
    public EmailStatsResponse.Stats parseResponse(final String responseStr) throws IOException {
        return getMapper().readValue(responseStr, EmailStatsResponse.class).getStats();
    }
}