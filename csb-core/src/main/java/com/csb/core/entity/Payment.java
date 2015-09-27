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
@Table(name = "csb_payment")
public class Payment extends BaseEntity<Long> {

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@OneToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@OneToMany(mappedBy = "payment")
	private List<PaymentPlan> paymentPlanList;

}