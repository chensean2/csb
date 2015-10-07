package com.csb.parser.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csb.common.constant.PlatformConstant;
import com.csb.common.util.UUIDUtil;
import com.csb.core.model.PlatformIaasPlan;
import com.csb.core.model.PlatformPlan;
import com.csb.core.service.PlatformIaasPlanService;
import com.csb.core.service.PlatformPlanService;
import com.csb.parser.component.model.AssignmentInfo;
import com.csb.parser.component.model.IaaSInfo;
import com.csb.parser.component.model.SubscriptionInfo;
import com.csb.parser.component.model.ValidationInfo;

@Component("iaasParserComponent")
public class IaaSParserComponent implements ParserComponent {

    @Autowired
    private PlatformPlanService platformPlanService;
    
    @Autowired
    private PlatformIaasPlanService platformIaasPlanService;
    
    
    @Override
    public String parse(SubscriptionInfo subscriptionInfo) {
        
        IaaSInfo iaasInfor = subscriptionInfo.getIaasInfo();
        
        PlatformIaasPlan iaasPlan = new PlatformIaasPlan();
        iaasPlan.setType(PlatformConstant.PROVSION_TYPE_SUBSCRIPTION);
        iaasPlan.setAction(iaasInfor.getAction());
        iaasPlan.setInstanceName(iaasInfor.getInstanceName());
        iaasPlan.setInstanceCount(iaasInfor.getInstanceCount());
        iaasPlan.setFlavor(iaasInfor.getFlavor());
        iaasPlan.setCpus(iaasInfor.getCpus());
        iaasPlan.setStorage(iaasInfor.getStorage());
        iaasPlan.setMemory(iaasInfor.getMemory());
        iaasPlan.setProvider(iaasInfor.getProvider());
        iaasPlan.setImageName(iaasInfor.getImageName());
        Long iaasPlanId = platformIaasPlanService.save(iaasPlan);
        
        
    	PlatformPlan plan = new PlatformPlan();
    	plan.setEventId(UUIDUtil.generate());
    	plan.setAppPlanId(subscriptionInfo.getAppPlanId());
    	plan.setCategory(subscriptionInfo.getCategory());
    	plan.setStatus(PlatformConstant.PROVSION_STATUS_PENDING);
    	plan.setTraceId(subscriptionInfo.getTraceId());
    	plan.setIaasPlanId(iaasPlanId);
    	Long platformId = platformPlanService.save(plan);
    	
    	if(platformId == null){
    		return null;
    	}else{
    		return plan.getEventId();
    	}
    }

    @Override
    public String parse(AssignmentInfo assignmentInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String parse(ValidationInfo validationInfo) {
        // TODO Auto-generated method stub
        return null;
    }


}
