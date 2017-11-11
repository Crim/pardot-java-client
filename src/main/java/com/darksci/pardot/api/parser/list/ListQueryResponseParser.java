package com.darksci.pardot.api.parser.list;

import com.darksci.pardot.api.parser.JacksonFactory;
import com.darksci.pardot.api.parser.ResponseParser;
import com.darksci.pardot.api.response.list.ListQueryResponse;

import java.io.IOException;

/**
 * Handles parsing ListQuery API responses into POJOs.
 */
public class ListQueryResponseParser implements ResponseParser<ListQueryResponse.Result> {

    @Override
    public ListQueryResponse.Result parseResponse(final String responseStr) throws IOException {
        return JacksonFactory.newInstance().readValue(responseStr, ListQueryResponse.class).getResult();
    }
}
