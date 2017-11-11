package com.darksci.pardot.api.request.list;

import com.darksci.pardot.api.request.BaseQueryRequest;
import com.darksci.pardot.api.request.DateParameter;

/**
 * Used to query Lists over the Pardot API.
 */
public class ListQueryRequest extends BaseQueryRequest<ListQueryRequest> {
    @Override
    public String getApiEndpoint() {
        return "list/do/query";
    }

    // Query criteria

    @Override
    public ListQueryRequest withUpdatedAfter(final DateParameter createdAfter) {
        return super.withUpdatedAfter(createdAfter);
    }

    @Override
    public ListQueryRequest withUpdatedBefore(final DateParameter createdAfter) {
        return super.withUpdatedBefore(createdAfter);
    }

    /**
     * Filter by list name
     * @param name Name to search for.
     * @return ListQueryRequest instance.
     */
    public ListQueryRequest withName(final String name) {
        return setParam("name", name);
    }

    // Sort options.

    @Override
    public ListQueryRequest withSortByCreatedAt() {
        return super.withSortByCreatedAt();
    }

    @Override
    public ListQueryRequest withSortByUpdatedAt() {
        return super.withSortByUpdatedAt();
    }

    @Override
    public ListQueryRequest withSortById() {
        return super.withSortById();
    }

    @Override
    public ListQueryRequest withSortByName() {
        return super.withSortByName();
    }
}
