package com.darksci.pardot.api.response;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

/**
 * Represents an error response from the api.
 */
public class ErrorResponse {
    @JacksonXmlElementWrapper(localName = "err")
    private Error error;

    public Error getError() {
        return error;
    }

    public String getMessage() {
        return error.getError();
    }

    public int getCode() {
        return error.getCode();
    }

    private static class Error {
        @JacksonXmlText
        private String error;

        @JacksonXmlProperty(localName = "code", isAttribute = true)
        private int code;

        public String getError() {
            return error;
        }

        public int getCode() {
            return code;
        }
    }

    @Override
    public String toString() {
        return "ErrorResponse{"
            + "error='" + error.error + '\''
            + ", code=" + error.code
            + '}';
    }
}
