package com.darksci.pardot.api.parser.list;

import com.darksci.pardot.api.parser.JacksonFactory;
import com.darksci.pardot.api.parser.ResponseParser;
import com.darksci.pardot.api.response.list.List;
import com.darksci.pardot.api.response.list.ListReadResponse;

import java.io.IOException;

/**
 * Handles parsing ListRead API responses into POJOs.
 */
public class ListReadResponseParser implements ResponseParser<List> {

    @Override
    public List parseResponse(final String responseStr) throws IOException {
        return JacksonFactory.newInstance().readValue(responseStr, ListReadResponse.class).getList();
    }
}
