package com.darksci.pardot.api.parser.campaign;

import com.darksci.pardot.api.parser.JacksonFactory;
import com.darksci.pardot.api.parser.ResponseParser;
import com.darksci.pardot.api.response.campaign.CampaignQueryResponse;

import java.io.IOException;

/**
 * Handles parsing CampaignQuery API responses into POJOs.
 */
public class CampaignQueryResponseParser implements ResponseParser<CampaignQueryResponse.Result> {

    @Override
    public CampaignQueryResponse.Result parseResponse(final String responseStr) throws IOException {
        return JacksonFactory.newInstance().readValue(responseStr, CampaignQueryResponse.class).getResult();
    }
}
