package com.csb.mall.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csb.core.model.PlatformPlan;
import com.csb.core.model.PlatformSaasPlan;
import com.csb.core.model.PlatformSaasSubscriptionPlan;
import com.csb.core.model.PlatformSaasSubscriptionPlanItem;
import com.csb.core.service.PlatformPlanService;
import com.csb.core.service.PlatformSaasPlanService;
import com.csb.core.service.PlatformSaasSubscriptionPlanItemService;
import com.csb.core.service.PlatformSaasSubscriptionPlanService;
import com.csb.openapi.event.model.Company;
import com.csb.openapi.event.model.Creator;
import com.csb.openapi.event.model.Order;
import com.csb.openapi.event.model.OrderItem;
import com.csb.openapi.event.model.Subscription;

@RestController
@RequestMapping(value = "/api/integration/events")
public class OpenApiEventController {

    private static Logger logger = LoggerFactory.getLogger(OpenApiEventController.class);

    @Autowired
    private PlatformPlanService platformPlanService;

    @Autowired
    private PlatformSaasPlanService platformSaasPlanService;

    @Autowired
    private PlatformSaasSubscriptionPlanService platformSaasSubscriptionPlanService;

    @Autowired
    private PlatformSaasSubscriptionPlanItemService platformSaasSubscriptionPlanItemService;
    
    
    @Autowired
    private Validator validator;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public Subscription get(@PathVariable("id") String eventId) {
        Subscription subscription = new Subscription();
        PlatformPlan plan = platformPlanService.getPlanByEventId(eventId);
        PlatformSaasPlan saasPlan = platformSaasPlanService.get(plan.getSaasPlanId());
        PlatformSaasSubscriptionPlan saasSubscriptionPlan = platformSaasSubscriptionPlanService.get(saasPlan.getSaasSubscriptionPlanId());
        if (saasPlan != null) {

            subscription.setTerm(saasPlan.getType());
            subscription.setAction(saasSubscriptionPlan.getAction());
            Company company = new Company();
            company.setName(saasSubscriptionPlan.getCompanyName());
            company.setPhoneNumber(saasSubscriptionPlan.getCompanyPhonenumber());
            company.setUuid(saasSubscriptionPlan.getCompanyUuid());
            subscription.setCompany(company);

            Creator creator = new Creator();
            creator.setName(saasSubscriptionPlan.getCreatorLastname() + saasSubscriptionPlan.getCreatorFirstname());
            creator.setEmail(saasSubscriptionPlan.getCreatorEmail());
            creator.setOpenId(saasSubscriptionPlan.getCreatorOpenid());
            subscription.setCreator(creator);
            Order order = new Order();
            order.setPlanCode(saasSubscriptionPlan.getPlanCode());
            List<OrderItem> items = new ArrayList<OrderItem>();
            PlatformSaasSubscriptionPlanItem paramPlatformSaasSubscriptionPlanItem = new PlatformSaasSubscriptionPlanItem();
            paramPlatformSaasSubscriptionPlanItem.setSaasSubscriptionPlanId(saasSubscriptionPlan.getId());
            List<PlatformSaasSubscriptionPlanItem> platformSaasSubscriptionPlanItemList = platformSaasSubscriptionPlanItemService.find(paramPlatformSaasSubscriptionPlanItem);
            for (PlatformSaasSubscriptionPlanItem saasSubscriptionPlanItem : platformSaasSubscriptionPlanItemList) {
                OrderItem orderItem = new OrderItem();
                orderItem.setQuantity(saasSubscriptionPlanItem.getQuantity());
                orderItem.setUnit(saasSubscriptionPlanItem.getUnit());
                items.add(orderItem);
            }
            order.setItems(items);
            subscription.setOrder(order);
        }
        return subscription;
    }

}
