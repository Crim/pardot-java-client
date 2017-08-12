package com.darksci.pardot.api.rest.handlers.campaign;

import com.darksci.pardot.api.response.campaign.CampaignQueryResponse;
import com.darksci.pardot.api.rest.handlers.BaseResponseHandler;

import java.io.IOException;

/**
 * Handles parsing CampaignQuery API responses into POJOs.
 */
public class CampaignQueryResponseHandler extends BaseResponseHandler<CampaignQueryResponse.Result> {

    @Override
    public CampaignQueryResponse.Result parseResponse(final String responseStr) throws IOException {
        return getMapper().readValue(responseStr, CampaignQueryResponse.class).getResult();
    }
}
