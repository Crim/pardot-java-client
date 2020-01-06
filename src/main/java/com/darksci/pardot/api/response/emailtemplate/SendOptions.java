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

package com.darksci.pardot.api.response.emailtemplate;

import com.darksci.pardot.api.parser.PardotBooleanSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Represents Send Options on a Pardot Email Template.
 */
public class SendOptions {
    private Long sendFromAccountOwner;
    @JsonDeserialize(using = PardotBooleanSerializer.class)
    @JacksonXmlProperty(localName = "isTest")
    private Boolean isTest;
    private String replyToAddress;
    private String sendFromData;
    private String abVersion;

    public Long getSendFromAccountOwner() {
        return sendFromAccountOwner;
    }

    public Boolean getTest() {
        return isTest;
    }

    public String getReplyToAddress() {
        return replyToAddress;
    }

    public String getSendFromData() {
        return sendFromData;
    }

    public String getAbVersion() {
        return abVersion;
    }

    @Override
    public String toString() {
        return "SendOptions{"
            + "sendFromAccountOwner=" + sendFromAccountOwner
            + ", isTest=" + isTest
            + ", replyToAddress='" + replyToAddress + '\''
            + ", sendFromData='" + sendFromData + '\''
            + ", abVersion='" + abVersion + '\''
            + '}';
    }
}
