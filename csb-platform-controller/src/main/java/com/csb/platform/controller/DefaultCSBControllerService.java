package com.csb.platform.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;

import com.csb.broker.component.service.CSBBrokerService;
import com.csb.parser.component.model.AssignmentInfo;
import com.csb.parser.component.model.AssignmentResult;
import com.csb.parser.component.model.AssignmentStatus;
import com.csb.parser.component.model.SubscriptionInfo;
import com.csb.parser.component.model.SubscriptionResult;
import com.csb.parser.component.model.SubscriptionStatus;
import com.csb.parser.component.model.ValidationInfo;
import com.csb.parser.component.model.ValidationResult;
import com.csb.parser.component.service.CSBParserService;

public class DefaultCSBControllerService implements CSBControllerService {

    @Autowired
    private CSBParserService csbParserService;

    @Autowired
    private CSBBrokerService csbBrokerService;
    
    @Override
    public SubscriptionResult createSubscription(SubscriptionInfo subscriptionInfo) {
        SubscriptionResult subscriptionResult = new SubscriptionResult();
        String eventId = null;
        try {
            eventId = csbParserService.parseSubscription(subscriptionInfo);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(eventId == null){
            //
            return subscriptionResult;
        }
        // TODO, in future, we need use MQ to handle the request asynchronously, current, we use thread to handle.
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new ParserRunable(eventId));
        return subscriptionResult;
    }

    @Override
    public SubscriptionResult updateSubscription(SubscriptionInfo subscriptionInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SubscriptionResult cancelSubscription(SubscriptionInfo subscriptionInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SubscriptionResult notify(SubscriptionInfo subscriptionInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ValidationResult validateSubscriptionParameter(ValidationInfo validationInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AssignmentResult assign(AssignmentInfo AssignmentInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AssignmentResult unAssign(AssignmentInfo AssignmentInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SubscriptionStatus getSubscriptionStatus(String requestId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AssignmentStatus getAssignmentStatus(String requestId) {
        // TODO Auto-generated method stub
        return null;
    }
    
    class ParserRunable implements Runnable{

        private String eventId;
        
        public ParserRunable(String eventId ){
            this.eventId = eventId;
        }
        @Override
        public void run() {
            
        }

            
    }
}
