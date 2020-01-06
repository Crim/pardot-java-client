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

package com.darksci.pardot.api.request.form;

import com.darksci.pardot.api.request.BaseRequest;

/**
 * For creating new Forms using Pardot's API.
 */
public class FormCreateRequest extends BaseRequest<FormCreateRequest> {
    @Override
    public String getApiEndpoint() {
        return "form/do/create";
    }

    /**
     * Define the name of the form.
     * @param name The name of the form.
     * @return FormCreateRequest builder.
     */
    public FormCreateRequest withName(final String name) {
        setParam("name", name);
        return this;
    }

    /**
     * Associate form with a campaign.
     * @param campaignId Id of campaign to associate with form.
     * @return FormCreateRequest builder.
     */
    public FormCreateRequest withCampaignId(final Long campaignId) {
        setParam("campaign_id", campaignId);
        return this;
    }

    /**
     * Associate form with a layout template.
     * @param layoutTemplateId Id of layout template to associate with form.
     * @return FormCreateRequest builder.
     */
    public FormCreateRequest withLayoutTemplateId(final Long layoutTemplateId) {
        setParam("layout_template_id", layoutTemplateId);
        return this;
    }

    /**
     * Associate form with a folder.
     * @param folderId Id of folder to associate with form.
     * @return FormCreateRequest builder.
     */
    public FormCreateRequest withFolderId(final Long folderId) {
        setParam("folder_id", folderId);
        return this;
    }
}
