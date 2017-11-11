package com.darksci.pardot.api.response.listmembership;

import com.darksci.pardot.api.response.list.ListMembership;

/**
 * Represents API response for a List read request.
 */
public class ListMembershipReadResponse {
    private ListMembership listMembership;

    public ListMembership getListMembership() {
        return listMembership;
    }

    @Override
    public String toString() {
        return "ListMembershipReadResponse{"
            + "listMembership=" + listMembership
            + '}';
    }
}
