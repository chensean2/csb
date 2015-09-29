package com.csb.core.service;

import org.springframework.stereotype.Service;

import com.csb.core.mapper.PlatformPlanMapper;
import com.csb.core.model.PlatformPlan;

@Service("planService")
public class PlanServiceImpl extends BaseServiceImpl<PlatformPlan> implements PlanService {
    
    public PlatformPlanMapper getMapper() {
        return (PlatformPlanMapper)mapper;
    }
    
    
}