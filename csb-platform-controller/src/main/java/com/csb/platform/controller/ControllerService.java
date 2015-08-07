package com.csb.platform.controller;

import com.csb.parser.component.model.AssignmentInfo;
import com.csb.parser.component.model.AssignmentResult;
import com.csb.parser.component.model.AssignmentStatus;
import com.csb.parser.component.model.SubscriptionInfo;
import com.csb.parser.component.model.SubscriptionResult;
import com.csb.parser.component.model.SubscriptionStatus;
import com.csb.parser.component.model.ValidationInfo;
import com.csb.parser.component.model.ValidationResult;

public interface ControllerService {

    /**
     * this method is asynchronous, you need check status via getSubscriptionStatus
     * @param subscriptionInfo contains the input information
     * @return id for client checking provision status, if 
     */
    public SubscriptionResult createSubscription(SubscriptionInfo subscriptionInfo);
    
    public SubscriptionResult updateSubscription(SubscriptionInfo subscriptionInfo);
    
    public SubscriptionResult cancelSubscription(SubscriptionInfo subscriptionInfo);
    
    public SubscriptionResult notify(SubscriptionInfo subscriptionInfo);
    
    public ValidationResult validateSubscriptionParameter(ValidationInfo validationInfo);
    
    public AssignmentResult assign(AssignmentInfo AssignmentInfo);
    
    public AssignmentResult unAssign(AssignmentInfo AssignmentInfo);
    
    public SubscriptionStatus getSubscriptionStatus(String requestId);
    
    public AssignmentStatus getAssignmentStatus(String requestId);
    
    public void broke(String eventId);
}
