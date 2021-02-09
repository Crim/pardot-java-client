/**
 * Copyright 2017, 2018, 2019, 2020 Stephen Powis https://github.com/Crim/pardot-java-client
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

package com.darksci.pardot.api;

import com.darksci.pardot.api.auth.AuthorizationServer;
import com.darksci.pardot.api.config.Configuration;
import com.darksci.pardot.api.request.DateParameter;
import com.darksci.pardot.api.request.account.AccountReadRequest;
import com.darksci.pardot.api.request.campaign.CampaignQueryRequest;
import com.darksci.pardot.api.response.account.Account;
import com.darksci.pardot.api.response.campaign.CampaignQueryResponse;

/**
 * Just a simple example code showing basic usage.
 */
public class Example {

    /**
     * Example code using Salesforce SSO authentication.
     * This method of authenticating to the Pardot API is set to replace the old
     * Pardot Username and Password method of authentication and should be used moving forward.
     */
    public static void example_salesforceSsoAuthentication() {
        /*
         * Create a new configuration object with your Pardot credentials.
         *
         * This configuration also allows you to define some optional details on your connection,
         * such as using an outbound proxy (authenticated or not).
         */
        final ConfigurationBuilder configuration = Configuration.newBuilder()
            .withSsoLogin(
                "YourSalesforceUsername",
                "YourSalesforcePassword",
                "YourConnectedAppClientId",
                "YourConnectedAppClientSecret",
                "YourPardotBusinessUnitId"
            );

        /*
         * Optionally you can explicitly select which API version to use. If none is explicitly selected
         * the library will default to version 3, but the library will automatically upgrade to version
         * 4 if required to do so.
         */
        configuration.withApiVersion3();

        /* Or */
        configuration.withApiVersion4();

        /*
         * Create an instance of PardotClient, passing your configuration.
         */
        final PardotClient client = new PardotClient(configuration);

        /*
         * The client will automatically authenticate when you make your first request, no need to
         * explicitly login.
         *
         * Lets create a simple Account request, and execute it.
         */
        final AccountReadRequest accountReadRequest = new AccountReadRequest();
        final Account account = client.accountRead(accountReadRequest);

        /*
         * Or lets do a more complex Campaign search.
         */
        final CampaignQueryRequest campaignQueryRequest = new CampaignQueryRequest()
            .withUpdatedAfter(DateParameter.last7Days())
            .withIdLessThan(1234L)
            .withSortById()
            .withSortOrderDescending();
        final CampaignQueryResponse.Result campaignQueryResponse = client.campaignQuery(campaignQueryRequest);

        /*
         * And when you're done, call close on PardotClient.
         */
        client.close();
    }

    /**
     * Example code using Salesforce SSO authentication with a previously acquired refresh_token.
     */
    public static void example_salesforceSsoRefreshTokenAuthentication() {
        /*
         * Create a new configuration object with your Pardot credentials.
         *
         * This configuration also allows you to define some optional details on your connection,
         * such as using an outbound proxy (authenticated or not).
         */
        final ConfigurationBuilder configuration = Configuration.newBuilder()
            .withSsoRefreshTokenLogin(
                "YourPreviouslyAcquiredRefreshToken",
                "YourConnectedAppClientId",
                "YourConnectedAppClientSecret",
                "YourPardotBusinessUnitId"
            );

        /*
         * Optionally you can explicitly select which API version to use. If none is explicitly selected
         * the library will default to version 3, but the library will automatically upgrade to version
         * 4 if required to do so.
         */
        configuration.withApiVersion3();

        /* Or */
        configuration.withApiVersion4();

        /*
         * Create an instance of PardotClient, passing your configuration.
         */
        final PardotClient client = new PardotClient(configuration);

        /*
         * The client will automatically authenticate when you make your first request, no need to
         * explicitly login.
         *
         * Lets create a simple Account request, and execute it.
         */
        final AccountReadRequest accountReadRequest = new AccountReadRequest();
        final Account account = client.accountRead(accountReadRequest);

        /*
         * Or lets do a more complex Campaign search.
         */
        final CampaignQueryRequest campaignQueryRequest = new CampaignQueryRequest()
            .withUpdatedAfter(DateParameter.last7Days())
            .withIdLessThan(1234L)
            .withSortById()
            .withSortOrderDescending();
        final CampaignQueryResponse.Result campaignQueryResponse = client.campaignQuery(campaignQueryRequest);

        /*
         * And when you're done, call close on PardotClient.
         */
        client.close();
    }

    /**
     * Example code using Salesforce SSO authentication against a sandbox/test org.
     */
    public static void example_salesforceSso_sandboxAuthorizationOrg() {

        /**
         * Create builder.
         */
        final ConfigurationBuilder configuration = Configuration.newBuilder();

        /**
         * You can pass an optional {@link AuthorizationServer} parameter to the SSO Authentication
         * configuration methods.
         *
         * You can create your own instance by calling new AuthorizationServer("http://your.host.name.here", "/uri/here")
         *    OR
         * You can use one of the ready made instances:
         *  - AuthorizationServer.DEFAULT_SALESFORCE (Used to authenticate against Production Orgs)
         *  - AuthorizationServer.SANDBOX_SALESFORCE (Used to authenticate against Sandbox Instances)
         */
        configuration.withSsoLogin(
                "YourSalesforceUsername",
                "YourSalesforcePassword",
                "YourConnectedAppClientId",
                "YourConnectedAppClientSecret",
                "YourPardotBusinessUnitId",
                AuthorizationServer.SANDBOX_SALESFORCE
            );

        // SSO RefreshToken Login.
        configuration.withSsoRefreshTokenLogin(
            "YourPreviouslyAcquiredRefreshToken",
            "YourConnectedAppClientId",
            "YourConnectedAppClientSecret",
            "YourPardotBusinessUnitId",
            AuthorizationServer.SANDBOX_SALESFORCE
        );
    }

    /**
     * Example code using Pardot Username and Password Authentication.
     * This method of authenticating to the Pardot API to be removed around
     * end of 2020.
     */
    public static void example_pardotUsernameAndPasswordAuthentication() {
        /*
         * Create a new configuration object with your Pardot credentials.
         *
         * This configuration also allows you to define some optional details on your connection,
         * such as using an outbound proxy (authenticated or not).
         */
        final ConfigurationBuilder configuration = Configuration.newBuilder()
            .withUsernameAndPasswordLogin(
                "YourPardotUsername",
                "YourPardotPassword",
                "YourPardotUserKey"
            );

        /*
         * Optionally you can explicitly select which API version to use. If none is explicitly selected
         * the library will default to version 3, but the library will automatically upgrade to version
         * 4 if required to do so.
         */
        configuration.withApiVersion3();

        /* Or */
        configuration.withApiVersion4();

        /*
         * Create an instance of PardotClient, passing your configuration.
         */
        final PardotClient client = new PardotClient(configuration);

        /*
         * The client will automatically authenticate when you make your first request, no need to
         * explicitly login.
         *
         * Lets create a simple Account request, and execute it.
         */
        final AccountReadRequest accountReadRequest = new AccountReadRequest();
        final Account account = client.accountRead(accountReadRequest);

        /*
         * Or lets do a more complex Campaign search.
         */
        final CampaignQueryRequest campaignQueryRequest = new CampaignQueryRequest()
            .withUpdatedAfter(DateParameter.last7Days())
            .withIdLessThan(1234L)
            .withSortById()
            .withSortOrderDescending();
        final CampaignQueryResponse.Result campaignQueryResponse = client.campaignQuery(campaignQueryRequest);

        /*
         * And when you're done, call close on PardotClient.
         */
        client.close();
    }

    /**
     * Example code showing off Auto-closable.
     */
    public static void autoCloseableExample() {
        /*
         * Since PardotClient implements Autoclosable, you can also use the try-with-resources pattern.
         */
        final ConfigurationBuilder configuration = Configuration.newBuilder()
            .withUsernameAndPasswordLogin("YourPardotUserNameHere", "PardotPassword", "UserKey");

        try (final PardotClient client = new PardotClient(configuration)) {
            // Use client instance as needed
            client.accountRead(new AccountReadRequest());

            // client.close() is automatically called at the end of the try {} block.
        }
    }
}
