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
@Table(name = "tbl_csb_payment")
public class Payment extends BaseEntity<Long> {

	@ManyToOne
	@JoinColumn(name = "COMPANY_ID")
	private Company company;

	@OneToOne
	@JoinColumn(name = "ORDER_ID")
	private Order order;

	@OneToMany(mappedBy = "payment")
	private List<PaymentPlan> paymentPlanList;

}