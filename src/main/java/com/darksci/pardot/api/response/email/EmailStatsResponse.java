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
package com.darksci.pardot.api.response.email;

/**
 * Represents the result of an EmailStats API request.
 */
public class EmailStatsResponse {
    private Stats stats;

    public Stats getStats() {
        return stats;
    }

    /**
     * Represents the result of an EmailStats API request.
     */
    public static class Stats {
        private Integer sent;
        private Integer delivered;
        private Integer totalClicks;
        private Integer uniqueClicks;
        private Integer softBounced;
        private Integer hardBounced;
        private Integer optOuts;
        private Integer spamComplaints;
        private Integer opens;
        private Integer uniqueOpens;
        private String deliveryRate;
        private String opensRate;
        private String clickThroughRate;
        private String uniqueClickThroughRate;
        private String clickOpenRatio;
        private String optOutRate;
        private String spamComplaintRate;

        public Integer getSent() {
            return sent;
        }

        public Integer getDelivered() {
            return delivered;
        }

        public Integer getTotalClicks() {
            return totalClicks;
        }

        public Integer getUniqueClicks() {
            return uniqueClicks;
        }

        public Integer getSoftBounced() {
            return softBounced;
        }

        public Integer getHardBounced() {
            return hardBounced;
        }

        public Integer getOptOuts() {
            return optOuts;
        }

        public Integer getSpamComplaints() {
            return spamComplaints;
        }

        public Integer getOpens() {
            return opens;
        }

        public String getDeliveryRate() {
            return deliveryRate;
        }

        public Integer getUniqueOpens() {
            return uniqueOpens;
        }

        public String getOpensRate() {
            return opensRate;
        }

        public String getClickThroughRate() {
            return clickThroughRate;
        }

        public String getClickOpenRatio() {
            return clickOpenRatio;
        }

        public String getUniqueClickThroughRate() {
            return uniqueClickThroughRate;
        }

        public String getOptOutRate() {
            return optOutRate;
        }

        public String getSpamComplaintRate() {
            return spamComplaintRate;
        }

        @Override
        public String toString() {
            return "Stats{"
                + "sent=" + sent
                + ", delivered=" + delivered
                + ", totalClicks=" + totalClicks
                + ", uniqueClicks=" + uniqueClicks
                + ", softBounced=" + softBounced
                + ", hardBounced=" + hardBounced
                + ", optOuts=" + optOuts
                + ", spamComplaints=" + spamComplaints
                + ", opens=" + opens
                + ", uniqueOpens=" + uniqueOpens
                + ", deliveryRate='" + deliveryRate + '\''
                + ", opensRate='" + opensRate + '\''
                + ", clickThroughRate='" + clickThroughRate + '\''
                + ", uniqueClickThroughRate='" + uniqueClickThroughRate + '\''
                + ", clickOpenRatio='" + clickOpenRatio + '\''
                + ", optOutRate='" + optOutRate + '\''
                + ", spamComplaintRate='" + spamComplaintRate + '\''
                + '}';
        }
    }

    @Override
    public String toString() {
        return "EmailStatsResponse{"
            + "stats=" + stats
            + '}';
    }
}
