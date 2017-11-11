/**
 * Copyright 2017 Stephen Powis https://github.com/Crim/pardot-java-client
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

package com.darksci.pardot.api.response.email;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.joda.time.LocalDateTime;

/**
 * Represents an Email in Pardot.
 */
public class Email {
    private Long id;
    private String name;
    private String subject;
    private Message message;

    @JacksonXmlProperty(localName = "isOneToOne")
    private Boolean isOneToOne;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public Message getMessage() {
        return message;
    }

    public Boolean isOneToOne() {
        return isOneToOne;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    public void setMessage(final Message message) {
        this.message = message;
    }

    public void setIsOneToOne(final Boolean oneToOne) {
        isOneToOne = oneToOne;
    }

    public void setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Represents the Text and Html content bodies for an Email.
     */
    public static class Message {
        private String text;
        private String html;

        public String getText() {
            return text;
        }

        public String getHtml() {
            return html;
        }

        public void setText(final String text) {
            this.text = text;
        }

        public void setHtml(final String html) {
            this.html = html;
        }

        @Override
        public String toString() {
            return "Message{"
                + "text='" + text + '\''
                + ", html='" + html + '\''
                + '}';
        }
    }

    @Override
    public String toString() {
        return "Email{"
            + "id=" + id
            + ", name='" + name + '\''
            + ", subject='" + subject + '\''
            + ", message=" + message
            + ", isOneToOne=" + isOneToOne
            + ", createdAt=" + createdAt
            + '}';
    }
}
