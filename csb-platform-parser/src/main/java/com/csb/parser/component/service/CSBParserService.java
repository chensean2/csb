package com.csb.parser.component.service;

import com.csb.parser.component.model.AssignmentInfo;
import com.csb.parser.component.model.SubscriptionInfo;

public interface CSBParserService {

    /**
     * The method will parse the subscription input and save the information to DB
     * @param subscriptionInfo
     * @return IaaS/ PaaS/ SaaS Subscription Plan id which will trace the subscription
     */
    public Long parseSubscription(SubscriptionInfo subscriptionInfo);
    
    /**
     * The method will parse the assignment input and save the information to DB
     * @param assignmentInfo
     * @return assignment id
     */
    public Long parseAssignment(AssignmentInfo assignmentInfo);
    
}
