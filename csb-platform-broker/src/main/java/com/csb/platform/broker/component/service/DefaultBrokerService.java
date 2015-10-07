package com.csb.platform.broker.component.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csb.common.constant.PlatformConstant;
import com.csb.core.model.PlatformPlan;
import com.csb.core.service.PlatformPlanService;
import com.csb.core.service.PlatformSaasPlanService;
import com.csb.platform.broker.component.BrokerComponent;

@Service
public class DefaultBrokerService implements BrokerService {

    @Autowired
    @Qualifier("saasBrokerComponent")
    private BrokerComponent saasBrokerComponent;
    
    @Autowired
    @Qualifier("iaasBrokerComponent")
    private BrokerComponent iaasBrokerComponent;



    @Autowired
    private PlatformPlanService platformPlanService;

    @Autowired
    private PlatformSaasPlanService platformSaasPlanService;

    @Override
    @Transactional
    public void broke(String eventId) {
        PlatformPlan plan = platformPlanService.getPlanByEventId(eventId);
        if (plan != null && PlatformConstant.RESOURCE_CATEGORY_SAAS.equals(plan.getCategory())) {
            saasBrokerComponent.broke(plan);
        }else if (plan != null && PlatformConstant.RESOURCE_CATEGORY_IAAS.equals(plan.getCategory())) {
            iaasBrokerComponent.broke(plan);
        }
    }

}
