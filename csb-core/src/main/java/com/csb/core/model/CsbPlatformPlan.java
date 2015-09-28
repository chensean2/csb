package com.csb.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "csb_platform_plan")
public class CsbPlatformPlan {
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

    @Column(name = "app_plan_id")
    private String appPlanId;

    private String category;

    @Column(name = "event_id")
    private String eventId;

    private String message;

    private String status;

    @Column(name = "trace_id")
    private String traceId;

    @Column(name = "iaas_plan_id")
    private Long iaasPlanId;

    @Column(name = "saas_plan_id")
    private Long saasPlanId;

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
     * @return app_plan_id
     */
    public String getAppPlanId() {
        return appPlanId;
    }

    /**
     * @param appPlanId
     */
    public void setAppPlanId(String appPlanId) {
        this.appPlanId = appPlanId;
    }

    /**
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return event_id
     */
    public String getEventId() {
        return eventId;
    }

    /**
     * @param eventId
     */
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    /**
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
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
     * @return trace_id
     */
    public String getTraceId() {
        return traceId;
    }

    /**
     * @param traceId
     */
    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    /**
     * @return iaas_plan_id
     */
    public Long getIaasPlanId() {
        return iaasPlanId;
    }

    /**
     * @param iaasPlanId
     */
    public void setIaasPlanId(Long iaasPlanId) {
        this.iaasPlanId = iaasPlanId;
    }

    /**
     * @return saas_plan_id
     */
    public Long getSaasPlanId() {
        return saasPlanId;
    }

    /**
     * @param saasPlanId
     */
    public void setSaasPlanId(Long saasPlanId) {
        this.saasPlanId = saasPlanId;
    }
}