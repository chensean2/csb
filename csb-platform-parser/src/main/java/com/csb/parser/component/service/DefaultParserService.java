package com.csb.parser.component.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csb.parser.component.IaaSParserComponent;
import com.csb.parser.component.SaaSParserComponent;
import com.csb.parser.component.model.AssignmentInfo;
import com.csb.parser.component.model.SubscriptionInfo;
import com.csb.parser.component.model.ValidationInfo;

public class DefaultParserService implements ParserService {

	@Autowired
	private SaaSParserComponent saasParserComponent;
	
	@Autowired
	private IaaSParserComponent iaasParserComponent;
	
	@Override
    public String parseSubscription(SubscriptionInfo subscriptionInfo) {
        // TODO parse and save to db
    	if(subscriptionInfo == null){
    		return null;
    	}
    	if("IAAS".equals( subscriptionInfo.getCategory())){
    		iaasParserComponent.parse(subscriptionInfo);
    	}else if("SAAS".equals( subscriptionInfo.getCategory())){
    		
    	}else if("PAAS".equals( subscriptionInfo.getCategory())){
    		
    	}
    	
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
