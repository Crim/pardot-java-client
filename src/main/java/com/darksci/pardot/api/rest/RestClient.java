package com.darksci.pardot.api.rest;

import com.darksci.pardot.api.Configuration;

/**
 * Interface for making HTTP calls.
 */
public interface RestClient {
    void init(final Configuration configuration);
}
