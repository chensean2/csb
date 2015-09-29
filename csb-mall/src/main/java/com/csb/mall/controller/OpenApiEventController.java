package com.csb.mall.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csb.core.platform.entity.Plan;
import com.csb.core.platform.entity.SaasPlan;
import com.csb.core.platform.entity.SaasSubscriptionPlan;
import com.csb.core.platform.entity.SaasSubscriptionPlanItem;
import com.csb.core.platform.repository.PlanRepository;
import com.csb.openapi.event.model.Company;
import com.csb.openapi.event.model.Creator;
import com.csb.openapi.event.model.Order;
import com.csb.openapi.event.model.OrderItem;
import com.csb.openapi.event.model.Subscription;

@Controller
@RequestMapping(value = "/api/integration/events")
public class OpenApiEventController {

	private static Logger logger = LoggerFactory.getLogger(OpenApiEventController.class);

	@Autowired
	private PlanRepository planRepository;

	@Autowired
	private Validator validator;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	public Subscription get(@PathVariable("id") String eventId) {
		Subscription subscription = new Subscription();
		Plan plan = planRepository.findByEventId(eventId);
		SaasPlan saasPlan = plan.getSaasPlan();
		SaasSubscriptionPlan saasSubscriptionPlan = saasPlan.getSaaSSubscriptionPlan();
		if (saasPlan != null) {

			subscription.setTerm(saasPlan.getType());
			subscription.setAction(saasSubscriptionPlan.getAction());
			Company company = new Company();
			company.setName(saasSubscriptionPlan.getCompanyName());
			company.setPhoneNumber(saasSubscriptionPlan.getCompanyPhoneNumber());
			company.setUuid(saasSubscriptionPlan.getCompanyUUID());
			subscription.setCompany(company);

			Creator creator = new Creator();
			creator.setName(saasSubscriptionPlan.getCreatorLastName() + saasSubscriptionPlan.getCreatorFirstName());
			creator.setEmail(saasSubscriptionPlan.getCreatorEmail());
			creator.setOpenId(saasSubscriptionPlan.getCreatorOpenId());
			subscription.setCreator(creator);
			Order order = new Order();
			order.setPlanCode(saasSubscriptionPlan.getPlanCode());
			List<OrderItem> items = new ArrayList<OrderItem>();
			for (SaasSubscriptionPlanItem saasSubscriptionPlanItem : saasSubscriptionPlan.getSaaSSubscriptionPlanItemList()) {
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
