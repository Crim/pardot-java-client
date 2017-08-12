package com.pardot.api.request.campaign;

import com.pardot.api.request.BaseRequest;
import com.pardot.api.response.campaign.Campaign;

/**
 * For Updating existing Campaigns using Pardot's API.
 */
public class CampaignUpdateRequest extends BaseRequest<CampaignCreateRequest> {
    @Override
    public String getApiEndpoint() {
        return "campaign/do/update";
    }

    public CampaignUpdateRequest withCampaign(final Campaign campaign) {
        setParam("id", campaign.getId());
        setParam("name", campaign.getName());
        setParam("cost", campaign.getCost());

        // This is an optional paramter.
        setParam("folder_id", campaign.getFolderId());
        return this;
    }
}
