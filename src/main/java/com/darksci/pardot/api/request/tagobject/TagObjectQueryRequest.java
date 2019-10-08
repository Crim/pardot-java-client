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

package com.darksci.pardot.api.request.tagobject;

import com.darksci.pardot.api.request.BaseQueryRequest;

/**
 * Defines a TagObject Query Request.
 */
public class TagObjectQueryRequest  extends BaseQueryRequest<TagObjectQueryRequest> {

    @Override
    public String getApiEndpoint() {
        return "tagObject/do/query";
    }

    // Filter Options
    public TagObjectQueryRequest withType(final String type) {
        return setParam("type", type);
    }

    public TagObjectQueryRequest withType(final TagObjectType type) {
        return setParam("type", type.getName());
    }

    public TagObjectQueryRequest withTagId(final Long tagId) {
        return setParam("tag_id", tagId);
    }

    public TagObjectQueryRequest withObjectId(final Long objectId) {
        return setParam("object_id", objectId);
    }

    public TagObjectQueryRequest withIdLessThan(final Long id) {
        return setParam("id_less_than", id);
    }

    public TagObjectQueryRequest withIdGreaterThan(final Long id) {
        return setParam("id_greater_than", id);
    }

    // Sorting Options
    public TagObjectQueryRequest withSortById() {
        return super.withSortById();
    }

    public TagObjectQueryRequest withSortByCreatedAt() {
        return super.withSortByCreatedAt();
    }
}