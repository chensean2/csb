package com.csb.core.mapper;

import java.util.Set;

import com.csb.core.model.Role;
import tk.mybatis.mapper.common.Mapper;

public interface RoleMapper extends Mapper<Role> {
    
    Set<Role> findByUserId(Long id);
}