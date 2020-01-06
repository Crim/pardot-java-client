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

package com.darksci.pardot.api.request.opportunity;

import com.darksci.pardot.api.response.opportunity.Opportunity;

import java.time.LocalDateTime;

/**
 * For creating new Opportunities using Pardot's API.
 */
public class OpportunityUpdateRequest extends OpportunityCreateRequest {
    @Override
    public String getApiEndpoint() {
        return "opportunity/do/update";
    }

    /**
     * Define the opportunity you want to create in pardot from an existing opportunity object.
     * @param opportunity The opportunity you want to create in pardot.
     * @return Request builder.
     */
    public OpportunityUpdateRequest withOpportunity(final Opportunity opportunity) {
        withId(opportunity.getId());
        super.withOpportunity(opportunity);

        return this;
    }

    /**
     * Define the id of the opportunity to update.
     * @param id of opportunity to update
     * @return Request builder.
     */
    public OpportunityUpdateRequest withId(final Long id) {
        setParam("id", id);
        return this;
    }

    /**
     * Set name for opportunity to be created.
     * @param name Name to set.
     * @return Request builder.
     */
    public OpportunityUpdateRequest withName(final String name) {
        super.withName(name);
        return this;
    }

    /**
     * Set campaign value.
     * @param campaignId id of campaign.
     * @return Request builder.
     */
    public OpportunityUpdateRequest withCampaignId(final Long campaignId) {
        super.withCampaignId(campaignId);
        return this;
    }

    /**
     * Set opportunity value.
     * @param value value of opportunity
     * @return Request builder.
     */
    public OpportunityUpdateRequest withValue(final Integer value) {
        super.withValue(value);
        return this;
    }

    /**
     * Set opportunity probability.
     * @param probability probability of opportunity
     * @return Request builder.
     */
    public OpportunityUpdateRequest withProbability(final Integer probability) {
        super.withProbability(probability);
        return this;
    }

    /**
     * Set opportunity type.
     * @param type Type of the opportunity
     * @return Request builder.
     */
    public OpportunityUpdateRequest withType(final String type) {
        super.withType(type);
        return this;
    }

    /**
     * Set opportunity stage.
     * @param stage stage of the opportunity
     * @return Request builder.
     */
    public OpportunityUpdateRequest withStage(final String stage) {
        super.withStage(stage);
        return this;
    }

    /**
     * Set opportunity status.
     * @param status status of the opportunity
     * @return Request builder.
     */
    public OpportunityUpdateRequest withStatus(final String status) {
        super.withStatus(status);
        return this;
    }

    /**
     * Set opportunity status to won.
     * @return Request builder.
     */
    public OpportunityUpdateRequest withStatusWon() {
        super.withStatusWon();
        return this;
    }

    /**
     * Set opportunity status to lost.
     * @return Request builder.
     */
    public OpportunityUpdateRequest withStatusLost() {
        super.withStatusLost();
        return this;
    }

    /**
     * Set opportunity status to one.
     * @return Request builder.
     */
    public OpportunityUpdateRequest withStatusOpen() {
        super.withStatusOpen();
        return this;
    }

    /**
     * Set which prospect to associate with opportunity.
     * @param prospectId Id of prospect.
     * @return Request builder.
     */
    public OpportunityUpdateRequest withProspectId(final Long prospectId) {
        super.withProspectId(prospectId);
        return this;
    }

    /**
     * Set which prospect to associate with opportunity.
     * @param prospectEmail Email of prospect.
     * @return Request builder.
     */
    public OpportunityUpdateRequest withProspectEmail(final String prospectEmail) {
        super.withProspectEmail(prospectEmail);
        return this;
    }

    /**
     * Set the closed_at property based on Unix timestamp in seconds.
     * @param unixTimestampSecs Time (unix timestamp) that the opportunity was closed.
     * @return Request builder.
     */
    public OpportunityUpdateRequest withClosedAt(final Long unixTimestampSecs) {
        super.withClosedAt(unixTimestampSecs);
        return this;
    }

    /**
     * Set the closed_at property based on Unix timestamp in seconds.
     * @param closedAt Time that the opportunity was closed.
     * @return Request builder.
     */
    public OpportunityUpdateRequest withClosedAt(final LocalDateTime closedAt) {
        super.withClosedAt(closedAt);
        return this;
    }
}
