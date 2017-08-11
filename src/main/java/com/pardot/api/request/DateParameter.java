package com.pardot.api.request;

import java.util.Date;

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
