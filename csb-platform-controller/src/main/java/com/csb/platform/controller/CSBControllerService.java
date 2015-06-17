package com.csb.platform.controller;

import java.util.Map;

import com.csb.parser.component.model.AssignmentInfo;
import com.csb.parser.component.model.AssignmentResult;
import com.csb.parser.component.model.SubscriptionInfo;
import com.csb.parser.component.model.SubscriptionResult;

public interface CSBControllerService {

    public String createSubscription(SubscriptionInfo subscriptionInfo);
    
    public String updateSubscription(SubscriptionInfo subscriptionInfo);
    
    public String cancelSubscription(SubscriptionInfo subscriptionInfo);
    
    public String notify(SubscriptionInfo subscriptionInfo);
    
    public Map<String, Object> validateSubscriptionParameter(Map<String, Object> parameterMap);
    
    public String assign(AssignmentInfo AssignmentInfo);
    
    public String unAssign(AssignmentInfo AssignmentInfo);
    
    public SubscriptionResult getSubscriptionResult(String traceId);
    
    public AssignmentResult getAssignmentResult(String traceId);
}
