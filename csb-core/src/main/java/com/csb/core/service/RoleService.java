package com.csb.core.service;

import java.util.Set;

import com.csb.core.model.Role;

public interface RoleService extends BaseService<Role>{
    
    public Set<Role> findByUserId(Long id);

}
