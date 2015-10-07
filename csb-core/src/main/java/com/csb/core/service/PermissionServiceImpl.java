package com.csb.core.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.csb.core.mapper.PermissionMapper;
import com.csb.core.mapper.RoleMapper;
import com.csb.core.model.Permission;
import com.csb.core.model.Role;

@Service("permissionService")
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements PermissionService{
    
    public PermissionMapper getMapper() {
        return (PermissionMapper)mapper;
    }
    
    public Set<Permission> findByRoleId(Long id)
    {
        return getMapper().findByRoleId(id);
    }

}
