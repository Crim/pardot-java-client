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

package com.darksci.pardot.api.request.email;

import com.darksci.pardot.api.request.BaseRequest;
import org.joda.time.DateTime;

import java.util.Collection;
import java.util.HashSet;

/**
 * For sending a list email to one or more list's of prospects.
 */
public class EmailSendListRequest extends BaseRequest<EmailSendListRequest> {

    @Override
    public String getApiEndpoint() {
        return "email/do/send";
    }

    /**
     * Define CampaignId to associate with Email send.
     * @param campaignId The id of the campaign you'd like this email associated with.
     * @return RequestBuilder
     */
    public EmailSendListRequest withCampaignId(final Long campaignId) {
        return setParam("campaign_id", campaignId);
    }

    /**
     * Define Name and Email to send the email using.
     * @param fromName The name of the sending user.
     * @param fromEmail The email of the sending user.
     * @return RequestBuilder
     */
    public EmailSendListRequest withFromNameAndEmail(final String fromName, final String fromEmail) {
        // Clear from_user_id
        setParam("from_user_id", null);

        // Set from name & email
        setParam("from_name", fromName);
        setParam("from_email", fromEmail);
        return this;
    }

    /**
     * Send the email from a specific user.
     * @param userId The user id of the sending user.
     * @return RequestBuilder
     */
    public EmailSendListRequest withFromUserId(final Long userId) {
        // clear from_name & from_email
        setParam("from_name", null);
        setParam("from_email", null);

        // set from user id.
        setParam("from_user_id", userId);
        return this;
    }

    /**
     * If the prospect has an assigned user, send the email from that user.
     * @param sendFromAssignedUser True to send from Prospect's assigned user, false if not.
     * @return RequestBuilder
     */
    public EmailSendListRequest withFromAssignedUser(final boolean sendFromAssignedUser) {
        return setBooleanParam("from_assigned_user", sendFromAssignedUser);
    }

    /**
     * If the prospect has an account owner, send the email from that user.
     * @param sendFromAccountOwner True to send from Prospect's account owner, false if not.
     * @return RequestBuilder
     */
    public EmailSendListRequest withFromAccountOwner(final boolean sendFromAccountOwner) {
        return setBooleanParam("from_account_owner", sendFromAccountOwner);
    }

    /**
     * Define the reply-to email address for email.
     * @param replyToEmail The email address where replies should be sent.
     * @return RequestBuilder
     */
    public EmailSendListRequest withReplyToEmail(final String replyToEmail) {
        return setParam("replyto_email", replyToEmail);
    }

    /**
     * The id of the list you'd like to mail to.
     * You can add multiple listIds for multiple lists
     * @param listId The id of the list you'd like to mail to.
     * @return RequestBuilder
     */
    public EmailSendListRequest withListId(final Long listId) {
        Collection<Long> listIds = getParam("list_ids");
        if (listIds == null) {
            listIds = new HashSet<>();
        }
        listIds.add(listId);

        return setParam("list_ids", listIds);
    }

    /**
     * The ids of the lists you'd like to mail to.
     * You can add multiple listIds for multiple lists
     * @param listIds The ids of the lists you'd like to mail to.
     * @return RequestBuilder
     */
    public EmailSendListRequest withListIds(final Collection<Long> listIds) {
        for (final Long listId: listIds) {
            withListId(listId);
        }
        return this;
    }

    /**
     * The id of the list you'd like to suppress mailing to.
     * You can add multiple suppression list ids for multiple lists.
     * @param suppressionListId The id of the list you'd like to suppress mailing to.
     * @return RequestBuilder
     */
    public EmailSendListRequest withSuppressionListId(final Long suppressionListId) {
        Collection<Long> listIds = getParam("suppression_list_ids");
        if (listIds == null) {
            listIds = new HashSet<>();
        }
        listIds.add(suppressionListId);

        return setParam("suppression_list_ids", listIds);
    }

    /**
     * The ids of the lists you'd like to suppress mailing to.
     * You can add multiple suppression list ids for multiple lists.
     * @param suppressionListIds The ids of the lists you'd like to suppress mailing to.
     * @return RequestBuilder
     */
    public EmailSendListRequest withSuppressionListIds(final Collection<Long> suppressionListIds) {
        for (final Long listId: suppressionListIds) {
            withSuppressionListId(listId);
        }
        return this;
    }

    /**
     * Associate a Tag with the email.
     * @param tag Name of the tag to associate.
     * @return RequestBuilder
     */
    public EmailSendListRequest withTag(final String tag) {
        Collection<String> tags = getParam("tags");
        if (tags == null) {
            tags = new HashSet<>();
        }
        tags.add(tag);

        return setParam("tags", tags);
    }

    /**
     * Associate Tags with the email.
     * @param tags Collection of tags to associate.
     * @return RequestBuilder
     */
    public EmailSendListRequest withTags(Collection<String> tags) {
        for (final String tag: tags) {
            withTag(tag);
        }
        return this;
    }

    /**
     * When set, the email will be sent to the prospect regardless of opt-out status.
     * Your account must have this feature enabled to use this setting.
     * @param isOperationalEmail True to send it as an operational email, false if not.
     * @return RequestBuilder
     */
    public EmailSendListRequest withOperationalEmail(final boolean isOperationalEmail) {
        return setBooleanParam("operational_email", isOperationalEmail);
    }

    /**
     * The name of the email within Pardot.
     * @param name The name of the email within Pardot.
     * @return RequestBuilder
     */
    public EmailSendListRequest withName(final String name) {
        return setParam("name", name);
    }

    /**
     * The subject of the email.
     * @param subject The subject of the email.
     * @return RequestBuilder
     */
    public EmailSendListRequest withSubject(final String subject) {
        return setParam("subject", subject);
    }

    /**
     * The text body of the email.
     * This must contain either %%unsubscribe%% or %%email_preference_center%%.
     * @param textContent The text body of the email.
     * @return RequestBuilder
     */
    public EmailSendListRequest withTextContent(final String textContent) {
        return setParam("text_content", textContent);
    }

    /**
     * The html body of the email.
     * This must contain either %%unsubscribe%% or %%email_preference_center%%.
     * @param htmlContent The html body of the email.
     * @return RequestBuilder
     */
    public EmailSendListRequest withHtmlContent(final String htmlContent) {
        return setParam("html_content", htmlContent);
    }

    /**
     * The id of the email template to use.
     * @param emailTemplateId The id of the email template to use.
     * @return RequestBuilder
     */
    public EmailSendListRequest withEmailTemplateId(final Long emailTemplateId) {
        return setParam("email_template_id", emailTemplateId);
    }

    /**
     * The date and time which the email should be sent.
     * @param dateTime The date and time which the email should be sent.
     * @return RequestBuilder
     */
    public EmailSendListRequest withScheduledTime(final DateTime dateTime) {
        return setParam("scheduled_time", dateTime);
    }
}
