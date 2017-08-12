package com.pardot.api.rest;

import com.pardot.api.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Mock Rest Client for testing.
 */
public class MockRestClient implements RestClient {
    private static final Logger logger = LoggerFactory.getLogger(MockRestClient.class);

    @Override
    public void init(final Configuration configuration) {

    }
}
