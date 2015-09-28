package com.csb.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "csb_platform_saas_plan")
public class CsbPlatformSaasPlan {
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

    private String type;

    @Column(name = "saas_assignment_plan")
    private Long saasAssignmentPlan;

    @Column(name = "saas_subscription_plan_id")
    private Long saasSubscriptionPlanId;

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
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return saas_assignment_plan
     */
    public Long getSaasAssignmentPlan() {
        return saasAssignmentPlan;
    }

    /**
     * @param saasAssignmentPlan
     */
    public void setSaasAssignmentPlan(Long saasAssignmentPlan) {
        this.saasAssignmentPlan = saasAssignmentPlan;
    }

    /**
     * @return saas_subscription_plan_id
     */
    public Long getSaasSubscriptionPlanId() {
        return saasSubscriptionPlanId;
    }

    /**
     * @param saasSubscriptionPlanId
     */
    public void setSaasSubscriptionPlanId(Long saasSubscriptionPlanId) {
        this.saasSubscriptionPlanId = saasSubscriptionPlanId;
    }
}