package com.csb.broker.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csb.common.constant.PlatformConstant;
import com.csb.core.platform.entity.IaaSPlan;
import com.csb.core.platform.entity.Plan;
import com.csb.platform.provision.iaas.service.IaaSProvisionService;

@Component("iaasBrokerComponent")
public class IaaSBrokerComponent implements BrokerComponent {

    @Autowired
    private IaaSProvisionService iaasProvisionService;
    
    public void broke(Plan plan){
        IaaSPlan iaasPlan = plan.getIaasPlan();
        if(iaasPlan != null){
            if(PlatformConstant.PROVSION_TYPE_SUBSCRIPTION.equals(iaasPlan.getType())){
                
            }
        }else{
            //TODO
        }
    }


}
