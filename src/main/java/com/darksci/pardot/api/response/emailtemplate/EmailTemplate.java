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

package com.darksci.pardot.api.response.emailtemplate;

import com.darksci.pardot.api.parser.PardotBooleanSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Represents a Pardot Email Template.
 */
public class EmailTemplate {
    private Long id;
    private String name;
    @JacksonXmlProperty(localName = "htmlMessage")
    private String htmlMessage;
    private String trackedHtmlMessage;
    @JacksonXmlProperty(localName = "textMessage")
    private String textMessage;
    private String trackedTextMessage;
    private String fromName;
    private String subject;
    @JsonDeserialize(using = PardotBooleanSerializer.class)
    @JacksonXmlProperty(localName = "isOneToOneEmail")
    private Boolean isOneToOneEmail = false;
    @JsonDeserialize(using = PardotBooleanSerializer.class)
    @JacksonXmlProperty(localName = "isArchived")
    private Boolean isArchived = false;
    @JsonDeserialize(using = PardotBooleanSerializer.class)
    @JacksonXmlProperty(localName = "isAutoResponderEmail")
    private Boolean isAutoResponderEmail;
    @JsonDeserialize(using = PardotBooleanSerializer.class)
    @JacksonXmlProperty(localName = "isDripEmail")
    private Boolean isDripEmail;
    @JsonDeserialize(using = PardotBooleanSerializer.class)
    @JacksonXmlProperty(localName = "isListEmail")
    private Boolean isListEmail;

    @JacksonXmlProperty(localName = "emailType")
    private Long emailType;

    @JacksonXmlProperty(localName = "type")
    private Long type;

    @JacksonXmlProperty(localName = "sendOptions")
    private SendOptions sendOptions = new SendOptions();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHtmlMessage() {
        return htmlMessage;
    }

    public String getTrackedHtmlMessage() {
        return trackedHtmlMessage;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public String getTrackedTextMessage() {
        return trackedTextMessage;
    }

    public String getFromName() {
        return fromName;
    }

    public String getSubject() {
        return subject;
    }

    public Boolean getIsOneToOneEmail() {
        return isOneToOneEmail;
    }

    public Boolean getIsArchived() {
        return isArchived;
    }

    public Boolean getIsAutoResponderEmail() {
        return isAutoResponderEmail;
    }

    public Boolean getIsDripEmail() {
        return isDripEmail;
    }

    public Boolean getIsListEmail() {
        return isListEmail;
    }

    public Long getEmailType() {
        return emailType;
    }

    public Long getType() {
        return type;
    }

    public EmailTemplateType getEmailTemplateType() {
        return EmailTemplateType.fromValue(getType());
    }

    public SendOptions getSendOptions() {
        return sendOptions;
    }

    @Override
    public String toString() {
        return "EmailTemplate{"
            + "id=" + id
            + ", name='" + name + '\''
            + ", htmlMessage='" + htmlMessage + '\''
            + ", trackedHtmlMessage='" + trackedHtmlMessage + '\''
            + ", textMessage='" + textMessage + '\''
            + ", trackedTextMessage='" + trackedTextMessage + '\''
            + ", fromName='" + fromName + '\''
            + ", subject='" + subject + '\''
            + ", isOneToOneEmail=" + isOneToOneEmail
            + ", isArchived=" + isArchived
            + ", isAutoResponderEmail=" + isAutoResponderEmail
            + ", isDripEmail=" + isDripEmail
            + ", isListEmail=" + isListEmail
            + ", emailType=" + emailType
            + ", type=" + type
            + ", sendOptions=" + sendOptions
            + '}';
    }
}
