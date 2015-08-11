package com.csb.parser.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csb.common.constant.PlatformConstant;
import com.csb.common.util.UUIDUtil;
import com.csb.core.platform.entity.Plan;
import com.csb.core.platform.entity.SaaSPlan;
import com.csb.core.platform.entity.SaaSSubscriptionPlan;
import com.csb.core.platform.entity.SaaSSubscriptionPlanItem;
import com.csb.core.platform.repository.PlanRepository;
import com.csb.parser.component.model.AssignmentInfo;
import com.csb.parser.component.model.CompanyInfo;
import com.csb.parser.component.model.CreatorInfo;
import com.csb.parser.component.model.SaaSInfo;
import com.csb.parser.component.model.SaaSPlanInfo;
import com.csb.parser.component.model.SaaSPlanItemInfo;
import com.csb.parser.component.model.SubscriptionInfo;
import com.csb.parser.component.model.ValidationInfo;

@Component("saasParserComponent")
public class SaaSParserComponent implements ParserComponent {

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
        
        SaaSInfo saasInfo = subscriptionInfo.getSaasInfo();
        CompanyInfo companyInfo = saasInfo.getCompanyInfo();
        CreatorInfo creatorInfo = saasInfo.getCreatorInfo();
        SaaSPlanInfo saasPlanInfo = saasInfo.getSaaSPlanInfo();
        List<SaaSPlanItemInfo> saasPlanItemInfoList = saasPlanInfo.getSaasPlanItemInfoList();
        
        SaaSPlan saasPlan = new SaaSPlan();
        saasPlan.setType(PlatformConstant.PROVSION_TYPE_SUBSCRIPTION);
        
        
        SaaSSubscriptionPlan saasSubscriptionPlan = new SaaSSubscriptionPlan();
        saasSubscriptionPlan.setAction(saasInfo.getAction());
        saasSubscriptionPlan.setCompanyName(companyInfo.getName());
        saasSubscriptionPlan.setCompanyPhoneNumber(companyInfo.getPhoneNumber());
        saasSubscriptionPlan.setCompanyUUID(companyInfo.getUuid());
        
        saasSubscriptionPlan.setCreatorEmail(creatorInfo.getEmail());
        saasSubscriptionPlan.setCreatorFirstName(creatorInfo.getFirstName());
        saasSubscriptionPlan.setCreatorLastName(creatorInfo.getLastName());
        saasSubscriptionPlan.setCreatorOpenId(creatorInfo.getOpenId());
        
        saasSubscriptionPlan.setPlanCode(saasPlanInfo.getPlanCode());
        List<SaaSSubscriptionPlanItem> saasSubscriptionPlanItemList = new ArrayList<SaaSSubscriptionPlanItem>();
        for(SaaSPlanItemInfo saasPlanItemInfo : saasPlanItemInfoList){
            SaaSSubscriptionPlanItem saasSubscriptionPlanItem = new SaaSSubscriptionPlanItem();
            saasSubscriptionPlanItem.setQuantity(saasPlanItemInfo.getQuantity());
            saasSubscriptionPlanItem.setUnit(saasPlanItemInfo.getUnit());
            saasSubscriptionPlanItemList.add(saasSubscriptionPlanItem);
        }
        saasSubscriptionPlan.setSaaSSubscriptionPlanItemList(saasSubscriptionPlanItemList);
        saasPlan.setSaaSSubscriptionPlan(saasSubscriptionPlan);
        
        plan.setSaasPlan(saasPlan);
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
