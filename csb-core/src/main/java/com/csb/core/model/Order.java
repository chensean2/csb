package com.csb.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "csb_order")
public class Order {
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

    private String status;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "payment_id")
    private Long paymentId;

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
     * @return company_id
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * @return payment_id
     */
    public Long getPaymentId() {
        return paymentId;
    }

    /**
     * @param paymentId
     */
    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }
}