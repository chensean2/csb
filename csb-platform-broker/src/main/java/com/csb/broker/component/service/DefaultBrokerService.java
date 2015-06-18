package com.csb.broker.component.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.csb.broker.component.BrokerComponent;


public class DefaultBrokerService implements BrokerService {

    @Autowired
    private BrokerComponent brokerComponent;
    
    @Override
    public void broke(String eventId) {
        // TODO check the type, if is saas, will call SaaSBrokerComponent
        
    }

    

}
