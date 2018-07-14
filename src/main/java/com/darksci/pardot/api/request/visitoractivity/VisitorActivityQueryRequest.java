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
package com.darksci.pardot.api.request.visitoractivity;

import com.darksci.pardot.api.request.BaseQueryRequest;
import com.darksci.pardot.api.response.visitoractivity.VisitorActivityType;

import java.util.Collection;

/**
 * Defines a Visitor Activity Query Request.
 */
public class VisitorActivityQueryRequest extends BaseQueryRequest<VisitorActivityQueryRequest> {

    @Override
    public String getApiEndpoint() {
        return "visitorActivity/do/query";
    }

    /**
     * Filter by activity type.
     * @param activityType Activity type to filter by.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withActivityType(final VisitorActivityType activityType) {
        return withCollectionParam("type", activityType.getValue());
    }

    /**
     * Filter by activity types.
     * @param activityTypes Activity types to filter by.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withActivityTypes(final Collection<VisitorActivityType> activityTypes) {
        for (final VisitorActivityType activityType: activityTypes) {
            return withCollectionParam("type", activityType.getValue());
        }
        return this;
    }

    /**
     * Filter by activity type.
     * @param activityType Activity type to filter by.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withActivityTypeId(final int activityType) {
        return withCollectionParam("type", activityType);
    }

    /**
     * Filter by activity types.
     * @param activityTypes Activity types to filter by.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withActivityTypeIds(final Collection<Integer> activityTypes) {
        for (final Integer activityType: activityTypes) {
            return withCollectionParam("type", activityType);
        }
        return this;
    }

    // activity type filters

    /**
     * Only select visitor activities associated with a prospect.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withProspectsOnly() {
        return setBooleanParam("prospect_only", true);
    }

    /**
     * Only select visitor activities associated with custom url activities.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withCustomUrlActivitiesOnly() {
        return setBooleanParam("custom_url_only", true);
    }

    /**
     * Only select visitor activities associated with email activities.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withEmailActivitiesOnly() {
        return setBooleanParam("email_only", true);
    }

    /**
     * Only select visitor activities associated with file activities.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withFileActivitiesOnly() {
        return setBooleanParam("file_only", true);
    }

    /**
     * Only select visitor activities associated with form activities.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withFormActivitiesOnly() {
        return setBooleanParam("form_only", true);
    }

    /**
     * Only select visitor activities associated with form handler activities.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withFormHandlerActivitiesOnly() {
        return setBooleanParam("form_handler_only", true);
    }

    /**
     * Only select visitor activities associated with landing page activities.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withLandingPageActivitiesOnly() {
        return setBooleanParam("landing_page_only", true);
    }

    // Relationship filters

    /**
     * Only select visitor activities who are associated with the specified campaign id.
     * @param campaignId The campaignId to filter by.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withCampaignId(final Long campaignId) {
        return withCollectionParam("campaign_id", campaignId);
    }

    /**
     * Only select visitor activities who are associated with the specified campaign ids.
     * @param campaignIds The campaignIds to filter by.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withCampaignIds(final Collection<Long> campaignIds) {
        return withCollectionParams("campaign_id", campaignIds);
    }

    /**
     * Only select visitor activities who are associated with the specified custom url id.
     * @param customUrlId The custom url id to filter by.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withCustomUrlId(final Long customUrlId) {
        return withCollectionParam("custom_url_id", customUrlId);
    }

    /**
     * Only select visitor activities who are associated with the specified custom url ids.
     * @param customUrlIds The custom url ids to filter by.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withCustomUrlIds(final Collection<Long> customUrlIds) {
        return withCollectionParams("custom_url_id", customUrlIds);
    }

    /**
     * Only select visitor activities who are associated with the specified email id.
     * @param emailId The email id to filter by.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withEmailId(final Long emailId) {
        return withCollectionParam("email_id", emailId);
    }

    /**
     * Only select visitor activities who are associated with the specified email ids.
     * @param emailIds The email ids to filter by.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withEmailIds(final Collection<Long> emailIds) {
        return withCollectionParams("email_id", emailIds);
    }

    /**
     * Only select visitor activities who are associated with the specified file id.
     * @param fileId The file id to filter by.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withFileId(final Long fileId) {
        return withCollectionParam("file_id", fileId);
    }

    /**
     * Only select visitor activities who are associated with the specified file ids.
     * @param fileIds The file ids to filter by.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withFileIds(final Collection<Long> fileIds) {
        return withCollectionParams("file_id", fileIds);
    }

    /**
     * Only select visitor activities who are associated with the specified form id.
     * @param formId The form id to filter by.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withFormId(final Long formId) {
        return withCollectionParam("form_id", formId);
    }

    /**
     * Only select visitor activities who are associated with the specified form ids.
     * @param formIds The form ids to filter by.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withFormIds(final Collection<Long> formIds) {
        return withCollectionParams("form_id", formIds);
    }

    /**
     * Only select visitor activities who are associated with the specified form handler id.
     * @param formHandlerId The form handler id to filter by.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withFormHandlerId(final Long formHandlerId) {
        return withCollectionParam("form_handler_id", formHandlerId);
    }

    /**
     * Only select visitor activities who are associated with the specified form handler ids.
     * @param formHandlerIds The form handler ids to filter by.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withFormHandlerId(final Collection<Long> formHandlerIds) {
        return withCollectionParams("form_handler_id", formHandlerIds);
    }

    /**
     * Only select visitor activities who are associated with the specified landing page id.
     * @param landingPageId The landing page id to filter by.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withLandingPageId(final Long landingPageId) {
        return withCollectionParam("landing_page_id", landingPageId);
    }

    /**
     * Only select visitor activities who are associated with the specified landing page ids.
     * @param landingPageIds The landing page ids to filter by.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withLandingPageIds(final Collection<Long> landingPageIds) {
        return withCollectionParams("landing_page_id", landingPageIds);
    }

    /**
     * Only select visitor activities who are associated with the specified prospect id.
     * @param prospectId The prospect id to filter by.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withProspectId(final Long prospectId) {
        return withCollectionParam("prospect_id", prospectId);
    }

    /**
     * Only select visitor activities who are associated with the specified prospect ids.
     * @param prospectIds The prospect ids to filter by.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withProspectIds(final Collection<Long> prospectIds) {
        return withCollectionParams("prospect_id", prospectIds);
    }

    /**
     * Only select visitor activities who are associated with the specified visitor id.
     * @param visitorId The visitor id to filter by.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withVisitorId(final Long visitorId) {
        return withCollectionParam("visitor_id", visitorId);
    }

    /**
     * Only select visitor activities who are associated with the specified visitor ids.
     * @param visitorIds The visitor ids to filter by.
     * @return RequestBuilder
     */
    public VisitorActivityQueryRequest withVisitorIds(final Collection<Long> visitorIds) {
        return withCollectionParams("visitor_id", visitorIds);
    }

    // Sort options

    /**
     * Sort by CreatedAt.
     * @return BaseQueryRequest
     */
    public VisitorActivityQueryRequest withSortByCreatedAt() {
        return super.withSortByCreatedAt();
    }

    /**
     * Sort results by UpdatedAt.
     * @return BaseQueryRequest
     */
    public VisitorActivityQueryRequest withSortByUpdatedAt() {
        return super.withSortByUpdatedAt();
    }

    /**
     * Sort by ProspectId.
     * @return BaseQueryRequest
     */
    public VisitorActivityQueryRequest withSortByProspectId() {
        return withSortBy("prospect_id");
    }

    /**
     * Sort by VisitorId.
     * @return BaseQueryRequest
     */
    public VisitorActivityQueryRequest withSortByVisitorId() {
        return withSortBy("visitor_id");
    }

    /**
     * Sort results by Id.
     * @return BaseQueryRequest
     */
    public VisitorActivityQueryRequest withSortById() {
        return super.withSortById();
    }
}
