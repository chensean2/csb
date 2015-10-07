package com.csb.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "aa_permission")
public class Permission extends BaseEntity<Long>{

    @Column(name = "name")
    private String name;

    @Column(name = "description",length = 255)
    private String description;


}
