package com.csb.parser.component.service;

import com.csb.parser.component.model.AssignmentInfo;
import com.csb.parser.component.model.SubscriptionInfo;
import com.csb.parser.component.model.ValidationInfo;
import com.csb.parser.component.model.ValidationResult;

public class DefaultCSBParserService implements CSBParserService {

    @Override
    public String parseSubscription(SubscriptionInfo subscriptionInfo) {
        // TODO parse and save to db
        return null;
    }

    @Override
    public String parseAssignment(AssignmentInfo assignmentInfo) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public String parseValidation(ValidationInfo validationInfo){
        return null;
    }

}
