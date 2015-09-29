package com.csb.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "csb_app_provider")
public class AppProvider {
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

    private String name;

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
}