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
@Table(name = "tbl_csb_order")
public class Order extends BaseEntity<Long> {

	@ManyToOne
	@JoinColumn(name = "COMPANY_ID")
	private Company company;

	@OneToMany(mappedBy = "order")
	private List<OrderPlan> orderPlanList;

	@OneToOne
	@JoinColumn(name = "PAYMENT_ID")
	private Payment payment;
	
	//SUBMITTED,PAYMENT_SUCCESS,PAYMENT_FAILED,REMOTE_INPROGRESS,FAILED,SUCCESS
	@Column(name="STATUS")
	private String status;
	
}