/**
 * Copyright 2017, 2018 Stephen Powis https://github.com/Crim/pardot-java-client
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
package com.darksci.pardot.api.request.opportunity;

import com.darksci.pardot.api.request.BaseQueryRequest;

/**
 * Used to query Opportunities over the Pardot API.
 */
public class OpportunityQueryRequest extends BaseQueryRequest<OpportunityQueryRequest> {
    @Override
    public String getApiEndpoint() {
        return "opportunity/do/query";
    }

    // Filter Options

    /**
     * Add constraint where probability is greater than the specified value.
     * @param probability constraint value.
     * @return RequestBuilder
     */
    public OpportunityQueryRequest withProbabilityGreaterThan(final Integer probability) {
        return setParam("probability_greater_than", probability);
    }

    /**
     * Add constraint where probability is less than the specified value.
     * @param probability constraint value.
     * @return RequestBuilder
     */
    public OpportunityQueryRequest withProbabilityLessThan(final Integer probability) {
        return setParam("probability_less_than", probability);
    }

    /**
     * Add constraint where value is greater than the specified value.
     * @param value constraint value.
     * @return RequestBuilder
     */
    public OpportunityQueryRequest withValueGreaterThan(final Integer value) {
        return setParam("value_greater_than", value);
    }

    /**
     * Add constraint where value is less than the specified value.
     * @param value constraint value.
     * @return RequestBuilder
     */
    public OpportunityQueryRequest withValueLessThan(final Integer value) {
        return setParam("value_less_than", value);
    }

    /**
     * Define which prospect to perform action on by Id.
     * @param prospectId Id of prospect to delete.
     * @return RequestBuilder
     */
    public OpportunityQueryRequest withProspectId(final Long prospectId) {
        setParam("email", null);
        return setParam("id", prospectId);
    }

    /**
     * Define which prospect to perform action on by email.
     * @param email Email of prospect to delete.
     * @return RequestBuilder
     */
    public OpportunityQueryRequest withProspectEmail(final String email) {
        setParam("id", null);
        return setParam("email", email);
    }

    /**
     * Marked as protected because I'm not sure if all objects support this or not.
     * @param onlyReturnArchived True to only get returned archived entries.
     * @return BaseQueryRequest
     */
    public OpportunityQueryRequest withArchivedOnly(final boolean onlyReturnArchived) {
        return super.withArchivedOnly(onlyReturnArchived);
    }

    // Sorting Options
    public OpportunityQueryRequest withSortById() {
        return super.withSortById();
    }

    public OpportunityQueryRequest withSortByCreatedAt() {
        return super.withSortByCreatedAt();
    }

    public OpportunityQueryRequest withSortByProbability() {
        return super.withSortBy("probability");
    }

    public OpportunityQueryRequest withSortByValue() {
        return super.withSortBy("value");
    }
}
