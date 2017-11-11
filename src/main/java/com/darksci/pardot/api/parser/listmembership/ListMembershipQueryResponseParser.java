package com.darksci.pardot.api.parser.listmembership;

import com.darksci.pardot.api.parser.JacksonFactory;
import com.darksci.pardot.api.parser.ResponseParser;
import com.darksci.pardot.api.response.listmembership.ListMembershipQueryResponse;

import java.io.IOException;

/**
 * Handles parsing ListQuery API responses into POJOs.
 */
public class ListMembershipQueryResponseParser implements ResponseParser<ListMembershipQueryResponse.Result> {

    @Override
    public ListMembershipQueryResponse.Result parseResponse(final String responseStr) throws IOException {
        return JacksonFactory.newInstance().readValue(responseStr, ListMembershipQueryResponse.class).getResult();
    }
}
