package com.darksci.pardot.api.request;

import java.util.Map;

/**
 * Interface for all Requests to implement.
 */
public interface Request {

    /**
     * @return The name of the end point this request uses. Example: "campaign", "user", etc..
     */
    String getApiEndpoint();

    /**
     * @return correctly formatted request parameters.
     */
    Map<String, String> getRequestParameters();
}
