package com.darksci.pardot.api.parser;

import java.io.IOException;

/**
 * Interface Parsers for API responses implement.
 * @param <T> The object type returned from the parser implementation.
 */
public interface ResponseParser<T> {

    /**
     * The response from the request is given in String representation.  Implementation should
     * parse into something more useful and return it!
     * @param responseStr The response string from the request.     
     * @return Parsed response.
     * @throws IOException on parse errors.
     */
    T parseResponse(final String responseStr) throws IOException;
}
