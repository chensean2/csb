package com.csb.core.service;

import org.springframework.stereotype.Service;

import com.csb.core.mapper.PlatformSaasPlanMapper;
import com.csb.core.model.PlatformSaasPlan;

@Service("platformSaasPlanService")
public class PlatformSaasPlanServiceImpl extends BaseServiceImpl<PlatformSaasPlan> implements PlatformSaasPlanService {
    
    public PlatformSaasPlanMapper getMapper() {
        return (PlatformSaasPlanMapper)mapper;
    }
    
    
}