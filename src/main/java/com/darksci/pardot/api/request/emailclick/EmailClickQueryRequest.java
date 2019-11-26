/**
 * Copyright 2017, 2018, 2019 Stephen Powis https://github.com/Crim/pardot-java-client
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

package com.darksci.pardot.api.request.emailclick;

import com.darksci.pardot.api.request.BaseQueryRequest;

import java.util.Collection;

/**
 * Used to query Email Clicks over the Pardot API.
 */
public class EmailClickQueryRequest extends BaseQueryRequest<EmailClickQueryRequest> {
    @Override
    public String getApiEndpoint() {
        return "emailClick/do/query";
    }

    // Filter Options

    /**
     * Restrict query by a specific drip program action id.
     * @param dripProgramActionId The drip progam action id.
     * @return RequestBuilder
     */
    public EmailClickQueryRequest withDripProgramActionId(final Long dripProgramActionId) {
        return withCollectionParam("drip_program_action_id", dripProgramActionId);
    }

    /**
     * Restrict query by a specific drip program action ids.
     * @param dripProgramActionIds The drip program action ids.
     * @return RequestBuilder
     */
    public EmailClickQueryRequest withDripProgramActionIds(final Collection<Long> dripProgramActionIds) {
        return withCollectionParams("drip_program_action_id", dripProgramActionIds);
    }

    /**
     * Restrict query by a specific email template id.
     * @param emailTemplateId The email template id.
     * @return RequestBuilder
     */
    public EmailClickQueryRequest withEmailTemplateId(final Long emailTemplateId) {
        return withCollectionParam("email_template_id", emailTemplateId);
    }

    /**
     * Restrict query by a specific email template ids.
     * @param emailTemplateIds The email template ids.
     * @return RequestBuilder
     */
    public EmailClickQueryRequest withEmailTemplateIds(final Collection<Long> emailTemplateIds) {
        return withCollectionParams("email_template_id", emailTemplateIds);
    }

    /**
     * Restrict query by a specific list email send id.
     * @param listEmailId The list email send id.
     * @return RequestBuilder
     */
    public EmailClickQueryRequest withListEmailId(final Long listEmailId) {
        return withCollectionParam("list_email_id", listEmailId);
    }

    /**
     * Restrict query by a specific list email send ids.
     * @param listEmailIds The list email send ids.
     * @return RequestBuilder
     */
    public EmailClickQueryRequest withListEmailIds(final Collection<Long> listEmailIds) {
        return withCollectionParams("list_email_id", listEmailIds);
    }

    /**
     * Restrict query by a specific tracker redirect id.
     * @param trackerRedirectId The tracker redirect id.
     * @return RequestBuilder
     */
    public EmailClickQueryRequest withTrackerRedirectId(final Long trackerRedirectId) {
        return withCollectionParam("tracker_redirect_id", trackerRedirectId);
    }

    /**
     * Restrict query by a specific tracker redirect ids.
     * @param trackerRedirectIds The tracker redirect ids.
     * @return RequestBuilder
     */
    public EmailClickQueryRequest withTrackerRedirectIds(final Collection<Long> trackerRedirectIds) {
        return withCollectionParams("tracker_redirect_id", trackerRedirectIds);
    }

    // Sorting Options
    public EmailClickQueryRequest withSortById() {
        return super.withSortById();
    }
}
