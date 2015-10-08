package com.csb.platform.broker.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csb.common.constant.PlatformConstant;
import com.csb.core.model.PlatformIaasPlan;
import com.csb.core.model.PlatformPlan;
import com.csb.core.service.PlatformIaasPlanService;
import com.csb.core.service.PlatformPlanService;
import com.csb.platform.provision.iaas.service.IaaSProvisionService;

@Component("iaasBrokerComponent")
public class IaaSBrokerComponent implements BrokerComponent {

    @Autowired
    private IaaSProvisionService iaasProvisionService;
    
    
    @Autowired
    private PlatformPlanService platformPlanService;
    
    @Autowired
    private PlatformIaasPlanService platformIaasPlanService;
    
    public void broke(PlatformPlan plan){
        PlatformIaasPlan iaasPlan = platformIaasPlanService.get(plan.getIaasPlanId());
        if(iaasPlan != null){
            if(PlatformConstant.PROVSION_TYPE_SUBSCRIPTION.equals(iaasPlan.getType())){
                if("CREATE".equals(iaasPlan.getAction())){
                	iaasProvisionService.createServer(iaasPlan);
                }
            }
        }else{
            //TODO
        }
    }


}
