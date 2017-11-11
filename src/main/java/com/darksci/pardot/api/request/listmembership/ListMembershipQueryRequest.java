package com.darksci.pardot.api.request.listmembership;

import com.darksci.pardot.api.request.BaseQueryRequest;
import com.darksci.pardot.api.request.DateParameter;

import java.util.List;

/**
 * Used to query Lists over the Pardot API.
 */
public class ListMembershipQueryRequest extends BaseQueryRequest<ListMembershipQueryRequest> {
    @Override
    public String getApiEndpoint() {
        return "listMembership/do/query";
    }

    // Query criteria

    @Override
    public ListMembershipQueryRequest withArchivedOnly(boolean onlyReturnArchived) {
        return super.withArchivedOnly(onlyReturnArchived);
    }

    /**
     * Search for memberships for a single specific list.
     * @param listId List Id to search for memberships for.
     * @return ListMembershipQueryRequest instance.
     */
    public ListMembershipQueryRequest withListId(final long listId) {
        setParam("list_id", listId);
        return this;
    }

    /**
     * Search for membership for multiple lists.
     * @param listIds List of one or more lists to filter by
     * @return ListMembershipQueryRequest instance.
     */
    public ListMembershipQueryRequest withListIds(final List<Long> listIds) {
        return super.withCollectionParams("list_id", listIds);
    }

    /**
     * Search for memberships for a single prospect.
     * @param prospectId prospect Id to search for memberships for.
     * @return ListMembershipQueryRequest instance.
     */
    public ListMembershipQueryRequest withProspectId(final long prospectId) {
        setParam("prospect_id", prospectId);
        return this;
    }

    /**
     * Search for membership for multiple prospects.
     * @param prospectIds List of one or more prospects to filter by
     * @return ListMembershipQueryRequest instance.
     */
    public ListMembershipQueryRequest withPropectIds(final List<Long> prospectIds) {
        return super.withCollectionParams("prospect_id", prospectIds);
    }

    @Override
    public ListMembershipQueryRequest withUpdatedAfter(final DateParameter createdAfter) {
        return super.withUpdatedAfter(createdAfter);
    }

    @Override
    public ListMembershipQueryRequest withUpdatedBefore(final DateParameter createdAfter) {
        return super.withUpdatedBefore(createdAfter);
    }

    // Sort options.

    @Override
    public ListMembershipQueryRequest withSortByCreatedAt() {
        return super.withSortByCreatedAt();
    }

    @Override
    public ListMembershipQueryRequest withSortById() {
        return super.withSortById();
    }
}
