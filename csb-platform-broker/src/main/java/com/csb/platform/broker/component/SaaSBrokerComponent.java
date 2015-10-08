package com.csb.platform.broker.component;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csb.common.constant.PlatformConstant;
import com.csb.core.model.PlatformPlan;
import com.csb.core.model.PlatformSaasPlan;
import com.csb.core.model.PlatformSaasProvisionResponse;
import com.csb.core.model.PlatformSaasSubscriptionPlan;
import com.csb.core.service.PlatformPlanService;
import com.csb.core.service.PlatformSaasPlanService;
import com.csb.core.service.PlatformSaasProvisionResponseService;
import com.csb.core.service.PlatformSaasSubscriptionPlanService;
import com.csb.platform.provision.saas.service.SaaSProvisionService;

@Component("saasBrokerComponent")
public class SaaSBrokerComponent implements BrokerComponent {

    //TODO, the first phase we will only consider the common saas provision service, we will extend this if we need customised service.
    @Autowired
    private SaaSProvisionService saasProvisionService;
    
    @Autowired
    private PlatformPlanService platformPlanService;
    
    @Autowired
    private PlatformSaasPlanService platformSaasPlanService;
    
    @Autowired
    private PlatformSaasSubscriptionPlanService platformSaasSubscriptionPlanService;
    
    @Autowired
    private PlatformSaasProvisionResponseService platformSaasProvisionResponseService;
    
    public void broke(PlatformPlan plan){
        PlatformSaasPlan saasPlan = platformSaasPlanService.get(plan.getSaasPlanId());
        if(saasPlan != null){
            if(PlatformConstant.PROVSION_TYPE_SUBSCRIPTION.equals(saasPlan.getType())){
                PlatformSaasSubscriptionPlan saasSubscriptionPlan = platformSaasSubscriptionPlanService.get(saasPlan.getSaasSubscriptionPlanId());
                if(saasSubscriptionPlan != null && "CREATE".equalsIgnoreCase(saasSubscriptionPlan.getAction())){
                    Map<String,String> responseMap = saasProvisionService.createSubscripiton(plan);
                    if(responseMap != null && responseMap.get("response") != null){
                    	String provisionResponse = responseMap.get("response");
                    	PlatformSaasProvisionResponse saasProvisionResponse = new PlatformSaasProvisionResponse();
                    	saasProvisionResponse.setSaasPlanId(plan.getSaasPlanId());
                    	saasProvisionResponse.setSuccessCode("true");
                    	saasProvisionResponse.setRaw(provisionResponse);
                    	platformSaasProvisionResponseService.save(saasProvisionResponse);
                    	
                    }else{
                    	//TODO failed
                    }
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
