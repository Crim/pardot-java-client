package com.darksci.pardot.api.request.prospect;

/**
 * For upserting Prospects using Pardot's API.
 */
public class ProspectUpsertRequest extends ProspectModifyRequest<ProspectUpsertRequest> {
    @Override
    public String getApiEndpoint() {
        return "prospect/do/upsert";
    }
}
