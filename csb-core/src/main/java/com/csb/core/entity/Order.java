package com.csb.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "csb_order")
public class Order extends BaseEntity<Long> {

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@OneToMany(mappedBy = "order")
	private List<OrderPlan> orderPlanList;

	@OneToOne
	@JoinColumn(name="payment_id")
	private Payment payment;
	
	//SUBMITTED,PAYMENT_SUCCESS,PAYMENT_FAILED,REMOTE_INPROGRESS,FAILED,SUCCESS
	@Column(name="status")
	private String status;
	
}