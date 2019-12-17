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

package com.darksci.pardot.api.request.tagobject;

/**
 * Represents available Tag Object types.
 */
public enum TagObjectType {
    AUTOMATION("Automation"),
    BLOCK("Block"),
    CAMPAIGN("Campaign"),
    COMPETITOR("Competitor"),
    DYNAMIC_CONTENT("Dynamic Content"),
    ENGAGEMENT_PROGRAM("Engagement Program"),
    PROSPECT_CUSTOM_FIELD("Prospect Custom Field"),
    CUSTOM_URL("Custom URL"),
    DRIP_PROGRAM("Drip Program"),
    EMAIL("Email"),
    EMAIL_DRAFT("Email Draft"),
    EMAIL_TEMPLATE("Email Template"),
    EMAIL_TEMPLATE_DRAFT("Email Template Draft"),
    FILE("File"),
    FORM("Form"),
    FORM_FIELD("Form Field"),
    FORM_HANDLER("Form Handler"),
    GROUP("Group"),
    KEYWORD("Keyword"),
    LANDING_PAGE("Landing Page"),
    LAYOUT_TEMPLATE("Layout Template"),
    LIST("List"),
    OPPORTUNITY("Opportunity"),
    PAID_SEARCH_CAMPAIGN("Paid Search Campaign"),
    PERSONALIZATION("Personalization"),
    PROFILE("Profile"),
    PROSPECT("Prospect"),
    PROSPECT_DEFAULT_FIELD("Prospect Default Field"),
    SEGMENTATION_RULE("Segmentation Rule"),
    SITE("Site"),
    SITE_SEARCH("Site Search"),
    SOCIAL_MESSAGE("Social Message"),
    USER("User");

    final String name;

    /**
     * Constructor.
     */
    TagObjectType(final String name) {
        this.name = name;
    }

    /**
     * get name associated with value.
     * @return name associated with value.
     */
    public String getName() {
        return name;
    }

    /**
     * Given a string name of a type, return the enum.
     * @param name String name of the enum.
     * @return The appropriate enum.
     */
    public static TagObjectType fromName(final String name) {
        for (final TagObjectType type : TagObjectType.values()) {
            if (type.getName().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
    }
}
