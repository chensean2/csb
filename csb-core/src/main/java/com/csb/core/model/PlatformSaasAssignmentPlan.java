package com.csb.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "csb_platform_saas_assignment_plan")
public class PlatformSaasAssignmentPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_dt")
    private Date createdDt;

    @Column(name = "last_updated_by")
    private String lastUpdatedBy;

    @Column(name = "last_updated_dt")
    private Date lastUpdatedDt;

    private Integer version;

    private String action;

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

    @Column(name = "external_assignment_id")
    private String externalAssignmentId;

    private String status;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_firstname")
    private String userFirstname;

    @Column(name = "user_lastname")
    private String userLastname;

    @Column(name = "user_openid")
    private String userOpenid;

    /**
     * @return id
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
     * @return created_by
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
     * @return created_dt
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
     * @return last_updated_by
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
     * @return last_updated_dt
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
     * @return version
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
     * @return external_assignment_id
     */
    public String getExternalAssignmentId() {
        return externalAssignmentId;
    }

    /**
     * @param externalAssignmentId
     */
    public void setExternalAssignmentId(String externalAssignmentId) {
        this.externalAssignmentId = externalAssignmentId;
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return user_email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return user_firstname
     */
    public String getUserFirstname() {
        return userFirstname;
    }

    /**
     * @param userFirstname
     */
    public void setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
    }

    /**
     * @return user_lastname
     */
    public String getUserLastname() {
        return userLastname;
    }

    /**
     * @param userLastname
     */
    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    /**
     * @return user_openid
     */
    public String getUserOpenid() {
        return userOpenid;
    }

    /**
     * @param userOpenid
     */
    public void setUserOpenid(String userOpenid) {
        this.userOpenid = userOpenid;
    }
}