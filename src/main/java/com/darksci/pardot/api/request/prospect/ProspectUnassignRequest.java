package com.darksci.pardot.api.request.prospect;

/**
 * Request for unassigning a Prospect to a user.
 */
public class ProspectUnassignRequest extends ProspectActionRequest<ProspectUnassignRequest> {

    @Override
    public String getApiEndpoint() {
        return "prospect/do/unassign";
    }
}
