package com.csb.platform.controller.util;

import com.csb.parser.component.model.SubscriptionInfo;

public class ParserRunable implements Runnable{

    private SubscriptionInfo subscriptionInfo;
    
    public ParserRunable(SubscriptionInfo subscriptionInfo){
        this.subscriptionInfo = subscriptionInfo;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }

	
}
