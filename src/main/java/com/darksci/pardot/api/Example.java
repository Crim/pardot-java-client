package com.darksci.pardot.api;

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
     * Example code.
     */
    public static void example() {
        /*
         * Create a new configuration object with your Pardot credentials.
         *
         * This configuration also allows you to define some optional details on your connection,
         * such as using an outbound proxy (authenticated or not).
         */
        final Configuration configuration = new Configuration("YourPardotUserNameHere", "PardotPassword", "UserKey");

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
        final Configuration configuration = new Configuration("YourPardotUserNameHere", "PardotPassword", "UserKey");
        try (final PardotClient client = new PardotClient(configuration)) {
            // Use client instance as needed
            client.accountRead(new AccountReadRequest());

            // client.close() is automatically called at the end of the try {} block.
        }
    }
}
