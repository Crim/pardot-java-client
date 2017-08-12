package com.darksci.pardot.api.rest.handlers;

/**
 * Returns response as a string.
 */
public class StringResponseHandler extends BaseResponseHandler<String> {
    @Override
    public String parseResponse(final String responseStr) {
        return responseStr;
    }
}
