package com.darksci.pardot.api.rest.handlers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;

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
        final JacksonXmlModule module = new JacksonXmlModule();
        module.setDefaultUseWrapper(false);
        mapper = new XmlMapper(module);

        // Configure it
        mapper
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
            .registerModule(new JodaModule())
            .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
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
            try {
                return parseResponse(returnStr);
            } catch (JsonParseException exception) {
                // if underlying input contains invalid content
                logger.error("Caught exception {}", exception.getMessage(), exception);
            } catch (JsonMappingException exception) {
                // if the input JSON structure does not match structure
                logger.error("Caught exception {}", exception.getMessage(), exception);
                // TODO throw parsing exception
            } catch (IOException exception) {
                // if a low-level I/O problem happens when parsing
                logger.error("Caught exception {}", exception.getMessage(), exception);
            }
            return null;
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
    public abstract T parseResponse(final String responseStr) throws IOException;

    /**
     * @return Jackson Mapper instance.
     */
    protected ObjectMapper getMapper() {
        return mapper;
    }

    /**
     * Utility/debug method for logging a response.
     */
    protected void logResponse(final String response) {
        logger.info("Response: {}", response);
    }
}
