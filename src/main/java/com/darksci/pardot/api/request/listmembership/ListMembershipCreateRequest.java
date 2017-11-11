package com.darksci.pardot.api.request.listmembership;

import com.darksci.pardot.api.request.BaseRequest;
import com.darksci.pardot.api.response.list.ListMembership;

/**
 * For creating new Lists using Pardot's API.
 */
public class ListMembershipCreateRequest extends BaseRequest<ListMembershipCreateRequest> {
    @Override
    public String getApiEndpoint() {
        return "listMembership/do/create";
    }

    /**
     * Define the list you want to create in pardot.
     * @param listMembership The list membership you want to create in pardot.
     * @return ListMembershipCreateRequest builder.
     */
    public ListMembershipCreateRequest withListMembership(final ListMembership listMembership) {
        setParam("list_id", listMembership.getListId());
        setParam("prospect_id", listMembership.getProspectId());
        return this;
    }
}
