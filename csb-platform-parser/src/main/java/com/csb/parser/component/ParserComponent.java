package com.csb.parser.component;

import com.csb.parser.component.model.AssignmentInfo;
import com.csb.parser.component.model.SubscriptionInfo;
import com.csb.parser.component.model.ValidationInfo;
import com.csb.parser.component.model.ValidationResult;

public interface ParserComponent {

    
    public String parseSubscription(SubscriptionInfo subscriptionInfo);
    
    public String parseAssignment(AssignmentInfo assignmentInfo);
    
    public String parseValidation(ValidationInfo validationInfo);
}
