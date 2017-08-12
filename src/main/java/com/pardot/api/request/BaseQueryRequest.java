package com.pardot.api.request;

/**
 *
 */
public abstract class BaseQueryRequest<T> extends BaseRequest<T> {

    // Standard Query Filters
    public T withIdGreaterThan(final Integer idGreaterThan) {
        return setParam("id_greater_than", idGreaterThan);
    }

    public T withIdLessThan(final Integer idLessThan) {
        return setParam("id_less_than", idLessThan);
    }


    public T withCreatedAfter(DateParameter dateParameter) {
        return setParam("created_after", dateParameter);
    }

    public T withCreatedBefore(final DateParameter createdBefore) {
        return setParam("created_before", createdBefore);
    }

    protected T withUpdatedAfter(final DateParameter dateParameter) {
        return setParam("updated_after", dateParameter);
    }

    protected T withUpdatedBefore(final DateParameter dateParameter) {
        return setParam("updated_before", dateParameter);
    }

    public DateParameter getCreatedAfter() {
        return getParam("created_after");
    }

    public DateParameter getCreatedBefore() {
        return getParam("created_before");
    }

    public Integer getIdGreaterThan() {
        return getParam("id_greater_than");
    }

    public Integer getIdLessThan() {
        return getParam("id_less_than");
    }

    // Optional Sorting Options
    protected T withSortByCreatedAt() {
        return withSortBy("created_at");
    }
    protected T withSortByUpdatedAt() {
        return withSortBy("updated_at");
    }
    protected T withSortByName() {
        return withSortBy("name");
    }

    protected T withSortById() {
        return withSortBy("id");
    }


    // Standard Query Options
    public Integer getLimit() {
        return getParam("limit");
    }

    public T withLimit(final Integer limit) {
        return setParam("limit", limit);
    }

    public Integer getOffset() {
        return getParam("offset");
    }

    public T withOffset(final Integer offset) {
        return setParam("offset", offset);
    }

    public String getSortBy() {
        return getParam("sort_by");
    }

    public T withSortBy(final String sortBy) {
        return setParam("sort_by", sortBy);
    }

    public String getSortOrder() {
        return getParam("sort_order");
    }

    public T withSortOrder(final String sortOrder) {
        return setParam("sort_order", sortOrder);
    }

    public T withSortOrderDescending() {
        return withSortOrder("descending");
    }

    public T withSortOrderAscending() {
        return withSortOrder("ascending");
    }

    /**
     * Marked as protected because I'm not sure if all objects support this or not.
     */
    protected T withArchivedOnly(boolean archivedOnly) {
        String value = "false";
        if (archivedOnly) {
            value = "true";
        }
        return setParam("deleted", archivedOnly);
    }
}
