package com.darksci.pardot.api.request.list;

import com.darksci.pardot.api.request.BaseRequest;
import com.darksci.pardot.api.response.list.List;

/**
 * For Updating existing Lists using Pardot's API.
 */
public class ListUpdateRequest extends BaseRequest<ListUpdateRequest> {
    @Override
    public String getApiEndpoint() {
        return "list/do/update";
    }

    /**
     * Define the list you want to update in pardot.
     * @param list The list you want to update in pardot.
     * @return ListUpdateRequest builder.
     */
    public ListUpdateRequest withList(final List list) {
        setParam("id", list.getId());
        setParam("name", list.getName());
        setBooleanParam("is_public", list.getIsPublic());
        setParam("title", list.getTitle());
        setParam("description", list.getDescription());
        setBooleanParam("is_crm_visible", list.getIsCrmVisible());
        return this;
    }

    /**
     * Optionally can define what folder to place the list into.
     * @param folderId The folder to place the list into.
     * @return ListCreateRequest builder.
     */
    public ListUpdateRequest withFolderId(final Long folderId) {
        setParam("folder_id", folderId);
        return this;
    }
}
