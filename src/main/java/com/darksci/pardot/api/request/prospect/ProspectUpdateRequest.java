package com.darksci.pardot.api.request.prospect;

/**
 * For updating existing Prospects using Pardot's API.
 */
public class ProspectUpdateRequest extends ProspectModifyRequest<ProspectUpdateRequest> {

    @Override
    public String getApiEndpoint() {
        return "prospect/do/update";
    }
}
