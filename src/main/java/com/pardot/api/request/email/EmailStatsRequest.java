package com.pardot.api.request.email;

import com.pardot.api.request.BaseRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * For querying List Email Send Stats.
 */
public class EmailStatsRequest extends BaseRequest<EmailStatsRequest> {
    private static final Logger logger = LoggerFactory.getLogger(EmailStatsRequest.class);

    @Override
    public String getApiEndpoint() {
        return "email/do/stats";
    }

    /**
     * Define which ListEmail you want to retrieve stats for.
     * @param listEmailId ListEmailId to retrieve stats for.
     * @return RequestBuilder
     */
    public EmailStatsRequest selectByListEmailId(final Long listEmailId) {
        return setParam("id", listEmailId);
    }
}
