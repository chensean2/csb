package com.csb.parser.component;

import org.springframework.beans.factory.annotation.Autowired;

import com.csb.common.constant.PlatformConstant;
import com.csb.common.util.UUIDUtil;
import com.csb.core.platform.entity.IaaSPlan;
import com.csb.core.platform.entity.Plan;
import com.csb.core.platform.repository.PlanRepository;
import com.csb.parser.component.model.AssignmentInfo;
import com.csb.parser.component.model.IaaSInfo;
import com.csb.parser.component.model.SubscriptionInfo;
import com.csb.parser.component.model.ValidationInfo;

public class IaaSParserComponent implements ParserComponent {

	@Autowired
	private PlanRepository planRepository;
	
    @Override
    public String parse(SubscriptionInfo subscriptionInfo) {
        
    	Plan plan = new Plan();
    	plan.setEventId(UUIDUtil.generate());
    	plan.setAppPlanId(subscriptionInfo.getAppPlanId());
    	plan.setCategory(subscriptionInfo.getCategory());
    	plan.setStatus(PlatformConstant.PROVSION_STATUS_PENDING);
    	plan.setTraceId(subscriptionInfo.getTraceId());
    	
    	IaaSInfo iaasInfor = subscriptionInfo.getIaasInfo();
    	IaaSPlan iaasPlan = new IaaSPlan();
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
    	plan.setIaasPlan(iaasPlan);
    	Plan planResult = planRepository.save(plan);
    	if(planResult == null){
    		return null;
    	}else{
    		return planResult.getEventId();
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
