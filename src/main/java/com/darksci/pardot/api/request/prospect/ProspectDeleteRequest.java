package com.darksci.pardot.api.request.prospect;

import com.darksci.pardot.api.request.BaseRequest;

/**
 * For deleting Prospects using Pardot's API.
 */
public class ProspectDeleteRequest extends BaseRequest<ProspectDeleteRequest> {
    @Override
    public String getApiEndpoint() {
        return "prospect/do/delete";
    }

    /**
     * Define which prospect to delete by Id.
     * @param prospectId Id of prospect to delete.
     * @return RequestBuilder
     */
    public ProspectDeleteRequest withProspectId(final Long prospectId) {
        setParam("email", null);
        return setParam("id", prospectId);
    }

    /**
     * Define which prospect to delete by email.
     * @param email Email of prospect to delete.
     * @return RequestBuilder
     */
    public ProspectDeleteRequest withProspectEmail(final String email) {
        setParam("id", null);
        return setParam("email", email);
    }
}
