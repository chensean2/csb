package com.csb.parser.component.model;

public class SaaSExternalAccountInfo {

    // external account id which is from the App Provider
    private String externalAccountId;

    // current status of the subscription FREE_TRIAL,FREE_TRIAL_EXPIRED,ACTIVE,SUSPENDED,CANCELLED
    private String status;

    public String getExternalAccountId() {
        return externalAccountId;
    }

    public void setExternalAccountId(String externalAccountId) {
        this.externalAccountId = externalAccountId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
