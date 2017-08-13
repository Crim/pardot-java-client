package com.darksci.pardot.api.rest;

import com.darksci.pardot.api.Configuration;
import com.darksci.pardot.api.request.Request;

import java.io.IOException;

/**
 * Interface for making HTTP calls.
 */
public interface RestClient {
    /**
     * Initializes the RestClient implementation.
     * Any setup or resource allocation should happen here.
     * @param configuration Pardot Api Configuration.
     */
    void init(final Configuration configuration);

    /**
     * Make a request against the Pardot API.
     * @param request The request to submit.
     * @return The response, in UTF-8 String format.
     * @throws IOException if something goes wrong?
     */
    RestResponse submitRequest(final Request request) throws IOException;
}
