package com.darksci.pardot.api.response.prospectaccount;




/**
 * Represents the response from a Prospect Read API request.
 */
public class ProspectAccountReadResponse {
    private ProspectAccount prospectAccount;

    public ProspectAccount getProspectAccount() {
        return prospectAccount;
    }

    @Override
    public String toString() {
        return "ProspectReadResponse{"
            + "prospectAccount=" + prospectAccount
            + '}';
    }
}
