package com.csb.core.service;

import java.util.Set;

import com.csb.core.model.Permission;

public interface PermissionService extends BaseService<Permission>{
    
    public Set<Permission> findByRoleId(Long id);

}
