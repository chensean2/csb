package com.csb.platform.broker.component;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csb.common.constant.PlatformConstant;
import com.csb.core.platform.entity.Plan;
import com.csb.core.platform.entity.SaaSPlan;
import com.csb.core.platform.entity.SaaSProvisionResponse;
import com.csb.core.platform.entity.SaaSSubscriptionPlan;
import com.csb.core.platform.repository.SaaSProvisionResponseRepository;
import com.csb.platform.provision.saas.service.SaaSProvisionService;

@Component("saasBrokerComponent")
public class SaaSBrokerComponent implements BrokerComponent {

    //TODO, the first phase we will only consider the common saas provision service, we will extend this if we need customised service.
    @Autowired
    private SaaSProvisionService saasProvisionService;
    @Autowired
    private SaaSProvisionResponseRepository saasProvisionResponseRepository;
    
    public void broke(Plan plan){
        SaaSPlan saasPlan = plan.getSaasPlan();
        if(saasPlan != null){
            if(PlatformConstant.PROVSION_TYPE_SUBSCRIPTION.equals(saasPlan.getType())){
                SaaSSubscriptionPlan saasSubscriptionPlan = saasPlan.getSaaSSubscriptionPlan();
                if(saasSubscriptionPlan != null && "CREATE".equalsIgnoreCase(saasSubscriptionPlan.getAction())){
                    Map<String,String> responseMap = saasProvisionService.createSubscripiton(plan);
                    if(responseMap != null && responseMap.get("response") != null){
                    	String provisionResponse = responseMap.get("response");
                    	SaaSProvisionResponse saasProvisionResponse = new SaaSProvisionResponse();
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
