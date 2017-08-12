package com.pardot.api.rest.handlers;

import com.pardot.api.rest.responses.campaign.CampaignQueryResponse;
import com.pardot.api.rest.responses.user.UserQueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Handles parsing CampaignQuery API responses into POJOs.
 */
public class CampaignQueryResponseHandler extends BaseResponseHandler<CampaignQueryResponse.Result> {
    private static final Logger logger = LoggerFactory.getLogger(CampaignQueryResponseHandler.class);

    @Override
    public CampaignQueryResponse.Result parseResponse(final String responseStr) {
        try {
            return getMapper().readValue(responseStr, CampaignQueryResponse.class).getResult();
        } catch (IOException e) {
            logger.error("Failed to parse: {}", e.getMessage(), e);
            return null;
        }
    }
}
