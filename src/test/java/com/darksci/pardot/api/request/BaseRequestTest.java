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
     * Stand-in implementation for our tests.
     */
    private static class TestRequest extends BaseRequest<TestRequest> {
        @Override
        public String getApiEndpoint() {
            return "/just/a/test";
        }
    }

}
