package com.darksci.pardot.api.parser.campaign;

import com.darksci.pardot.api.parser.JacksonFactory;
import com.darksci.pardot.api.parser.ResponseParser;
import com.darksci.pardot.api.response.campaign.Campaign;
import com.darksci.pardot.api.response.campaign.CampaignReadResponse;

import java.io.IOException;

/**
 * Handles parsing CampaignRead API responses into POJOs.
 */
public class CampaignReadResponseParser implements ResponseParser<Campaign> {

    @Override
    public Campaign parseResponse(final String responseStr) throws IOException {
        return JacksonFactory.newInstance().readValue(responseStr, CampaignReadResponse.class).getCampaign();
    }
}
