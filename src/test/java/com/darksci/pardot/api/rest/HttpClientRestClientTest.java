package com.darksci.pardot.api.rest;

import categories.IntegrationTest;
import com.darksci.pardot.api.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.experimental.categories.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Integration/End-to-End test over HttpClientRestClient.
 */
@Category(IntegrationTest.class)
public class HttpClientRestClientTest {
    private static final Logger logger = LoggerFactory.getLogger(HttpClientRestClientTest.class);

    private Configuration testConfig;
    private HttpClientRestClient restClient;

    @Before
    public void setup() throws IOException {
        final InputStream inputStream = getClass().getClassLoader().getResourceAsStream("test_credentials.properties");

        // Load properties
        Properties properties = new Properties();
        properties.load(inputStream);
        inputStream.close();

        // Load in config
        testConfig = new Configuration(
            properties.getProperty("username"),
            properties.getProperty("password"),
            properties.getProperty("user_key")
        );

        logger.info("Config: {}", testConfig);

        // Create and init rest client
        restClient = new HttpClientRestClient();
        restClient.init(testConfig);
    }

    @After
    public void tearDown() {
        testConfig = null;
    }
}