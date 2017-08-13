package com.darksci.pardot.api.rest.handlers;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Returns response as a string.
 */
public class StringResponseHandler implements ResponseHandler<String> {
    @Override
    public String handleResponse(final HttpResponse response) throws IOException {

        final HttpEntity entity = response.getEntity();
        final String responseStr = entity != null ? EntityUtils.toString(entity) : null;

        // Fully consume entity.
        EntityUtils.consume(entity);

        // Construct return object
        return responseStr;
    }
}
