package com.pardot.api.rest.handlers.email;

import com.pardot.api.response.email.EmailStatsResponse;
import com.pardot.api.rest.handlers.BaseResponseHandler;

import java.io.IOException;

/**
 *
 */
public class EmailStatsResponseHandler extends BaseResponseHandler<EmailStatsResponse.Stats> {
    @Override
    public EmailStatsResponse.Stats parseResponse(final String responseStr) throws IOException {
        return getMapper().readValue(responseStr, EmailStatsResponse.class).getStats();
    }
}