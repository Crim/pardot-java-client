package com.darksci.pardot.api.parser.prospectaccount;

import java.io.IOException;

import com.darksci.pardot.api.parser.JacksonFactory;
import com.darksci.pardot.api.parser.ResponseParser;
import com.darksci.pardot.api.response.prospectaccount.ProspectAccountQueryResponse;


/**
 * Handles parsing ProspectQuery API responses into POJOs.
 */
public class ProspectAccountQueryResponseParser implements ResponseParser<ProspectAccountQueryResponse.Result> {

    @Override
    public ProspectAccountQueryResponse.Result parseResponse(final String responseStr) throws IOException {
        return JacksonFactory.newInstance().readValue(responseStr, ProspectAccountQueryResponse.class).getResult();
    }
}
