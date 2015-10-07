package com.csb.core.mapper;

import java.util.Set;

import com.csb.core.model.Resource;
import tk.mybatis.mapper.common.Mapper;

public interface ResourceMapper extends Mapper<Resource> {
    
    Set<Resource> findByRoleId(Long id);
}