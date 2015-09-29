package com.csb.core.service;

import org.springframework.stereotype.Service;

import com.csb.core.mapper.CsbPlatformPlanMapper;
import com.csb.core.model.CsbPlatformPlan;;

@Service
public class PlanServiceImpl extends BaseServiceImpl<CsbPlatformPlan> implements PlanService {
    
    public CsbPlatformPlanMapper getMapper() {
        return (CsbPlatformPlanMapper)mapper;
    }
    
    
}