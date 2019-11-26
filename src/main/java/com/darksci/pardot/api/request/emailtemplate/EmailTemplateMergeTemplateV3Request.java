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

package com.darksci.pardot.api.request.emailtemplate;


import com.darksci.pardot.api.request.BaseRequest;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Given an email template id and prospect Id, this will return the template requested with replacement
 * tags merged using the supplied prospectId.
 *
 * This should only be used against API V3.  For Accounts that use API V4, use the V4 request builder.
 */
public class EmailTemplateMergeTemplateV3Request extends BaseRequest<EmailTemplateMergeTemplateV3Request> {

    @Override
    public String getApiEndpoint() {
        return "emailTemplate/do/merge";
    }

    /**
     * Id of email template to read.
     * @param emailTemplateId id of email template.
     * @return Builder.
     */
    public EmailTemplateMergeTemplateV3Request withEmailTemplateId(final Long emailTemplateId) {
        return setParam("id", emailTemplateId);
    }

    /**
     * Id of email template to read.
     * @param prospectEmail email address of prospect.
     * @return Builder.
     */
    public EmailTemplateMergeTemplateV3Request withProspectEmail(final String prospectEmail) {
        // Base64 encode the property.
        return setParam(
            "prospect_email",
            Base64.getEncoder().encode(prospectEmail.getBytes(StandardCharsets.UTF_8))
        );
    }
}
