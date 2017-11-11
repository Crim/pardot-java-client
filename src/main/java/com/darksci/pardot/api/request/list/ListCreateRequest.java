package com.darksci.pardot.api.request.list;

import com.darksci.pardot.api.request.BaseRequest;
import com.darksci.pardot.api.response.list.List;

/**
 * For creating new Lists using Pardot's API.
 */
public class ListCreateRequest extends BaseRequest<ListCreateRequest> {
    @Override
    public String getApiEndpoint() {
        return "list/do/create";
    }

    /**
     * Define the list you want to create in pardot.
     * @param list The list you want to create in pardot.
     * @return ListCreateRequest builder.
     */
    public ListCreateRequest withList(final List list) {
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
    public ListCreateRequest withFolderId(final Long folderId) {
        setParam("folder_id", folderId);
        return this;
    }
}
