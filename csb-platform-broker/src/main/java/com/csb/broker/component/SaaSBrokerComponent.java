package com.csb.broker.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csb.platform.provision.service.SaaSProvisionService;

@Component()
public class SaaSBrokerComponent implements BrokerComponent {

    //TODO, the first phase we will only consider the common saas provision service, we will extend this if we need customised service.
    @Autowired
    private SaaSProvisionService saasProvisionService;
    
    public void broke(String eventId){
        //TODO: check which provision method to call for different eventID.
    }


}
