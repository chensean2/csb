package com.csb.parser.component;

import com.csb.parser.component.model.AssignmentInfo;
import com.csb.parser.component.model.SubscriptionInfo;
import com.csb.parser.component.model.ValidationInfo;
import com.csb.parser.component.model.ValidationResult;

public interface ParserComponent {

    
    public String parse(SubscriptionInfo subscriptionInfo);
    
    public String parse(AssignmentInfo assignmentInfo);
    
    public String parse(ValidationInfo validationInfo);
}
