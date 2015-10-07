package com.csb.core.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.csb.core.mapper.RoleMapper;
import com.csb.core.model.Role;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{
    
    public RoleMapper getMapper() {
        return (RoleMapper)mapper;
    }
    
    public Set<Role> findByUserId(Long id)
    {
        return getMapper().findByUserId(id);
    }

}
