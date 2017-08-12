package com.pardot.api.request;

import java.util.HashMap;
import java.util.Map;

/**
 * Base Request Properties.
 */
public abstract class BaseRequest<T> implements Request {
    // Param holder
    private Map<String, Object> params = new HashMap<>();

    protected <T> T getParam(final String name) {
        return (T) params.getOrDefault(name, null);
    }

    protected <T> T setParam(final String name, Object value) {
        if (value == null) {
            params.remove(name);
        } else {
            params.put(name, value);
        }
        return (T) this;
    }

    @Override
    public Map<String, String> getRequestParameters() {
        // Clone the params and cast to string
        Map<String, String> requestParams = new HashMap<>();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            requestParams.put(entry.getKey(), entry.getValue().toString());
        }
        return requestParams;
    }
}
