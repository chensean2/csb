package com.csb.broker.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csb.core.PlatformCoreConstant;
import com.csb.core.platform.entity.Plan;
import com.csb.core.platform.entity.SaaSPlan;
import com.csb.core.platform.entity.SaaSSubscriptionPlan;
import com.csb.platform.provision.service.SaaSProvisionService;

@Component("saasBrokerComponent")
public class SaaSBrokerComponent implements BrokerComponent {

    //TODO, the first phase we will only consider the common saas provision service, we will extend this if we need customised service.
    @Autowired
    private SaaSProvisionService saasProvisionService;
    
    public void broke(Plan plan){
        SaaSPlan saasPlan = plan.getSaaSPlan();
        if(saasPlan != null){
            if(PlatformCoreConstant.PROVSION_TYPE_SUBSCRIPTION.equals(saasPlan.getType())){
                SaaSSubscriptionPlan saasSubscriptionPlan = saasPlan.getSaaSSubscriptionPlan();
                if(saasSubscriptionPlan != null){
                    saasProvisionService.createSubscripiton(plan.getEventId());
                }else{
                    //TODO
                }
                
                //TOOD
            }
        }else{
            //TODO
        }
    }


}
