package com.csb.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "csb_platform_saas_subscription_plan")
public class PlatformSaasSubscriptionPlan {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DT")
    private Date createdDt;

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @Column(name = "LAST_UPDATED_DT")
    private Date lastUpdatedDt;

    @Column(name = "VERSION")
    private Integer version;

    private String action;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_phonenumber")
    private String companyPhonenumber;

    @Column(name = "company_uuid")
    private String companyUuid;

    @Column(name = "creator_email")
    private String creatorEmail;

    @Column(name = "creator_firstname")
    private String creatorFirstname;

    @Column(name = "creator_lastname")
    private String creatorLastname;

    @Column(name = "creator_openid")
    private String creatorOpenid;

    @Column(name = "external_accout_id")
    private String externalAccoutId;

    @Column(name = "notification_type")
    private String notificationType;

    @Column(name = "plan_code")
    private String planCode;

    @Column(name = "previous_subscription_status")
    private String previousSubscriptionStatus;

    /**
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return CREATED_BY
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return CREATED_DT
     */
    public Date getCreatedDt() {
        return createdDt;
    }

    /**
     * @param createdDt
     */
    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    /**
     * @return LAST_UPDATED_BY
     */
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    /**
     * @param lastUpdatedBy
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * @return LAST_UPDATED_DT
     */
    public Date getLastUpdatedDt() {
        return lastUpdatedDt;
    }

    /**
     * @param lastUpdatedDt
     */
    public void setLastUpdatedDt(Date lastUpdatedDt) {
        this.lastUpdatedDt = lastUpdatedDt;
    }

    /**
     * @return VERSION
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @return action
     */
    public String getAction() {
        return action;
    }

    /**
     * @param action
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * @return company_name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return company_phonenumber
     */
    public String getCompanyPhonenumber() {
        return companyPhonenumber;
    }

    /**
     * @param companyPhonenumber
     */
    public void setCompanyPhonenumber(String companyPhonenumber) {
        this.companyPhonenumber = companyPhonenumber;
    }

    /**
     * @return company_uuid
     */
    public String getCompanyUuid() {
        return companyUuid;
    }

    /**
     * @param companyUuid
     */
    public void setCompanyUuid(String companyUuid) {
        this.companyUuid = companyUuid;
    }

    /**
     * @return creator_email
     */
    public String getCreatorEmail() {
        return creatorEmail;
    }

    /**
     * @param creatorEmail
     */
    public void setCreatorEmail(String creatorEmail) {
        this.creatorEmail = creatorEmail;
    }

    /**
     * @return creator_firstname
     */
    public String getCreatorFirstname() {
        return creatorFirstname;
    }

    /**
     * @param creatorFirstname
     */
    public void setCreatorFirstname(String creatorFirstname) {
        this.creatorFirstname = creatorFirstname;
    }

    /**
     * @return creator_lastname
     */
    public String getCreatorLastname() {
        return creatorLastname;
    }

    /**
     * @param creatorLastname
     */
    public void setCreatorLastname(String creatorLastname) {
        this.creatorLastname = creatorLastname;
    }

    /**
     * @return creator_openid
     */
    public String getCreatorOpenid() {
        return creatorOpenid;
    }

    /**
     * @param creatorOpenid
     */
    public void setCreatorOpenid(String creatorOpenid) {
        this.creatorOpenid = creatorOpenid;
    }

    /**
     * @return external_accout_id
     */
    public String getExternalAccoutId() {
        return externalAccoutId;
    }

    /**
     * @param externalAccoutId
     */
    public void setExternalAccoutId(String externalAccoutId) {
        this.externalAccoutId = externalAccoutId;
    }

    /**
     * @return notification_type
     */
    public String getNotificationType() {
        return notificationType;
    }

    /**
     * @param notificationType
     */
    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    /**
     * @return plan_code
     */
    public String getPlanCode() {
        return planCode;
    }

    /**
     * @param planCode
     */
    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    /**
     * @return previous_subscription_status
     */
    public String getPreviousSubscriptionStatus() {
        return previousSubscriptionStatus;
    }

    /**
     * @param previousSubscriptionStatus
     */
    public void setPreviousSubscriptionStatus(String previousSubscriptionStatus) {
        this.previousSubscriptionStatus = previousSubscriptionStatus;
    }
}