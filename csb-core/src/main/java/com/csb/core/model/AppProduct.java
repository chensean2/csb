package com.csb.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "csb_app_product")
public class AppProduct {
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

    private String description;

    @Column(name = "list_logo")
    private String listLogo;

    private String name;

    @Column(name = "profile_logo")
    private String profileLogo;

    @Column(name = "app_package_id")
    private Long appPackageId;

    @Column(name = "app_product_integration_definition_id")
    private Long appProductIntegrationDefinitionId;

    @Column(name = "app_provider_id")
    private Long appProviderId;

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
     * @return list_logo
     */
    public String getListLogo() {
        return listLogo;
    }

    /**
     * @param listLogo
     */
    public void setListLogo(String listLogo) {
        this.listLogo = listLogo;
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
     * @return profile_logo
     */
    public String getProfileLogo() {
        return profileLogo;
    }

    /**
     * @param profileLogo
     */
    public void setProfileLogo(String profileLogo) {
        this.profileLogo = profileLogo;
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
     * @return app_product_integration_definition_id
     */
    public Long getAppProductIntegrationDefinitionId() {
        return appProductIntegrationDefinitionId;
    }

    /**
     * @param appProductIntegrationDefinitionId
     */
    public void setAppProductIntegrationDefinitionId(Long appProductIntegrationDefinitionId) {
        this.appProductIntegrationDefinitionId = appProductIntegrationDefinitionId;
    }

    /**
     * @return app_provider_id
     */
    public Long getAppProviderId() {
        return appProviderId;
    }

    /**
     * @param appProviderId
     */
    public void setAppProviderId(Long appProviderId) {
        this.appProviderId = appProviderId;
    }
}