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

package com.darksci.pardot.api.request;

/**
 * Builder for a Date constraint.
 */
public class DateParameter {
    private final String dateParameter;

    /**
     * Constructor.
     * @param dateParameter Date string.
     */
    public DateParameter(final String dateParameter) {
        this.dateParameter = dateParameter;
    }

    public static DateParameter today() {
        return new DateParameter("today");
    }

    public static DateParameter yesterday() {
        return new DateParameter("yesterday");
    }

    public static DateParameter last7Days() {
        return new DateParameter("last_7_days");
    }

    public static DateParameter thisMonth() {
        return new DateParameter("this_month");
    }

    public static DateParameter lastMonth() {
        return new DateParameter("last_month");
    }

    public static DateParameter custom(final String gnuDateString) {
        return new DateParameter(gnuDateString);
    }

    public static DateParameter custom(final int year, final int month, final int day) {
        return new DateParameter(year + "-" + month + "-" + day);
    }

    /**
     * Define a custom date and time.
     * @param year Four digit year, ex. 2017.
     * @param month Month, 1 through 12.
     * @param day Day of month.
     * @param hour Hour of day, 24 time, 0 through 23.
     * @param min Minute of hour, 0 through 59.
     * @param sec Second of minute, 0 through 59.
     * @return Configured DateParameter.
     */
    public static DateParameter custom(final int year, final int month, final int day, final int hour, final int min, final int sec) {
        String gnuDateStr = year + "-" + month + "-" + day + " ";
        if (hour < 10) {
            gnuDateStr += "0";
        }
        gnuDateStr += hour + ":";

        if (min < 10) {
            gnuDateStr += "0";
        }
        gnuDateStr += min + ":";

        if (sec < 10) {
            gnuDateStr += "0";
        }
        gnuDateStr += sec;

        return new DateParameter(gnuDateStr);
    }

    @Override
    public String toString() {
        return dateParameter;
    }
}
