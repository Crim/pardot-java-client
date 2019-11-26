/**
 * Copyright 2017, 2018, 2019 Stephen Powis https://github.com/Crim/pardot-java-client
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
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Base Request Properties.
 * @param <Self> The class type that extends this so we can return the appropriate value.
 */
public abstract class BaseRequest<Self> implements Request {
    // Param holder
    private Map<String, Object> params = new HashMap<>();

    @SuppressWarnings("unchecked")
    protected <Self> Self getParam(final String name) {
        return (Self) params.getOrDefault(name, null);
    }

    @SuppressWarnings("unchecked")
    protected Self setParam(final String name, Object value) {
        if (value == null) {
            params.remove(name);
        } else {
            params.put(name, value);
        }
        return (Self) this;
    }

    /**
     * Utility method to set a boolean parameter, converts boolean into string "true"/"false".
     *
     * @param parameterName Name of the parameter to set.
     * @param booleanValue Boolean value to store.
     * @return BaseRequest
     */
    protected Self setBooleanParam(final String parameterName, final boolean booleanValue) {
        // We store a Boolean, which when toString() is called returns 'true' or 'false'
        // which inredirectly gets us the result we want.
        return setParam(parameterName, booleanValue);
    }

    protected Self withCollectionParam(final String name, final Object value) {
        // Sanity test, if we got passed null, we should remove the collection
        if (value == null) {
            // This should remove it.
            return setParam(name, null);
        }

        // Sanity test, if we got passed a collection, we should handle it gracefully.
        if (value instanceof Collection) {
            return withCollectionParams(name, (Collection) value);
        }

        Collection<Object> existingValues = getParam(name);
        if (existingValues == null) {
            // Using linked hash set to preserve ordering.
            existingValues = new LinkedHashSet<>();
        }

        existingValues.add(value);

        return setParam(name, existingValues);
    }

    @SuppressWarnings("unchecked")
    protected Self withCollectionParams(final String name, Collection<?> values) {
        for (final Object value: values) {
            withCollectionParam(name, value);
        }
        return (Self) this;
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
