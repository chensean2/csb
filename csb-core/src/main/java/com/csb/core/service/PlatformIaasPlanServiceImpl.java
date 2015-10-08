package com.csb.core.service;

import org.springframework.stereotype.Service;

import com.csb.core.mapper.PlatformIaasPlanMapper;
import com.csb.core.model.PlatformIaasPlan;

@Service("olatformIaasPlanService")
public class PlatformIaasPlanServiceImpl extends BaseServiceImpl<PlatformIaasPlan> implements PlatformIaasPlanService {
    
    public PlatformIaasPlanMapper getMapper() {
        return (PlatformIaasPlanMapper)mapper;
    }
    
    
}