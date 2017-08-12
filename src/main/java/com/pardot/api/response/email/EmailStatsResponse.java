package com.pardot.api.response.email;

/**
 * Represents the result of an EmailStats API request.
 */
public class EmailStatsResponse {
    private Stats stats;

    public Stats getStats() {
        return stats;
    }

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
