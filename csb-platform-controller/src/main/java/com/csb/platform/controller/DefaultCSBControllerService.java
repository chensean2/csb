package com.csb.platform.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.csb.parser.component.model.AssignmentInfo;
import com.csb.parser.component.model.AssignmentResult;
import com.csb.parser.component.model.SubscriptionInfo;
import com.csb.parser.component.model.SubscriptionResult;
import com.csb.parser.component.service.CSBParserService;

public class DefaultCSBControllerService implements CSBControllerService {

    @Autowired
    private CSBParserService csbParserService;
    
    @Override
    public String createSubscription(SubscriptionInfo subscriptionInfo) {
        Long subscriptionPlanId = null;
        try {
            subscriptionPlanId = csbParserService.parseSubscription(subscriptionInfo);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        
        return null;
    }

    @Override
    public String updateSubscription(SubscriptionInfo subscriptionInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String cancelSubscription(SubscriptionInfo subscriptionInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String notify(SubscriptionInfo subscriptionInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, Object> validateSubscriptionParameter(Map<String, Object> parameterMap) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String assign(AssignmentInfo AssignmentInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String unAssign(AssignmentInfo AssignmentInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SubscriptionResult getSubscriptionResult(String traceId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AssignmentResult getAssignmentResult(String traceId) {
        // TODO Auto-generated method stub
        return null;
    }

}
