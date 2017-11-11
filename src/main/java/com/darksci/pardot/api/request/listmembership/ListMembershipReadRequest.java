package com.darksci.pardot.api.request.listmembership;


import com.darksci.pardot.api.request.BaseRequest;

/**
 * Used to generate a List read request.
 */
public class ListMembershipReadRequest extends BaseRequest<ListMembershipReadRequest> {

    @Override
    public String getApiEndpoint() {
        return "listMembership/do/read";
    }

    /**
     * Retrieve membership by id.
     * @param id Id of the ListMembership.
     * @return The ListMembershipReadRequest
     */
    public ListMembershipReadRequest selectById(final long id) {
        setParam("list_id", null);
        setParam("prospect_id", null);
        return setParam("id", id);
    }

    /**
     * Retrieve membership by listId and prospectId.
     * @param listId Id of the List.
     * @param prospectId Id of the prospect.
     * @return The ListMembershipReadRequest
     */
    public ListMembershipReadRequest selectByListIdAndProspectId(final long listId, final long prospectId) {
        setParam("id", null);
        setParam("prospect_id", prospectId);
        return setParam("list_id", listId);
    }
}
