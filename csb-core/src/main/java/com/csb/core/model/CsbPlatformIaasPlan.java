package com.csb.core.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "csb_platform_iaas_plan")
public class CsbPlatformIaasPlan {
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