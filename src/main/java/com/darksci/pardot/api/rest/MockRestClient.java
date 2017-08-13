package com.darksci.pardot.api.rest;

import com.darksci.pardot.api.Configuration;
import com.darksci.pardot.api.request.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * A Mock Rest Client for testing.
 */
public class MockRestClient implements RestClient {
    private static final Logger logger = LoggerFactory.getLogger(MockRestClient.class);

    @Override
    public void init(final Configuration configuration) {

    }

    @Override
    public RestResponse submitRequest(final Request request) throws IOException {
        return null;
    }
}
