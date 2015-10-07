package com.csb.core.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.csb.core.mapper.PermissionMapper;
import com.csb.core.mapper.ResourceMapper;
import com.csb.core.mapper.RoleMapper;
import com.csb.core.model.Permission;
import com.csb.core.model.Resource;
import com.csb.core.model.Role;

@Service("resourceService")
public class ResourceServiceImpl extends BaseServiceImpl<Resource> implements ResourceService{
    
    public ResourceMapper getMapper() {
        return (ResourceMapper)mapper;
    }
    
    public Set<Resource> findByRoleId(Long id)
    {
        return getMapper().findByRoleId(id);
    }

}
