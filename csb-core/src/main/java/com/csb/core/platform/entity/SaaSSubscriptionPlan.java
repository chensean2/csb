package com.csb.core.platform.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "tbl_csb_platform_saas_subscription_plan")
public class SaaSSubscriptionPlan extends BaseEntity<Long> {

    // CREATE,UPDATE,CANCEL,NOTICE
    @Column(name = "ACTION")
    private String action;

    @Column(name = "PLAN_CODE")
    private String planCode;

    @Column(name = "COMPANY_UUID")
    private String companyUUID;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    @Column(name = "COMPANY_PHONENUMBER")
    private String companyPhoneNumber;

    @Column(name = "CREATOR_OPENID")
    private String creatorOpenId;

    @Column(name = "CREATOR_EMAIL")
    private String creatorEmail;

    @Column(name = "CREATOR_FIRSTNAME")
    private String creatorFirstName;

    @Column(name = "CREATOR_LASTNAME")
    private String creatorLastName;

    @Column(name = "EXTERNAL_ACCOUT_ID")
    private String externalAccoutId;

    // this is for notification case, which is current status of the subscription
    // FREE_TRIAL,FREE_TRIAL_EXPIRED,ACTIVE,SUSPENDED,CANCELLED
    @Column(name = "PREVIOUS_SUBSCRIPTION_STATUS")
    private String previousSubscriptionStatus;

    // DEACTIVATED
    @Column(name = "NOTIFICATION_TYPE")
    private String notificationType;

    @OneToMany(mappedBy = "saaSSubscriptionPlan",cascade=CascadeType.ALL)
    private List<SaaSSubscriptionPlanItem> saaSSubscriptionPlanItemList;

    @OneToMany(mappedBy = "saaSSubscriptionPlan",cascade=CascadeType.ALL)
    private List<SaaSSubscriptionPlanParameter> saaSSubscriptionPlanParameterList;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public String getCompanyUUID() {
        return companyUUID;
    }

    public void setCompanyUUID(String companyUUID) {
        this.companyUUID = companyUUID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPhoneNumber() {
        return companyPhoneNumber;
    }

    public void setCompanyPhoneNumber(String companyPhoneNumber) {
        this.companyPhoneNumber = companyPhoneNumber;
    }

    public String getCreatorOpenId() {
        return creatorOpenId;
    }

    public void setCreatorOpenId(String creatorOpenId) {
        this.creatorOpenId = creatorOpenId;
    }

    public String getCreatorEmail() {
        return creatorEmail;
    }

    public void setCreatorEmail(String creatorEmail) {
        this.creatorEmail = creatorEmail;
    }

    public String getCreatorFirstName() {
        return creatorFirstName;
    }

    public void setCreatorFirstName(String creatorFirstName) {
        this.creatorFirstName = creatorFirstName;
    }

    public String getCreatorLastName() {
        return creatorLastName;
    }

    public void setCreatorLastName(String creatorLastName) {
        this.creatorLastName = creatorLastName;
    }

    public String getExternalAccoutId() {
        return externalAccoutId;
    }

    public void setExternalAccoutId(String externalAccoutId) {
        this.externalAccoutId = externalAccoutId;
    }

    public String getPreviousSubscriptionStatus() {
        return previousSubscriptionStatus;
    }

    public void setPreviousSubscriptionStatus(String previousSubscriptionStatus) {
        this.previousSubscriptionStatus = previousSubscriptionStatus;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public List<SaaSSubscriptionPlanItem> getSaaSSubscriptionPlanItemList() {
        return saaSSubscriptionPlanItemList;
    }

    public void setSaaSSubscriptionPlanItemList(List<SaaSSubscriptionPlanItem> saaSSubscriptionPlanItemList) {
        this.saaSSubscriptionPlanItemList = saaSSubscriptionPlanItemList;
    }

    public List<SaaSSubscriptionPlanParameter> getSaaSSubscriptionPlanParameterList() {
        return saaSSubscriptionPlanParameterList;
    }

    public void setSaaSSubscriptionPlanParameterList(List<SaaSSubscriptionPlanParameter> saaSSubscriptionPlanParameterList) {
        this.saaSSubscriptionPlanParameterList = saaSSubscriptionPlanParameterList;
    }

}