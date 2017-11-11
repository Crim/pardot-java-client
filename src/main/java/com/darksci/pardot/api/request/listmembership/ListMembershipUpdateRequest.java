package com.darksci.pardot.api.request.listmembership;

import com.darksci.pardot.api.request.BaseRequest;
import com.darksci.pardot.api.response.list.ListMembership;

/**
 * For Updating existing ListMemberships using Pardot's API.
 */
public class ListMembershipUpdateRequest extends BaseRequest<ListMembershipUpdateRequest> {
    @Override
    public String getApiEndpoint() {
        return "listMembership/do/update";
    }

    /**
     * Define the listMembership you want to update in pardot.
     * @param listMembership The listMembership you want to update in pardot.
     * @return ListUpdateRequest builder.
     */
    public ListMembershipUpdateRequest withListMembership(final ListMembership listMembership) {
        setParam("id", listMembership.getId());
        setParam("list_id", listMembership.getListId());
        setParam("prospect_id", listMembership.getProspectId());
        setBooleanParam("opted_out", listMembership.getOptedOut());
        return this;
    }
}
