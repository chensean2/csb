package com.csb.core.model;

import javax.persistence.*;

@Table(name = "aa_role_resource")
public class RoleResource {
    @Id
    @Column(name = "role_id")
    private Long roleId;

    @Id
    @Column(name = "resource_id")
    private Long resourceId;

    /**
     * @return role_id
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * @return resource_id
     */
    public Long getResourceId() {
        return resourceId;
    }

    /**
     * @param resourceId
     */
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}