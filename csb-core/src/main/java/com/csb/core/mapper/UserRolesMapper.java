package com.csb.core.mapper;

import java.util.List;

import com.csb.core.model.UserRoles;
import tk.mybatis.mapper.common.Mapper;

public interface UserRolesMapper extends Mapper<UserRoles> {
    
    void batchInsert(List<UserRoles> entityList);
    
}