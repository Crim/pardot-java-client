/**
 * Copyright 2017, 2018, 2019, 2020 Stephen Powis https://github.com/Crim/pardot-java-client
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

package com.darksci.pardot.api.request.prospect;

import com.darksci.pardot.api.request.BaseQueryRequest;
import com.darksci.pardot.api.request.DateParameter;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Defines a Prospect Query Request.
 */
public class ProspectQueryRequest extends BaseQueryRequest<ProspectQueryRequest> {

    @Override
    public String getApiEndpoint() {
        return "prospect/do/query";
    }

    /**
     * Specifies the fields to be returned. Note: If this parameter isn't present, all default fields and custom fields
     * for which the prospect has a value will be returned;
     * id field will always be returned.
     *
     * Each call will append the field argument to the list of previously passed fields.
     *
     * @param fields Collection of fields to be selected by the request.
     * @return RequestBuilder
     */
    public ProspectQueryRequest withFields(final Collection<String> fields) {
        final String fieldsStr = fields.stream().collect(Collectors.joining( "," ));
        final String currentValue = getParam("fields");
        if (currentValue == null) {
            // set
            return setParam("fields", fieldsStr);
        } else {
            // Append
            return setParam("fields", currentValue + "," + fieldsStr);
        }
    }

    /**
     * Specifies the fields to be returned. Note: If this parameter isn't present, all default fields and custom fields
     * for which the prospect has a value will be returned;
     * id field will always be returned.
     *
     * Each call will append the field argument to the list of previously passed fields.
     *
     * @param field Field to be selected by request.
     * @return RequestBuilder
     */
    public ProspectQueryRequest withField(final String field) {
        final String currentValue = getParam("fields");
        if (currentValue == null) {
            // set
            return setParam("fields", field);
        } else {
            // Append
            return setParam("fields", currentValue + "," + field);
        }
    }

    /**
     * Only select prospects who are assigned.
     * @return RequestBuilder
     */
    public ProspectQueryRequest withAssignedOnly() {
        return setBooleanParam("assigned", true);
    }

    /**
     * Only select prospects who are NOT assigned.
     * @return RequestBuilder
     */
    public ProspectQueryRequest withUnassignedOnly() {
        return setBooleanParam("assigned", false);
    }

    /**
     * Only select prospects who are assigned to the specified user, by Id.
     * @param userId The userId to filter by.
     * @return RequestBuilder
     */
    public ProspectQueryRequest withAssignedUser(final Long userId) {
        return setParam("assigned_to_user", userId);
    }

    /**
     * Only select prospects who are assigned to the specified user, by email address.
     * @param userEmail The user to filter by, as defined by their Email address.
     * @return RequestBuilder
     */
    public ProspectQueryRequest withAssignUser(final String userEmail) {
        return setParam("assigned_to_user", userEmail);
    }

    /**
     * Only select prospects who are archived.
     * @return RequestBuilder
     */
    public ProspectQueryRequest withArchivedOnly() {
        return super.withArchivedOnly(true);
    }

    /**
     * Only select prospects who are NOT archived. (Default value)
     * @return RequestBuilder
     */
    public ProspectQueryRequest withNotArchivedOnly() {
        return super.withArchivedOnly(false);
    }

    /**
     * Retrieve only archived/non-archived prospects.
     * @param onlyReturnArchived True to only get returned archived entries.
     * @return BaseQueryRequest
     */
    @Override
    public ProspectQueryRequest withArchivedOnly(final boolean onlyReturnArchived) {
        return super.withArchivedOnly(onlyReturnArchived);
    }

    /**
     * Only select prospects who have a grade equal to the specified grade.
     * @param grade Grade in format of "A", "A+", "B", "C-"
     * @return RequestBuilder
     */
    public ProspectQueryRequest withGradeEqualTo(final String grade) {
        return setParam("grade_equal_to", grade);
    }

    /**
     * Only select prospects who have a grade greater than to the specified grade.
     * @param grade Grade in format of "A", "A+", "B", "C-"
     * @return RequestBuilder
     */
    public ProspectQueryRequest withGradeGreaterThan(final String grade) {
        return setParam("grade_greater_than", grade);
    }

    /**
     * Only select prospects who have a grade less than the specified grade.
     * @param grade Grade in format of "A", "A+", "B", "C-"
     * @return RequestBuilder
     */
    public ProspectQueryRequest withGradeLessThan(final String grade) {
        return setParam("grade_less_than", grade);
    }

    /**
     * Only select prospects who have been starred.
     * @return RequestBuilder
     */
    public ProspectQueryRequest withStarredOnly() {
        return setBooleanParam("is_starred", true);
    }

    /**
     * Only select prospects who have NOT been starred.
     * @return RequestBuilder
     */
    public ProspectQueryRequest withNotStarredOnly() {
        return setBooleanParam("is_starred", false);
    }

    /**
     * Only select prospects who have a last activity date after a specified value.
     * @param lastActivityAfter The date to filter.
     * @return RequestBuilder
     */
    public ProspectQueryRequest withLastActivityAfter(final DateParameter lastActivityAfter) {
        return setParam("last_activity_after", lastActivityAfter);
    }

    /**
     * Add constraint where UpdatedAt field is after than the specified time value.
     * @param updatedAfter date constraint.
     * @return BaseQueryRequest
     */
    @Override
    public ProspectQueryRequest withUpdatedAfter(final DateParameter updatedAfter) {
        return super.withUpdatedAfter(updatedAfter);
    }

    /**
     * Add constraint where UpdatedAt field is before than the specified time value.
     * @param updatedBefore date constraint.
     * @return BaseQueryRequest
     */
    @Override
    public ProspectQueryRequest withUpdatedBefore(final DateParameter updatedBefore) {
        return super.withUpdatedBefore(updatedBefore);
    }

    /**
     * Only select prospects who have no activity.
     * @return RequestBuilder
     */
    public ProspectQueryRequest withNonActiveOnly() {
        return setBooleanParam("last_activity_never", true);
    }

    /**
     * Only select prospects who are member's of the specified list Id.
     * @param listId Id of List to filter prospects by.
     * @return RequestBuilder
     */
    public ProspectQueryRequest withListId(final Long listId) {
        return setParam("list_id", listId);
    }

    /**
     * Only select prospects who are considered 'new'.
     * @return RequestBuilder
     */
    public ProspectQueryRequest withNewOnly() {
        return setBooleanParam("new", true);
    }

    /**
     * Only select prospects who are NOT considered 'new'.
     * @return RequestBuilder
     */
    public ProspectQueryRequest withNotNewOnly() {
        return setBooleanParam("new", false);
    }

    /**
     * Only select prospects who have have a score equal to the specified value.
     * @param score Score value to filter by.
     * @return RequestBuilder
     */
    public ProspectQueryRequest withScoreEqualTo(final Integer score) {
        return setParam("score_equal_to", score);
    }

    /**
     * Only select prospects who have have a score greater than the specified value.
     * @param score Score value to filter by.
     * @return RequestBuilder
     */
    public ProspectQueryRequest withScoreGreaterThan(final Integer score) {
        return setParam("score_greater_than", score);
    }

    /**
     * Only select prospects who have have a score less than the specified value.
     * @param score Score value to filter by.
     * @return RequestBuilder
     */
    public ProspectQueryRequest withScoreLessThan(final Integer score) {
        return setParam("score_less_than", score);
    }

    /**
     * Sort by CreatedAt.
     * @return BaseQueryRequest
     */
    public ProspectQueryRequest withSortByCreatedAt() {
        return super.withSortByCreatedAt();
    }

    /**
     * Sort results by UpdatedAt.
     * @return BaseQueryRequest
     */
    public ProspectQueryRequest withSortByUpdatedAt() {
        return super.withSortByUpdatedAt();
    }

    /**
     * Sort results by Probability.
     * @return BaseQueryRequest
     */
    public ProspectQueryRequest withSortByProbability() {
        return withSortBy("probability");
    }


    /**
     * Sort results by Probability.
     * @return BaseQueryRequest
     */
    public ProspectQueryRequest withSortByLastActivityAt() {
        return withSortBy("last_activity_at");
    }


    /**
     * Sort results by Id.
     * @return BaseQueryRequest
     */
    public ProspectQueryRequest withSortById() {
        return super.withSortById();
    }
}
