package com.pardot.api.rest;

import com.pardot.api.Configuration;

/**
 * Interface for making HTTP calls.
 */
public interface RestClient {
    void init(final Configuration configuration);
}
