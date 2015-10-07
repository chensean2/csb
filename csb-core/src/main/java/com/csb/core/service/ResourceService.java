package com.csb.core.service;

import java.util.Set;

import com.csb.core.model.Resource;

public interface ResourceService extends BaseService<Resource>{
    
    public Set<Resource> findByRoleId(Long id);

}
