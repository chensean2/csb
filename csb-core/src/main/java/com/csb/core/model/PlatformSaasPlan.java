package com.csb.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "csb_platform_saas_plan")
public class PlatformSaasPlan {
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

    private String type;

    @Column(name = "saas_assignment_plan")
    private Long saasAssignmentPlan;

    @Column(name = "saas_subscription_plan_id")
    private Long saasSubscriptionPlanId;

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