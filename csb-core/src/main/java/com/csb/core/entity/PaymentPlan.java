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
@Table(name = "tbl_csb_payment_plan")
public class PaymentPlan extends BaseEntity<Long> {

	@ManyToOne
	@JoinColumn(name = "PAYMENT_ID")
	private Payment payment;

	@OneToOne
	@JoinColumn(name = "ORDER_PLAN_ID")
	private OrderPlan orderPlan;

}