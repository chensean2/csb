package com.csb.parser.component.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.csb.parser.component.ParserComponent;
import com.csb.parser.component.model.AssignmentInfo;
import com.csb.parser.component.model.SubscriptionInfo;
import com.csb.parser.component.model.ValidationInfo;

@Service
public class DefaultParserService implements ParserService {

	@Autowired
	@Qualifier("saasParserComponent")
	private ParserComponent saasParserComponent;
	
	@Autowired
	@Qualifier("iaasParserComponent")
	private ParserComponent iaasParserComponent;
	
	@Override
    public String parseSubscription(SubscriptionInfo subscriptionInfo) {
        // TODO parse and save to db
    	if(subscriptionInfo == null){
    		return null;
    	}
    	String eventId = null;
    	if("IAAS".equals( subscriptionInfo.getCategory())){
    		eventId = iaasParserComponent.parse(subscriptionInfo);
    	}else if("SAAS".equals( subscriptionInfo.getCategory())){
    		eventId = saasParserComponent.parse(subscriptionInfo);
    	}else if("PAAS".equals( subscriptionInfo.getCategory())){
    		
    	}
    	
        return eventId;
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
