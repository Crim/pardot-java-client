package com.pardot.api.request;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Base Request Properties.
 * @param <T> The class type that extends this so we can return the appropriate value.
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

    /**
     * Utility method to set a boolean parameter, converts boolean into string "true"/"false"
     * @param parameterName Name of the parameter to set.
     * @param booleanValue Boolean value to store.
     */
    protected <T> T setBooleanParam(final String parameterName, final boolean booleanValue) {
        String value = "true";
        if (!booleanValue) {
            value = "false";
        }
        return setParam(parameterName, booleanValue);
    }

    /**
     * Returns all set RequestParameters for the Request.
     */
    @Override
    public Map<String, String> getRequestParameters() {
        // Clone the params and cast to string
        Map<String, String> requestParams = new HashMap<>();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            final String parameterName = entry.getKey();
            final Object value = entry.getValue();

            // If the value is a collection
            if (value instanceof Collection) {
                // Convert to an array => Example: parameterName[0],parameterName[1],...
                int index = 0;
                for (Object object: ((Collection)value)) {
                    requestParams.put(parameterName + "[" + index + "]", object.toString());
                    index++;
                }
            } else {
                // Convert it to a string.
                requestParams.put(parameterName, entry.getValue().toString());
            }
        }
        return requestParams;
    }
}
