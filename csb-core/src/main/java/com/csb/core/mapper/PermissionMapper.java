package com.csb.core.mapper;

import java.util.Set;

import com.csb.core.model.Permission;
import tk.mybatis.mapper.common.Mapper;

public interface PermissionMapper extends Mapper<Permission> {

    Set<Permission> findByRoleId(Long id);
}