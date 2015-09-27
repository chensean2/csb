package com.csb.core.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "csb_payment_plan")
public class PaymentPlan extends BaseEntity<Long> {

	@ManyToOne
	@JoinColumn(name = "payment_id")
	private Payment payment;

	@OneToOne
	@JoinColumn(name = "order_plan_id")
	private OrderPlan orderPlan;

}