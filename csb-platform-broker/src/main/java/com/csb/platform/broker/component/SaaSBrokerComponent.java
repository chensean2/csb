package com.csb.platform.broker.component;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csb.common.constant.PlatformConstant;
import com.csb.core.platform.entity.Plan;
import com.csb.core.platform.entity.SaasPlan;
import com.csb.core.platform.entity.SaasProvisionResponse;
import com.csb.core.platform.entity.SaasSubscriptionPlan;
import com.csb.core.platform.repository.SaasProvisionResponseRepository;
import com.csb.platform.provision.saas.service.SaaSProvisionService;

@Component("saasBrokerComponent")
public class SaaSBrokerComponent implements BrokerComponent {

    //TODO, the first phase we will only consider the common saas provision service, we will extend this if we need customised service.
    @Autowired
    private SaaSProvisionService saasProvisionService;
    @Autowired
    private SaasProvisionResponseRepository saasProvisionResponseRepository;
    
    public void broke(Plan plan){
        SaasPlan saasPlan = plan.getSaasPlan();
        if(saasPlan != null){
            if(PlatformConstant.PROVSION_TYPE_SUBSCRIPTION.equals(saasPlan.getType())){
                SaasSubscriptionPlan saasSubscriptionPlan = saasPlan.getSaaSSubscriptionPlan();
                if(saasSubscriptionPlan != null && "CREATE".equalsIgnoreCase(saasSubscriptionPlan.getAction())){
                    Map<String,String> responseMap = saasProvisionService.createSubscripiton(plan);
                    if(responseMap != null && responseMap.get("response") != null){
                    	String provisionResponse = responseMap.get("response");
                    	SaasProvisionResponse saasProvisionResponse = new SaasProvisionResponse();
                    	saasProvisionResponse.setSaasPlan(saasPlan);
                    	saasProvisionResponse.setSuccessCode("true");
                    	saasProvisionResponse.setRaw(provisionResponse);
                    	saasProvisionResponseRepository.save(saasProvisionResponse);
                    	
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
