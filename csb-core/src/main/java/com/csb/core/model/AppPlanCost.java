package com.csb.core.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "csb_app_plan_cost")
public class AppPlanCost {
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

    @Column(name = "max_units")
    private Integer maxUnits;

    @Column(name = "min_units")
    private Integer minUnits;

    private BigDecimal price;

    private String unit;

    @Column(name = "app_plan_id")
    private Long appPlanId;

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
     * @return max_units
     */
    public Integer getMaxUnits() {
        return maxUnits;
    }

    /**
     * @param maxUnits
     */
    public void setMaxUnits(Integer maxUnits) {
        this.maxUnits = maxUnits;
    }

    /**
     * @return min_units
     */
    public Integer getMinUnits() {
        return minUnits;
    }

    /**
     * @param minUnits
     */
    public void setMinUnits(Integer minUnits) {
        this.minUnits = minUnits;
    }

    /**
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
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
}