package com.csb.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "aa_permission")
public class Permission extends BaseEntity<Long>{

    protected String name;

    @Column(length = 255)
    protected String description;


    public Permission() {
    }


    public Permission(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


}
