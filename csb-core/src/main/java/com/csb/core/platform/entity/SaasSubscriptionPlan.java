package com.csb.core.platform.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "csb_platform_saas_subscription_plan")
public class SaaSSubscriptionPlan extends BaseEntity<Long> {

    // CREATE,UPDATE,CANCEL,NOTICE
    @Column(name = "action")
    private String action;

    @Column(name = "plan_code")
    private String planCode;

    @Column(name = "company_uuid")
    private String companyUUID;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_phonenumber")
    private String companyPhoneNumber;

    @Column(name = "creator_openid")
    private String creatorOpenId;

    @Column(name = "creator_email")
    private String creatorEmail;

    @Column(name = "creator_firstname")
    private String creatorFirstName;

    @Column(name = "creator_lastname")
    private String creatorLastName;

    @Column(name = "external_accout_id")
    private String externalAccoutId;

    // this is for notification case, which is current status of the subscription
    // FREE_TRIAL,FREE_TRIAL_EXPIRED,ACTIVE,SUSPENDED,CANCELLED
    @Column(name = "previous_subscription_status")
    private String previousSubscriptionStatus;

    // DEACTIVATED
    @Column(name = "notification_type")
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