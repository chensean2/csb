package com.csb.platform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csb.core.model.PlatformPlan;
import com.csb.core.model.PlatformSaasPlan;
import com.csb.core.model.PlatformSaasProvisionResponse;
import com.csb.core.platform.entity.SaasProvisionResponse;
import com.csb.core.service.PlatformPlanService;
import com.csb.core.service.PlatformSaasPlanService;
import com.csb.core.service.PlatformSaasProvisionResponseService;
import com.csb.parser.component.model.AssignmentInfo;
import com.csb.parser.component.model.AssignmentResult;
import com.csb.parser.component.model.AssignmentStatus;
import com.csb.parser.component.model.SubscriptionInfo;
import com.csb.parser.component.model.SubscriptionResult;
import com.csb.parser.component.model.SubscriptionStatus;
import com.csb.parser.component.model.ValidationInfo;
import com.csb.parser.component.model.ValidationResult;
import com.csb.parser.component.service.ParserService;
import com.csb.platform.broker.component.service.BrokerService;

@Service
public class DefaultControllerService implements ControllerService {

    @Autowired
    private ParserService csbParserService;

    @Autowired
    private BrokerService csbBrokerService;

    @Autowired
    private PlatformPlanService platformPlanService;

    @Autowired
    private PlatformSaasPlanService platformSaasPlanService;

    @Autowired
    private PlatformSaasProvisionResponseService platformSaasProvisionResponseService;


    @Transactional
    @Override
    public SubscriptionResult createSubscription(SubscriptionInfo subscriptionInfo) {
        SubscriptionResult subscriptionResult = new SubscriptionResult();
        String eventId = null;
        try {
            eventId = csbParserService.parseSubscription(subscriptionInfo);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (eventId == null) {
            //
            return subscriptionResult;
        }
        subscriptionResult.setEventId(eventId);
        // TODO, in future, we need use MQ to handle the request asynchronously, current, we use thread to handle.
        // ExecutorService executorService = Executors.newSingleThreadExecutor();
        // executorService.execute(new ParserRunable(eventId));
        return subscriptionResult;
    }

    @Override
    public SubscriptionResult updateSubscription(SubscriptionInfo subscriptionInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SubscriptionResult cancelSubscription(SubscriptionInfo subscriptionInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SubscriptionResult notify(SubscriptionInfo subscriptionInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ValidationResult validateSubscriptionParameter(ValidationInfo validationInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AssignmentResult assign(AssignmentInfo AssignmentInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AssignmentResult unAssign(AssignmentInfo AssignmentInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional
    public SubscriptionStatus getSubscriptionStatus(String eventId) {
        SubscriptionStatus status = new SubscriptionStatus();
        // TODO
        status.setStatus("INPROCESS");

        PlatformPlan plan = platformPlanService.getPlanByEventId(eventId);

        if (plan != null) {
            Long saasPlanId = plan.getSaasPlanId();
            PlatformSaasProvisionResponse paramPlatformSaasProvisionResponse = new PlatformSaasProvisionResponse();
            paramPlatformSaasProvisionResponse.setSaasPlanId(saasPlanId);
            List<PlatformSaasProvisionResponse> saaSProvisionResponseList = platformSaasProvisionResponseService.find(paramPlatformSaasProvisionResponse);
            if (saaSProvisionResponseList != null && saaSProvisionResponseList.size() > 0) {
                PlatformSaasProvisionResponse saasProvisionResponse = saaSProvisionResponseList.get(0);
                if (saasProvisionResponse.getSuccessCode().equals("true")) {
                    status.setStatus("SUCCESS");
                } else {
                    status.setStatus("FAILED");
                }
                status.setRaw(saasProvisionResponse.getRaw());
            }
        }
        return status;
    }

    @Override
    public AssignmentStatus getAssignmentStatus(String eventId) {
        // TODO Auto-generated method stub
        return null;
    }

    class ParserRunable implements Runnable {

        private String eventId;

        public ParserRunable(String eventId) {
            this.eventId = eventId;
        }

        @Override
        public void run() {
            csbBrokerService.broke(eventId);
        }

    }

    @Override
    public void broke(String eventId) {
        csbBrokerService.broke(eventId);
    }
}
