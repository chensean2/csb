package com.csb.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "csb_subscription_detail")
public class SubscriptionDetail {
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

    @Column(name = "trial_end_dt")
    private Date trialEndDt;

    @Column(name = "end_dt")
    private Date endDt;

    @Column(name = "isActive")
    private Boolean isactive;

    @Column(name = "is_trail")
    private Boolean isTrail;

    @Column(name = "max_user")
    private Integer maxUser;

    @Column(name = "start_dt")
    private Date startDt;

    @Column(name = "app_plan_id")
    private Long appPlanId;

    @Column(name = "order_plan_id")
    private Long orderPlanId;

    @Column(name = "subscription_id")
    private Long subscriptionId;

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
     * @return trial_end_dt
     */
    public Date getTrialEndDt() {
        return trialEndDt;
    }

    /**
     * @param trialEndDt
     */
    public void setTrialEndDt(Date trialEndDt) {
        this.trialEndDt = trialEndDt;
    }

    /**
     * @return end_dt
     */
    public Date getEndDt() {
        return endDt;
    }

    /**
     * @param endDt
     */
    public void setEndDt(Date endDt) {
        this.endDt = endDt;
    }

    /**
     * @return isActive
     */
    public Boolean getIsactive() {
        return isactive;
    }

    /**
     * @param isactive
     */
    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
    }

    /**
     * @return is_trail
     */
    public Boolean getIsTrail() {
        return isTrail;
    }

    /**
     * @param isTrail
     */
    public void setIsTrail(Boolean isTrail) {
        this.isTrail = isTrail;
    }

    /**
     * @return max_user
     */
    public Integer getMaxUser() {
        return maxUser;
    }

    /**
     * @param maxUser
     */
    public void setMaxUser(Integer maxUser) {
        this.maxUser = maxUser;
    }

    /**
     * @return start_dt
     */
    public Date getStartDt() {
        return startDt;
    }

    /**
     * @param startDt
     */
    public void setStartDt(Date startDt) {
        this.startDt = startDt;
    }

    /**
     * @return app_plan_id
     */
    public Long getAppPlanId() {
        return appPlanId;
    }

    /**
     * @param appPlanId
     */
    public void setAppPlanId(Long appPlanId) {
        this.appPlanId = appPlanId;
    }

    /**
     * @return order_plan_id
     */
    public Long getOrderPlanId() {
        return orderPlanId;
    }

    /**
     * @param orderPlanId
     */
    public void setOrderPlanId(Long orderPlanId) {
        this.orderPlanId = orderPlanId;
    }

    /**
     * @return subscription_id
     */
    public Long getSubscriptionId() {
        return subscriptionId;
    }

    /**
     * @param subscriptionId
     */
    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
}