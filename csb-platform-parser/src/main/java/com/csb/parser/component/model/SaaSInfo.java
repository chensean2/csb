package com.csb.parser.component.model;

public class SaaSInfo {

    // CREATE,UPDATE,CANCEL,NOTICE
    private String action;

    private SaaSExternalAccountInfo saaSExternalAccountInfo;

    // Available when is subscription case
    private SaaSPlanInfo saaSPlanInfo;

    // Available when is subscription case
    private CompanyInfo companyInfo;

    // Available when is notification case
    private SaaSNotificationInfo saaSNotificationInfo;

    // Available when is assignment case
    private SaaSUserInfo saaSUserInfo;

    // Available when is subscription case and assignment case
    private CreatorInfo creatorInfo;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public SaaSExternalAccountInfo getSaaSExternalAccountInfo() {
        return saaSExternalAccountInfo;
    }

    public void setSaaSExternalAccountInfo(SaaSExternalAccountInfo saaSExternalAccountInfo) {
        this.saaSExternalAccountInfo = saaSExternalAccountInfo;
    }

    public SaaSPlanInfo getSaaSPlanInfo() {
        return saaSPlanInfo;
    }

    public void setSaaSPlanInfo(SaaSPlanInfo saaSPlanInfo) {
        this.saaSPlanInfo = saaSPlanInfo;
    }

    public CompanyInfo getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(CompanyInfo companyInfo) {
        this.companyInfo = companyInfo;
    }

    public SaaSNotificationInfo getSaaSNotificationInfo() {
        return saaSNotificationInfo;
    }

    public void setSaaSNotificationInfo(SaaSNotificationInfo saaSNotificationInfo) {
        this.saaSNotificationInfo = saaSNotificationInfo;
    }

    public SaaSUserInfo getSaaSUserInfo() {
        return saaSUserInfo;
    }

    public void setSaaSUserInfo(SaaSUserInfo saaSUserInfo) {
        this.saaSUserInfo = saaSUserInfo;
    }

    public CreatorInfo getCreatorInfo() {
        return creatorInfo;
    }

    public void setCreatorInfo(CreatorInfo creatorInfo) {
        this.creatorInfo = creatorInfo;
    }

}
