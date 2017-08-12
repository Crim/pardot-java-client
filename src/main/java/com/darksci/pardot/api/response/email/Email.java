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
