package com.csb.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "csb_app_plan")
public class AppPlan {
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

    private String description;

    private String frequency;

    private String name;

    @Column(name = "trial_days")
    private Integer trialDays;

    @Column(name = "app_package_id")
    private Long appPackageId;

    @Column(name = "app_product_id")
    private Long appProductId;

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
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return frequency
     */
    public String getFrequency() {
        return frequency;
    }

    /**
     * @param frequency
     */
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return trial_days
     */
    public Integer getTrialDays() {
        return trialDays;
    }

    /**
     * @param trialDays
     */
    public void setTrialDays(Integer trialDays) {
        this.trialDays = trialDays;
    }

    /**
     * @return app_package_id
     */
    public Long getAppPackageId() {
        return appPackageId;
    }

    /**
     * @param appPackageId
     */
    public void setAppPackageId(Long appPackageId) {
        this.appPackageId = appPackageId;
    }

    /**
     * @return app_product_id
     */
    public Long getAppProductId() {
        return appProductId;
    }

    /**
     * @param appProductId
     */
    public void setAppProductId(Long appProductId) {
        this.appProductId = appProductId;
    }
}