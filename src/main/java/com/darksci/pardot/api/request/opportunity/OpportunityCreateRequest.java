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

import com.darksci.pardot.api.request.BaseRequest;
import com.darksci.pardot.api.response.opportunity.Opportunity;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * For creating new Opportunities using Pardot's API.
 */
public class OpportunityCreateRequest extends BaseRequest<OpportunityCreateRequest> {
    @Override
    public String getApiEndpoint() {
        return "opportunity/do/create";
    }

    /**
     * Define the opportunity you want to create in pardot from an existing opportunity object.
     * @param opportunity The opportunity you want to create in pardot.
     * @return OpportunityCreateRequest builder.
     */
    public OpportunityCreateRequest withOpportunity(final Opportunity opportunity) {
        this
            .withName(opportunity.getName())
            .withValue(opportunity.getValue())
            .withProbability(opportunity.getProbability())
            .withType(opportunity.getType())
            .withStage(opportunity.getStage())
            .withStatus(opportunity.getStatus());

        if (opportunity.getCampaign() != null) {
            withCampaignId(opportunity.getCampaign().getId());
        }

        // Use first prospect?
        if (opportunity.getProspects().size() > 0) {
            withProspectId(opportunity.getProspects().get(0).getId());
        }

        return this;
    }

    /**
     * Set name for opportunity to be created.
     * @param name Name to set.
     * @return OpportunityCreateRequest builder.
     */
    public OpportunityCreateRequest withName(final String name) {
        return setParam("name", name);
    }

    /**
     * Set campaign value.
     * @param campaignId id of campaign.
     * @return OpportunityCreateRequest builder.
     */
    public OpportunityCreateRequest withCampaignId(final Long campaignId) {
        return setParam("campaign_id", campaignId);
    }

    /**
     * Set opportunity value.
     * @param value value of opportunity
     * @return OpportunityCreateRequest builder.
     */
    public OpportunityCreateRequest withValue(final Integer value) {
        return setParam("value", value);
    }

    /**
     * Set opportunity probability.
     * @param probability probability of opportunity
     * @return OpportunityCreateRequest builder.
     */
    public OpportunityCreateRequest withProbability(final Integer probability) {
        return setParam("probability", probability);
    }

    /**
     * Set opportunity type.
     * @param type Type of the opportunity
     * @return OpportunityCreateRequest builder.
     */
    public OpportunityCreateRequest withType(final String type) {
        return setParam("type", type);
    }

    /**
     * Set opportunity stage.
     * @param stage stage of the opportunity
     * @return OpportunityCreateRequest builder.
     */
    public OpportunityCreateRequest withStage(final String stage) {
        return setParam("stage", stage);
    }

    /**
     * Set opportunity status.
     * @param status status of the opportunity
     * @return OpportunityCreateRequest builder.
     */
    public OpportunityCreateRequest withStatus(final String status) {
        return setParam("status", status);
    }

    /**
     * Set opportunity status to won.
     * @return OpportunityCreateRequest builder.
     */
    public OpportunityCreateRequest withStatusWon() {
        return withStatus("won");
    }

    /**
     * Set opportunity status to lost.
     * @return OpportunityCreateRequest builder.
     */
    public OpportunityCreateRequest withStatusLost() {
        return withStatus("lost");
    }

    /**
     * Set opportunity status to one.
     * @return OpportunityCreateRequest builder.
     */
    public OpportunityCreateRequest withStatusOpen() {
        return withStatus("open");
    }

    /**
     * Set which prospect to associate with opportunity.
     * @param prospectId Id of prospect.
     * @return OpportunityCreateRequest builder.
     */
    public OpportunityCreateRequest withProspectId(final Long prospectId) {
        setParam("prospect_email", null);
        return setParam("prospect_id", prospectId);
    }

    /**
     * Set which prospect to associate with opportunity.
     * @param prospectEmail Email of prospect.
     * @return OpportunityCreateRequest builder.
     */
    public OpportunityCreateRequest withProspectEmail(final String prospectEmail) {
        setParam("prospect_email", prospectEmail);
        return setParam("prospect_id", null);
    }

    /**
     * Set the closed_at property based on Unix timestamp in seconds.
     * @param unixTimestampSecs Time (unix timestamp) that the opportunity was closed.
     * @return OpportunityCreateRequest builder.
     */
    public OpportunityCreateRequest withClosedAt(final Long unixTimestampSecs) {
        return withClosedAt(LocalDateTime.ofEpochSecond(unixTimestampSecs, 0, ZoneOffset.UTC));
    }

    /**
     * Set the closed_at property based on Unix timestamp in seconds.
     * @param closedAt Time that the opportunity was closed.
     * @return OpportunityCreateRequest builder.
     */
    public OpportunityCreateRequest withClosedAt(final LocalDateTime closedAt) {
        return setParam("closed_at", closedAt.toString());
    }
}
