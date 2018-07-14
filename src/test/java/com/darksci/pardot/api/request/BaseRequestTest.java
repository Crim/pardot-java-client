/**
 * Copyright 2017, 2018 Stephen Powis https://github.com/Crim/pardot-java-client
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

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Validates some of the behaviors defined in BaseRequest.
 */
public class BaseRequestTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseRequestTest.class);

    /**
     * Validates that withCollectionParam works as we expect and preserves ordering.
     */
    @Test
    public void testWithCollectionParam() {
        final String paramName = "my_param";

        // Create request
        final TestRequest request = new TestRequest();
        request.withCollectionParam(paramName, "value1");
        request.withCollectionParam(paramName, "value2");
        request.withCollectionParam(paramName, "value3");

        // Get out the params
        final Map<String, String> requestParams = request.getRequestParameters();

        // Validate
        assertEquals("Should have 3 params", 3, requestParams.size());
        assertEquals("Has first param", "value1", requestParams.get(paramName + "[0]"));
        assertEquals("Has first param", "value2", requestParams.get(paramName + "[1]"));
        assertEquals("Has first param", "value3", requestParams.get(paramName + "[2]"));
    }

    /**
     * Validates that withCollectionParam will remove the param if null is passed.
     */
    @Test
    public void testWithCollectionParamPassingNullRemovesTheParam() {
        final String paramName = "my_param";

        // Create request
        final TestRequest request = new TestRequest();
        request.withCollectionParam(paramName, "value1");
        request.withCollectionParam(paramName, "value2");
        request.withCollectionParam(paramName, "value3");

        // This should remove it.
        request.withCollectionParam(paramName, null);

        // Get out the params
        final Map<String, String> requestParams = request.getRequestParameters();

        // Validate
        assertEquals("Should have 0 params", 0, requestParams.size());
    }

    /**
     * Validates that withCollectionParam gracefully handles being passed a collection.
     */
    @Test
    public void testWithCollectionParamPassingACollection() {
        final String paramName = "my_param";

        final List<String> collectionOfValues = new ArrayList<>();
        collectionOfValues.add("value2");
        collectionOfValues.add("value3");

        // Create request
        final TestRequest request = new TestRequest();
        request.withCollectionParam(paramName, "value1");

        // Try to add a collection
        request.withCollectionParam(paramName, collectionOfValues);

        // Get out the params
        final Map<String, String> requestParams = request.getRequestParameters();

        // Validate
        assertEquals("Should have 3 params", 3, requestParams.size());
        assertEquals("Has first param", "value1", requestParams.get(paramName + "[0]"));
        assertEquals("Has first param", "value2", requestParams.get(paramName + "[1]"));
        assertEquals("Has first param", "value3", requestParams.get(paramName + "[2]"));
    }

    /**
     * Validates that withCollectionParams works interchangably with withCollectionParam
     */
    @Test
    public void testWithCollectionParams() {
        final String paramName = "my_param";

        final List<String> collectionOfValues = new ArrayList<>();
        collectionOfValues.add("value2");
        collectionOfValues.add("value3");

        // Create request
        final TestRequest request = new TestRequest();
        request.withCollectionParam(paramName, "value1");

        // Try call withCollectionParams()
        request.withCollectionParams(paramName, collectionOfValues);

        // Get out the params
        final Map<String, String> requestParams = request.getRequestParameters();

        // Validate
        assertEquals("Should have 3 params", 3, requestParams.size());
        assertEquals("Has first param", "value1", requestParams.get(paramName + "[0]"));
        assertEquals("Has first param", "value2", requestParams.get(paramName + "[1]"));
        assertEquals("Has first param", "value3", requestParams.get(paramName + "[2]"));
    }

    /**
     * Validates if you set a boolean parameter as true, it sends the string 'true'.
     */
    @Test
    public void testWithBooleanParamTrue() {
        final String paramName = "my_param";

        // Create request
        final TestRequest request = new TestRequest();
        request.setBooleanParam(paramName, true);

        // Get out the params
        final Map<String, String> requestParams = request.getRequestParameters();

        // Validate
        assertEquals("Should have 1 params", 1, requestParams.size());
        assertEquals("Should be 'true'", "true", requestParams.get(paramName));
    }

    /**
     * Validates if you set a boolean parameter as false, it sends the string 'false'.
     */
    @Test
    public void testWithBooleanParamFalse() {
        final String paramName = "my_param";

        // Create request
        final TestRequest request = new TestRequest();
        request.setBooleanParam(paramName, false);

        // Get out the params
        final Map<String, String> requestParams = request.getRequestParameters();

        // Validate
        assertEquals("Should have 1 params", 1, requestParams.size());
        assertEquals("Should be 'false'", "false", requestParams.get(paramName));
    }

    /**
     * Stand-in implementation for our tests.
     */
    private static class TestRequest extends BaseRequest<TestRequest> {
        @Override
        public String getApiEndpoint() {
            return "/just/a/test";
        }
    }
}
