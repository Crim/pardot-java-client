package com.darksci.pardot.api.parser;

import java.io.IOException;

/**
 * Simple pass through parser.
 */
public class StringResponseParser implements ResponseParser<String> {
    @Override
    public String parseResponse(final String responseStr) throws IOException {
        // avoid NPE
        if (responseStr == null) {
            return "";
        }
        return responseStr;
    }
}
