package com.csb.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "csb_app_product")
public class CsbAppProduct {
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