package com.csb.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "aa_resource")
public class Resource extends BaseEntity<Long> {
   
    @Column(name = "name")
    private String name;
    
    @Column(name = "url")
    private String url;

    
}
