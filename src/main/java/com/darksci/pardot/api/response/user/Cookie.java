package com.darksci.pardot.api.response.user;

import com.darksci.pardot.api.parser.PardotBooleanSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.joda.time.LocalDateTime;

/**
 * Represents a cookie.
 */
public class Cookie {
    private Long id;
    private Long userId;
    private String name;
    private String value;
    private Long expire;
    private String path;
    private String domain;

    @JsonDeserialize(using = PardotBooleanSerializer.class)
    @JacksonXmlProperty(localName = "secure")
    @JsonSetter(nulls = Nulls.SKIP)
    private Boolean secure = false;

    @JsonDeserialize(using = PardotBooleanSerializer.class)
    @JacksonXmlProperty(localName = "httpOnly")
    @JsonSetter(nulls = Nulls.SKIP)
    private Boolean httpOnly = false;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public Long getExpire() {
        return expire;
    }

    public String getPath() {
        return path;
    }

    public String getDomain() {
        return domain;
    }

    public Boolean getSecure() {
        return secure;
    }

    public Boolean getHttpOnly() {
        return httpOnly;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Cookie{" +
            "id=" + id +
            ", userId=" + userId +
            ", name='" + name + '\'' +
            ", value='" + value + '\'' +
            ", expire=" + expire +
            ", path='" + path + '\'' +
            ", domain='" + domain + '\'' +
            ", secure=" + secure +
            ", httpOnly=" + httpOnly +
            ", createdAt=" + createdAt +
            '}';
    }
}
