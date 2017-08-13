package com.darksci.pardot.api.request.account;


import com.darksci.pardot.api.request.BaseRequest;

/**
 * Used to generate an Account read request.
 */
public class AccountReadRequest extends BaseRequest<AccountReadRequest> {

    @Override
    public String getApiEndpoint() {
        return "account/do/read";
    }
}
