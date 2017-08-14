package com.darksci.pardot.api.request.prospect;

/**
 * For deleting Prospects using Pardot's API.
 */
public class ProspectDeleteRequest extends ProspectActionRequest<ProspectDeleteRequest> {
    @Override
    public String getApiEndpoint() {
        return "prospect/do/delete";
    }
}
