package com.csb.parser.component;

import com.csb.parser.component.model.AssignmentInfo;
import com.csb.parser.component.model.SubscriptionInfo;

public interface ParserComponent {

    
    public String invokeParseSubscription(SubscriptionInfo subscriptionInfo);
    
    public String invokeParseAssignment(AssignmentInfo assignmentInfo);
    
}
