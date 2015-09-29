package com.csb.core.platform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "csb_platform_iaas_plan")
public class IaaSPlan extends BaseEntity<Long> {

    // ASSIGNMENT,SUBSCRIPTION
    @Column(name = "type")
    private String type;

    // OPENSTACK
    @Column(name = "provider")
    private String provider;

    // CREATE,UPDATE,CANCEL,START,STOP,..
    @Column(name = "action")
    private String action;

    @Column(name = "instance_name")
    private String instanceName;

    @Column(name = "instance_count")
    private String instanceCount;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "flavor")
    private String flavor;

    @Column(name = "cpus")
    private Integer cpus;

    @Column(name = "memory")
    private String memory;

    @Column(name = "storage")
    private String storage;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getInstanceCount() {
        return instanceCount;
    }

    public void setInstanceCount(String instanceCount) {
        this.instanceCount = instanceCount;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public Integer getCpus() {
        return cpus;
    }

    public void setCpus(Integer cpus) {
        this.cpus = cpus;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

}