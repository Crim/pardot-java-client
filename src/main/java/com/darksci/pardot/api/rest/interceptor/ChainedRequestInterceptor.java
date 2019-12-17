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

package com.darksci.pardot.api.rest.interceptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Implementation allows for chaining multiple interceptors together.
 */
public class ChainedRequestInterceptor implements RequestInterceptor {
    private final List<RequestInterceptor> requestInterceptors;

    /**
     * Constructor.
     * @param requestInterceptors list of interceptors.
     */
    public ChainedRequestInterceptor(final List<RequestInterceptor> requestInterceptors) {
        Objects.requireNonNull(requestInterceptors);
        this.requestInterceptors = Collections.unmodifiableList(new ArrayList<>(requestInterceptors));
    }

    @Override
    public void modifyRequestParameters(final Map<String, String> requestParameters) {
        // Call each interceptor in order.
        requestInterceptors
            .forEach(requestInterceptor -> requestInterceptor.modifyRequestParameters(requestParameters));
    }

    @Override
    public void modifyHeaders(final Map<String, String> requestHeaders) {
        // Call each interceptor in order.
        requestInterceptors
            .forEach(requestInterceptor -> requestInterceptor.modifyHeaders(requestHeaders));
    }

    /**
     * Builder instance for ChainedRequestInterceptor.
     * @return builder instance for ChainedRequestInterceptor.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for ChainedRequestInterceptor.
     */
    public static final class Builder {
        private List<RequestInterceptor> requestInterceptors = new ArrayList<>();

        private Builder() {
        }

        /**
         * Add a collection of interceptors.
         * @param requestInterceptors the interceptors to add.
         * @return builder instance.
         */
        public Builder withRequestInterceptors(final List<RequestInterceptor> requestInterceptors) {
            Objects.requireNonNull(requestInterceptors);
            this.requestInterceptors.addAll(requestInterceptors);
            return this;
        }

        /**
         * Add a single interceptor.
         * @param requestInterceptor the interceptor to add.
         * @return builder instance.
         */
        public Builder withRequestInterceptor(final RequestInterceptor requestInterceptor) {
            Objects.requireNonNull(requestInterceptor);
            this.requestInterceptors.add(requestInterceptor);
            return this;
        }

        /**
         * Create ChainedRequestInterceptor instance.
         * @return new ChainedRequestInterceptor instance.
         */
        public ChainedRequestInterceptor build() {
            return new ChainedRequestInterceptor(requestInterceptors);
        }
    }
}
