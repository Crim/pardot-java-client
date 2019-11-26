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

package com.darksci.pardot.api.response.tagobject;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Collections;
import java.util.List;

/**
 * Represents the results of querying TagObjects in Pardot API.
 */
public class TagObjectQueryResponse {
    private TagObjectQueryResponse.Result result;

    public Result getResult() {
        return result;
    }

    /**
     * Represents the results of querying TagObjects in Pardot API.
     */
    public static class Result {
        private Integer totalResults = 0;

        @JacksonXmlProperty(localName = "tagObject")
        private List<TagObject> tagObjects = Collections.emptyList();

        public Integer getTotalResults() {
            return totalResults;
        }

        /**
         * Objects that have been tagged as returned by the API.
         *
         * @return TagObject results.
         */
        public List<TagObject> getTagObjects() {
            if (tagObjects == null) {
                tagObjects = Collections.emptyList();
            }
            return Collections.unmodifiableList(tagObjects);
        }

        @Override
        public String toString() {
            return "Result{"
                    + "totalResults=" + totalResults
                    + ", tagObjects=" + tagObjects
                    + '}';
        }
    }

    @Override
    public String toString() {
        return "TagObjectQueryResponse{"
                + "result=" + result
                + '}';
    }
}