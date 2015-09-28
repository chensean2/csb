package com.csb.core.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "aa_resource")
public class Resource extends BaseEntity<Long> {
   
    protected String name;
    
    protected String url;

    public Resource() {
    }

    public Resource(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
