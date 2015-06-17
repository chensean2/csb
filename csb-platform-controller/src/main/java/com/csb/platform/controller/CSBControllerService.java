package com.csb.platform.controller;

import java.util.Map;

import com.csb.platform.controller.model.AssignmentInfo;
import com.csb.platform.controller.model.SubscriptionInfo;

public interface CSBControllerService {

    public String createSubscription(SubscriptionInfo subscriptionInfo);
    
    public String updateSubscription(SubscriptionInfo subscriptionInfo);
    
    public String cancelSubscription(SubscriptionInfo subscriptionInfo);
    
    public String notify(SubscriptionInfo subscriptionInfo);
    
    public Map<String, Object> validateSubscriptionParameter(Map<String, Object> parameterMap);
    
    public String assign(AssignmentInfo AssignmentInfo);
    
    public String unAssign(AssignmentInfo AssignmentInfo);
}
