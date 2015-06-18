package com.csb.parser.component.service;

import com.csb.parser.component.model.AssignmentInfo;
import com.csb.parser.component.model.SubscriptionInfo;
import com.csb.parser.component.model.ValidationInfo;
import com.csb.parser.component.model.ValidationResult;

public interface CSBParserService {

    /**
     * The method will parse the subscription input and save the information to DB
     * @param subscriptionInfo
     * @return event id which will trace the subscription
     */
    public String parseSubscription(SubscriptionInfo subscriptionInfo);
    
    /**
     * The method will parse the assignment input and save the information to DB
     * @param assignmentInfo
     * @return event id
     */
    public String parseAssignment(AssignmentInfo assignmentInfo);
    
    public String parseValidation(ValidationInfo validationInfo);
    
}
