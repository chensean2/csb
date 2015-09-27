package com.csb.core.entity;

import java.util.HashSet;
import java.util.Set;

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

    
    protected String name;

    protected String description;

    protected String category;// PORTAL/ RESELLER/ TENANT

    protected boolean system = false;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "aa_role_permissions", joinColumns = { @JoinColumn(name = "role_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "permission_id", nullable = false, updatable = false) })
    protected Set<Permission> permissions;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "aa_role_resource", joinColumns = { @JoinColumn(name = "role_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "resource_id", nullable = false, updatable = false) })
    protected Set<Resource> resources;

    public Role() {
    }

    public Role(String name, String description, String category) {
        this.name = name;
        this.description = description;
        this.category = category;
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

    public boolean isSystem() {
        return system;
    }

    public void setSystem(boolean system) {
        this.system = system;
    }

    public Set<Permission> getPermissions() {
        if (permissions == null) {
            permissions = new HashSet<Permission>();
        }
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public void addPermission(Permission permission) {
        if (!getPermissions().contains(permission)) {
            getPermissions().add(permission);
        }
    }

    public void removePermission(Permission permission) {
        getPermissions().remove(permission);
    }

    public Set<Resource> getResources() {
        if (resources == null) {
            resources = new HashSet<Resource>();
        }
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }

    public void addResource(Resource resource) {
        if (!getResources().contains(resource)) {
            getResources().add(resource);
        }
    }

    public void removeResource(Resource resource) {
        getResources().remove(resource);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
