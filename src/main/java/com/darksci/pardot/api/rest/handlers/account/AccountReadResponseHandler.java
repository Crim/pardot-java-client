package com.darksci.pardot.api.rest.handlers.account;

import com.darksci.pardot.api.response.account.Account;
import com.darksci.pardot.api.response.account.AccountReadResponse;
import com.darksci.pardot.api.response.campaign.Campaign;
import com.darksci.pardot.api.response.campaign.CampaignReadResponse;
import com.darksci.pardot.api.rest.handlers.BaseResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Handles parsing AccountRead API responses into POJOs.
 */
public class AccountReadResponseHandler extends BaseResponseHandler<Account> {
    @Override
    public Account parseResponse(final String responseStr) throws IOException {
        return getMapper().readValue(responseStr, AccountReadResponse.class).getAccount();
    }
}
