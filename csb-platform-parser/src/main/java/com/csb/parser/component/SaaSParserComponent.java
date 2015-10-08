package com.csb.parser.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csb.common.constant.PlatformConstant;
import com.csb.common.util.UUIDUtil;
import com.csb.core.model.PlatformPlan;
import com.csb.core.model.PlatformSaasPlan;
import com.csb.core.model.PlatformSaasSubscriptionPlan;
import com.csb.core.model.PlatformSaasSubscriptionPlanItem;
import com.csb.core.service.PlatformPlanService;
import com.csb.core.service.PlatformSaasPlanService;
import com.csb.core.service.PlatformSaasSubscriptionPlanItemService;
import com.csb.core.service.PlatformSaasSubscriptionPlanService;
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
    private PlatformPlanService platformPlanService;
    
    @Autowired
    private PlatformSaasPlanService platformSaasPlanService;
    
    @Autowired
    private PlatformSaasSubscriptionPlanService platformSaasSubscriptionPlanService;
    
    @Autowired
    private PlatformSaasSubscriptionPlanItemService platformSaasSubscriptionPlanItemService;
    
    
    @Override
    public String parse(SubscriptionInfo subscriptionInfo) {
        
        SaaSInfo saasInfo = subscriptionInfo.getSaasInfo();
        SaaSPlanInfo saasPlanInfo = saasInfo.getSaaSPlanInfo();
        List<SaaSPlanItemInfo> saasPlanItemInfoList = saasPlanInfo.getSaasPlanItemInfoList();
        CompanyInfo companyInfo = saasInfo.getCompanyInfo();
        CreatorInfo creatorInfo = saasInfo.getCreatorInfo();
        
        
        PlatformSaasSubscriptionPlan saasSubscriptionPlan = new PlatformSaasSubscriptionPlan();
        saasSubscriptionPlan.setAction(saasInfo.getAction());
        saasSubscriptionPlan.setCompanyName(companyInfo.getName());
        saasSubscriptionPlan.setCompanyPhonenumber(companyInfo.getPhoneNumber());
        saasSubscriptionPlan.setCompanyUuid(companyInfo.getUuid());
        saasSubscriptionPlan.setCreatorEmail(creatorInfo.getEmail());
        saasSubscriptionPlan.setCreatorFirstname(creatorInfo.getFirstName());
        saasSubscriptionPlan.setCreatorLastname(creatorInfo.getLastName());
        saasSubscriptionPlan.setCreatorOpenid(creatorInfo.getOpenId());
        saasSubscriptionPlan.setPlanCode(saasPlanInfo.getPlanCode());
        Long saasSubscriptionPlanId = platformSaasSubscriptionPlanService.save(saasSubscriptionPlan);
        
        
        for(SaaSPlanItemInfo saasPlanItemInfo : saasPlanItemInfoList){
            PlatformSaasSubscriptionPlanItem saasSubscriptionPlanItem = new PlatformSaasSubscriptionPlanItem();
            saasSubscriptionPlanItem.setQuantity(saasPlanItemInfo.getQuantity());
            saasSubscriptionPlanItem.setUnit(saasPlanItemInfo.getUnit());
            saasSubscriptionPlanItem.setSaasSubscriptionPlanId(saasSubscriptionPlanId);
            platformSaasSubscriptionPlanItemService.save(saasSubscriptionPlanItem);
        }
        
        
        PlatformSaasPlan saasPlan = new PlatformSaasPlan();
        saasPlan.setType(PlatformConstant.PROVSION_TYPE_SUBSCRIPTION);
        saasPlan.setSaasSubscriptionPlanId(saasSubscriptionPlanId);
        Long saasPlanId = platformSaasPlanService.save(saasPlan);
        
        
        PlatformPlan plan = new PlatformPlan();
        plan.setEventId(UUIDUtil.generate());
        plan.setAppPlanId(subscriptionInfo.getAppPlanId());
        plan.setCategory(subscriptionInfo.getCategory());
        plan.setStatus(PlatformConstant.PROVSION_STATUS_PENDING);
        plan.setTraceId(subscriptionInfo.getTraceId());
        plan.setSaasPlanId(saasPlanId);
        Long planId = platformPlanService.save(plan);
        
        if(planId == null){
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
