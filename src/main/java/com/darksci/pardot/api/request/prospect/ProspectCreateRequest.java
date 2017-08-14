package com.darksci.pardot.api.request.prospect;

/**
 * For creating new Prospects using Pardot's API.
 */
public class ProspectCreateRequest extends ProspectModifyRequest<ProspectCreateRequest> {
    @Override
    public String getApiEndpoint() {
        return "prospect/do/create";
    }

}
