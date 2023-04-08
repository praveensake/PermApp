package com.perm.model;

import java.util.Date;

public class Record {

        private String caseNumber;
        private String caseStatus;
        private Date receivedDate;
        private Date decisionDate;

    @Override
    public String toString() {
        return "Record{" +
                "caseNumber='" + caseNumber + '\'' +
                ", caseStatus='" + caseStatus + '\'' +
                ", receivedDate=" + receivedDate +
                ", decisionDate=" + decisionDate +
                '}';
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public Date getDecisionDate() {
        return decisionDate;
    }
}
