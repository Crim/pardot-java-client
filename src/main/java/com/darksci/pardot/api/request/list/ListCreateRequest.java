/**
 * Copyright 2017 Stephen Powis
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
