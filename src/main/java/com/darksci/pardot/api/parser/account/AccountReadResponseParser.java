package com.darksci.pardot.api.parser.account;

import com.darksci.pardot.api.parser.JacksonFactory;
import com.darksci.pardot.api.parser.ResponseParser;
import com.darksci.pardot.api.response.account.Account;
import com.darksci.pardot.api.response.account.AccountReadResponse;

import java.io.IOException;

/**
 * Handles parsing AccountRead API responses into POJOs.
 */
public class AccountReadResponseParser implements ResponseParser<Account> {
    @Override
    public Account parseResponse(final String responseStr) throws IOException {
        return JacksonFactory.newInstance().readValue(responseStr, AccountReadResponse.class).getAccount();
    }
}
