package com.csb.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "csb_platform_iaas_plan")
public class PlatformIaasPlan {
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

    private String action;

    private Integer cpus;

    private String flavor;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "instance_count")
    private String instanceCount;

    @Column(name = "instance_name")
    private String instanceName;

    private String memory;

    private String provider;

    private String storage;

    private String type;

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
     * @return action
     */
    public String getAction() {
        return action;
    }

    /**
     * @param action
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * @return cpus
     */
    public Integer getCpus() {
        return cpus;
    }

    /**
     * @param cpus
     */
    public void setCpus(Integer cpus) {
        this.cpus = cpus;
    }

    /**
     * @return flavor
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * @param flavor
     */
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    /**
     * @return image_name
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * @param imageName
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    /**
     * @return instance_count
     */
    public String getInstanceCount() {
        return instanceCount;
    }

    /**
     * @param instanceCount
     */
    public void setInstanceCount(String instanceCount) {
        this.instanceCount = instanceCount;
    }

    /**
     * @return instance_name
     */
    public String getInstanceName() {
        return instanceName;
    }

    /**
     * @param instanceName
     */
    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    /**
     * @return memory
     */
    public String getMemory() {
        return memory;
    }

    /**
     * @param memory
     */
    public void setMemory(String memory) {
        this.memory = memory;
    }

    /**
     * @return provider
     */
    public String getProvider() {
        return provider;
    }

    /**
     * @param provider
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }

    /**
     * @return storage
     */
    public String getStorage() {
        return storage;
    }

    /**
     * @param storage
     */
    public void setStorage(String storage) {
        this.storage = storage;
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
}