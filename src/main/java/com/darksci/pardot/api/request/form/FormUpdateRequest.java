package com.darksci.pardot.api.request.form;

import com.darksci.pardot.api.request.BaseRequest;

/**
 * For updating existing Forms using Pardot's API.
 */
public class FormUpdateRequest extends BaseRequest<FormUpdateRequest> {
    @Override
    public String getApiEndpoint() {
        return "form/do/update";
    }

    /**
     * Define the id of the form to update
     * @param id The id of the form to update.
     * @return FormUpdateRequest builder.
     */
    public FormUpdateRequest withFormId(final Long id) {
        setParam("id", id);
        return this;
    }

    /**
     * Define the name of the form.
     * @param name The name of the form.
     * @return FormUpdateRequest builder.
     */
    public FormUpdateRequest withName(final String name) {
        setParam("name", name);
        return this;
    }

    /**
     * Associate form with a campaign.
     * @param campaignId Id of campaign to associate with form.
     * @return FormUpdateRequest builder.
     */
    public FormUpdateRequest withCampaignId(final Long campaignId) {
        setParam("campaign_id", campaignId);
        return this;
    }

    /**
     * Associate form with a layout template.
     * @param layoutTemplateId Id of layout template to associate with form.
     * @return FormUpdateRequest builder.
     */
    public FormUpdateRequest withLayoutTemplateId(final Long layoutTemplateId) {
        setParam("layout_template_id", layoutTemplateId);
        return this;
    }

    /**
     * Associate form with a folder.
     * @param folderId Id of folder to associate with form.
     * @return FormUpdateRequest builder.
     */
    public FormUpdateRequest withFolderId(final Long folderId) {
        setParam("folder_id", folderId);
        return this;
    }
}
