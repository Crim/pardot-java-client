package com.pardot.api.rest.handlers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Handles a HTTP response and returns the value as a string.
 *
 * @param <T> The type of object your response handler returns.
 */
public abstract class BaseResponseHandler<T> implements ResponseHandler<T> {
    private static final Logger logger = LoggerFactory.getLogger(BaseResponseHandler.class);

    /**
     * Jackson Mapper instance.
     */
    private final ObjectMapper mapper;

    /**
     * Default constructor.
     */
    public BaseResponseHandler() {
        // Create new mapper
        mapper = new XmlMapper();

        // Configure it
        mapper
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public T handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
        int status = response.getStatusLine().getStatusCode();
        if (status >= 200 && status < 300) {
            HttpEntity entity = response.getEntity();
            final String returnStr = entity != null ? EntityUtils.toString(entity) : null;

            // Fully consume entity.
            EntityUtils.consume(entity);

            // Return value
            return parseResponse(returnStr);
        } else {
            throw new ClientProtocolException("Unexpected response status: " + status);
        }
    }

    /**
     * Abstract parseResponse method.  We give you the String representation of the response, your job is
     * to parse into something more useful and return it!
     * @param responseStr The response string from the request.
     * @return Parsed response.
     */
    public abstract T parseResponse(final String responseStr);

    /**
     * @return Jackson Mapper instance.
     */
    protected ObjectMapper getMapper() {
        return mapper;
    }
}
