package com.csb.broker.component.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.csb.broker.component.BrokerComponent;
import com.csb.platform.core.PlatformCoreConstant;
import com.csb.platform.core.entity.Plan;
import com.csb.platfrom.core.repository.PlanRepository;

public class DefaultBrokerService implements BrokerService {

    @Autowired
    @Qualifier("saasBrokerComponent")
    private BrokerComponent saasBrokerComponent;

    @Autowired
    private PlanRepository planRepository;

    @Override
    public void broke(String eventId) {

        Plan plan = planRepository.findByEventId(eventId);
        if (plan != null && PlatformCoreConstant.RESOURCE_CATEGORY_SAAS.equals(plan.getCategory())) {
            saasBrokerComponent.broke(plan);
        }
    }

}
