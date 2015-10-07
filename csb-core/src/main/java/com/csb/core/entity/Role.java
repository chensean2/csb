package com.csb.core.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "aa_role")
public class Role extends BaseEntity<Long> {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;// PORTAL/ RESELLER/ TENANT

    @Column(name = "system")
    private boolean system;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "aa_role_permissions", joinColumns = { @JoinColumn(name = "role_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "permission_id", nullable = false, updatable = false) })
    private Set<Permission> permissions;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "aa_role_resource", joinColumns = { @JoinColumn(name = "role_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "resource_id", nullable = false, updatable = false) })
    private Set<Resource> resources;

    
}
