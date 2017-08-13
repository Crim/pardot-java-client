package com.darksci.pardot.api.parser;

import java.io.IOException;

/**
 *
 */
public interface ResponseParser<T> {

    /**
     * Abstract parseResponse method.  We give you the String representation of the response, your job is
     * to parse into something more useful and return it!
     * @param responseStr The response string from the request.
     * @return Parsed response.
     * @throws IOException on parse errors.
     */
    T parseResponse(final String responseStr) throws IOException;
}
