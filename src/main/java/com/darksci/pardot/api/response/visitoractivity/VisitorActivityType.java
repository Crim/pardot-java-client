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

package com.darksci.pardot.api.response.visitoractivity;

/**
 * Enum Representing Visitor Activity types.
 */
public enum VisitorActivityType {
    UNKNOWN(0, "UNKNOWN"),
    CLICK(1, "Click"),
    VIEW(2, "View"),
    ERROR(3, "Error"),
    SUCCESS(4, "Success"),
    SESSION(5, "Session"),
    SENT(6, "Sent"),
    SEARCH(7, "Search"),
    NEW_OPPORTUNITY(8, "New Opportunity"),
    OPPORTUNITY_WON(9, "Opportunity Won"),
    OPPORTUNITY_LOST(10, "Opportunity Lost"),
    OPEN(11, "Open"),
    UNSUBSCRIBE_PAGE(12, "Unsubscribe Page"),
    BOUNCED(13, "Bounced"),
    SPAM_COMPLAINT(14, "Spam Complaint"),
    EMAIL_PREFERENCE_PAGE(15, "Email Preference Page"),
    RESUBSCRIBED(16, "Resubscribed"),
    CLICK_THIRD_PARTY(17, "Click (Third Party)"),
    OPPORTUNITY_REOPENED(18, "Opportunity Reopened"),
    OPPORTUNITY_LINKED(19, "Opportunity Linked"),
    VISIT(20, "Visit"),
    CUSTOM_URL_CLICK(21, "Custom URL click"),
    OLARK_CHAT(22, "Olark Chat"),
    INVITED_TO_WEBINAR(23, "Invited to Webinar"),
    ATTENTED_WEBINAR(24, "Attended Webinar"),
    REGISTERED_FOR_WEBINAR(25, "Registered for Webinar"),
    SOCIAL_POST_CLICK(26, "Social Post Click"),
    VIDEO_VIEW(27, "Video View"),
    EVENT_REGISTERED(28, "Event Registered"),
    EVENT_CHECKED_IN(29, "Event Checked In"),
    VIDEO_CONVERSION(30, "Video Conversion"),
    USERVOICE_SUGGESTION(31, "UserVoice Suggestion"),
    USERVOICE_COMMENT(32, "UserVoice Comment"),
    USERVOICE_TICKET(33, "UserVoice Ticket"),
    VIDEO_WATCHED(34, "Video Watched (≥ 75% watched)");

    private final int value;
    private final String name;

    VisitorActivityType(final int value, final String name) {
        this.value = value;
        this.name = name;
    }

    /**
     * @return Display name for activity type.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Integer value of type.
     */
    public int getValue() {
        return value;
    }

    /**
     * Given a type value, return the appropriate enum representing it.
     * @param value value of type.
     * @return Enum.
     */
    public static VisitorActivityType fromValue(final Integer value) {
        if (value == null) {
            return UNKNOWN;
        }

        switch (value) {
            case 1:
                return CLICK;
            case 2:
                return VIEW;
            case 3:
                return ERROR;
            case 4:
                return SUCCESS;
            case 5:
                return SESSION;
            case 6:
                return SENT;
            case 7:
                return SEARCH;
            case 8:
                return NEW_OPPORTUNITY;
            case 9:
                return OPPORTUNITY_WON;
            case 10:
                return OPPORTUNITY_LOST;
            case 11:
                return OPEN;
            case 12:
                return UNSUBSCRIBE_PAGE;
            case 13:
                return BOUNCED;
            case 14:
                return SPAM_COMPLAINT;
            case 15:
                return EMAIL_PREFERENCE_PAGE;
            case 16:
                return RESUBSCRIBED;
            case 17:
                return CLICK_THIRD_PARTY;
            case 18:
                return OPPORTUNITY_REOPENED;
            case 19:
                return OPPORTUNITY_LINKED;
            case 20:
                return VISIT;
            case 21:
                return CUSTOM_URL_CLICK;
            case 22:
                return OLARK_CHAT;
            case 23:
                return INVITED_TO_WEBINAR;
            case 24:
                return ATTENTED_WEBINAR;
            case 25:
                return REGISTERED_FOR_WEBINAR;
            case 26:
                return SOCIAL_POST_CLICK;
            case 27:
                return VIDEO_VIEW;
            case 28:
                return EVENT_REGISTERED;
            case 29:
                return EVENT_CHECKED_IN;
            case 30:
                return VIDEO_CONVERSION;
            case 31:
                return USERVOICE_SUGGESTION;
            case 32:
                return USERVOICE_COMMENT;
            case 33:
                return USERVOICE_TICKET;
            case 34:
                return VIDEO_WATCHED;
            default:
                return UNKNOWN;
        }
    }
}
