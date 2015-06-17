package com.csb.core.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.csb.core.common.entity.BaseEntity;

@Entity
@Table(name = "tbl_csb_order_plan")
public class OrderPlan extends BaseEntity<Long> {

	@ManyToOne
	@JoinColumn(name = "ORDER_ID")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "APP_PLAN_ID")
	private AppPlan appPlan;

	@OneToMany(mappedBy = "orderPlan")
	private List<OrderPlanItem> orderPlanList;

	@OneToMany(mappedBy = "orderPlan")
	private List<OrderPlanParameter> orderParameterList;

	@OneToOne
	@JoinColumn(name = "PAYMENT_PLAN_ID")
	private PaymentPlan paymentPlan;
}