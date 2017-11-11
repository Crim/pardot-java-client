package com.darksci.pardot.api.parser.listmembership;

import com.darksci.pardot.api.parser.JacksonFactory;
import com.darksci.pardot.api.parser.ResponseParser;
import com.darksci.pardot.api.response.list.ListMembership;
import com.darksci.pardot.api.response.listmembership.ListMembershipReadResponse;

import java.io.IOException;

/**
 * Handles parsing ListMembership Read API responses into POJOs.
 */
public class ListMembershipReadResponseParser implements ResponseParser<ListMembership> {

    @Override
    public ListMembership parseResponse(final String responseStr) throws IOException {
        return JacksonFactory.newInstance().readValue(responseStr, ListMembershipReadResponse.class).getListMembership();
    }
}
