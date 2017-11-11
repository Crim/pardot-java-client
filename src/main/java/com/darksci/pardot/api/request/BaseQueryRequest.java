/**
 * Copyright 2017 Stephen Powis https://github.com/Crim/pardot-java-client
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.darksci.pardot.api.request;

/**
 * Base Query Request.  Contains common properties/query parameters across differing objects.
 * @param <T> The class type that extends this so we can return the appropriate value.
 */
public abstract class BaseQueryRequest<T> extends BaseRequest<T> {

    // Standard Query Filters

    /**
     * Add constraint where Id is greater than the specified value.
     * @param idGreaterThan Id constraint.
     * @return BaseQueryRequest
     */
    public T withIdGreaterThan(final Long idGreaterThan) {
        return setParam("id_greater_than", idGreaterThan);
    }

    /**
     * Add constraint where Id is less than the specified value.
     * @param idLessThan Id constraint.
     * @return BaseQueryRequest
     */
    public T withIdLessThan(final Long idLessThan) {
        return setParam("id_less_than", idLessThan);
    }

    /**
     * Add constraint where CreatedAt field is after than the specified time value.
     * @param createdAfter date constraint.
     * @return BaseQueryRequest
     */
    public T withCreatedAfter(DateParameter createdAfter) {
        return setParam("created_after", createdAfter);
    }

    /**
     * Add constraint where CreatedAt field is before than the specified time value.
     * @param createdBefore date constraint.
     * @return BaseQueryRequest
     */
    public T withCreatedBefore(final DateParameter createdBefore) {
        return setParam("created_before", createdBefore);
    }

    /**
     * Add constraint where UpdatedAt field is after than the specified time value.
     * @param updatedAfter date constraint.
     * @return BaseQueryRequest
     */
    protected T withUpdatedAfter(final DateParameter updatedAfter) {
        return setParam("updated_after", updatedAfter);
    }

    /**
     * Add constraint where UpdatedAt field is before than the specified time value.
     * @param updatedBefore date constraint.
     * @return BaseQueryRequest
     */
    protected T withUpdatedBefore(final DateParameter updatedBefore) {
        return setParam("updated_before", updatedBefore);
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

    /**
     * Sort by CreatedAt.
     * @return BaseQueryRequest
     */
    protected T withSortByCreatedAt() {
        return withSortBy("created_at");
    }

    /**
     * Sort results by UpdatedAt.
     * @return BaseQueryRequest
     */
    protected T withSortByUpdatedAt() {
        return withSortBy("updated_at");
    }

    /**
     * Sort results by Name.
     * @return BaseQueryRequest
     */
    protected T withSortByName() {
        return withSortBy("name");
    }

    /**
     * Sort results by Id.
     * @return BaseQueryRequest
     */
    protected T withSortById() {
        return withSortBy("id");
    }


    // Standard Query Options
    public Integer getLimit() {
        return getParam("limit");
    }

    /**
     * Add limit on how many results are returned.
     * @param limit Limit of how many results to return.
     * @return BaseQueryRequest
     */
    public T withLimit(final Integer limit) {
        return setParam("limit", limit);
    }

    public Integer getOffset() {
        return getParam("offset");
    }

    /**
     * Specifies the first matching campaign (according to the specified sorting order) to be returned in the query
     * response. The first offset matching campaigns will be omitted from the response.
     * Default value: 0.
     * Example:
     *   Specifying offset=10 will return the results starting with the 11th campaign matched by the provided criteria
     * @param offset Offset to use.
     * @return BaseQueryRequest
     */
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
     * @param onlyReturnArchived True to only get returned archived entries.
     * @return BaseQueryRequest
     */
    protected T withArchivedOnly(boolean onlyReturnArchived) {
        return setBooleanParam("deleted", onlyReturnArchived);
    }
}
