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

package com.darksci.pardot.api.response.dynamiccontent;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.joda.time.LocalDateTime;

import java.util.Collections;
import java.util.List;

/**
 * Represents a Pardot Dynamic Content.
 */
public class DynamicContent {
    private Long id;
    private String name;
    @JacksonXmlProperty(localName = "embedCode")
    private String embedCode;
    @JacksonXmlProperty(localName = "embedUrl")
    private String embedUrl;
    @JacksonXmlProperty(localName = "baseContent")
    private String baseContent;
    @JacksonXmlProperty(localName = "basedOn")
    private String basedOn;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "variation")
    private List<Variation> variations;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmbedCode() {
        return embedCode;
    }

    public void setEmbedCode(final String embedCode) {
        this.embedCode = embedCode;
    }

    public String getEmbedUrl() {
        return embedUrl;
    }

    public void setEmbedUrl(final String embedUrl) {
        this.embedUrl = embedUrl;
    }

    public String getBaseContent() {
        return baseContent;
    }

    public void setBaseContent(final String baseContent) {
        this.baseContent = baseContent;
    }

    public String getBasedOn() {
        return basedOn;
    }

    public void setBasedOn(final String basedOn) {
        this.basedOn = basedOn;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(final LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Variations associated with the Dynamic Content.
     *
     * @return Variations associated with the Dynamic Content.
     */
    public List<Variation> getVariations() {
        if (variations == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(variations);
    }

    public void setVariations(final List<Variation> variations) {
        this.variations = variations;
    }

    @Override
    public String toString() {
        return "DynamicContent{"
            + "id=" + id
            + ", name='" + name + '\''
            + ", embedCode='" + embedCode + '\''
            + ", embedUrl='" + embedUrl + '\''
            + ", baseContent='" + baseContent + '\''
            + ", basedOn='" + basedOn + '\''
            + ", variations=" + variations
            + ", createdAt=" + createdAt
            + ", updatedAt=" + updatedAt
            + '}';
    }

    /**
     * DynamicContent Variation.
     */
    public static class Variation {
        private String comparison;
        private String content;

        public String getComparison() {
            return comparison;
        }

        public void setComparison(final String comparison) {
            this.comparison = comparison;
        }

        public String getContent() {
            return content;
        }

        public void setContent(final String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "Variation{"
                + "comparison='" + comparison + '\''
                + ", content='" + content + '\''
                + '}';
        }
    }
}
