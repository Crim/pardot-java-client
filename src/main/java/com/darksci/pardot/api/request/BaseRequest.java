/**
 * Copyright 2017 Stephen Powis
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.darksci.pardot.api.request;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
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

    protected T setParam(final String name, Object value) {
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
     * @return BaseRequest
     */
    protected T setBooleanParam(final String parameterName, final boolean booleanValue) {
        String value = "true";
        if (!booleanValue) {
            value = "false";
        }
        return setParam(parameterName, booleanValue);
    }

    protected T withCollectionParam(final String name, final Object value) {
        Collection<Object> values = getParam(name);
        if (values == null) {
            values = new HashSet<>();
        }
        values.add(value);

        return setParam(name, values);
    }

    protected T withCollectionParams(final String name, Collection<?> values) {
        for (final Object value: values) {
            withCollectionParam(name, value);
        }
        return (T) this;
    }

    /**
     * Returns all set RequestParameters for the Request.
     * @return All set Request Parameters generated from Request builder.
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
