package com.darksci.pardot.api.parser.prospect;

import com.darksci.pardot.api.parser.JacksonFactory;
import com.darksci.pardot.api.parser.ResponseParser;
import com.darksci.pardot.api.response.campaign.CampaignQueryResponse;
import com.darksci.pardot.api.response.prospect.ProspectQueryResponse;

import java.io.IOException;

/**
 * Handles parsing ProspectQuery API responses into POJOs.
 */
public class ProspectQueryResponseParser implements ResponseParser<ProspectQueryResponse.Result> {

    @Override
    public ProspectQueryResponse.Result parseResponse(final String responseStr) throws IOException {
        return JacksonFactory.newInstance().readValue(responseStr, ProspectQueryResponse.class).getResult();
    }
}
