package com.csb.core.service;

import org.springframework.stereotype.Service;

import com.csb.core.mapper.PlatformSaasAssignmentPlanMapper;
import com.csb.core.model.PlatformSaasAssignmentPlan;

@Service("platformSaasAssignmentPlanService")
public class PlatformSaasAssignmentPlanServiceImpl extends BaseServiceImpl<PlatformSaasAssignmentPlan> implements PlatformSaasAssignmentPlanService {
    
    public PlatformSaasAssignmentPlanMapper getMapper() {
        return (PlatformSaasAssignmentPlanMapper)mapper;
    }
    
    
}