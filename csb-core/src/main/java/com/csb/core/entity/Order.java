package com.csb.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.csb.core.common.entity.BaseEntity;

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
	
	//SUBMITTED,PAYMENT_SUCCESS,PAYMENT_FAILED,REMOTE_INPROGRESS,FAILED,SUCCESS,FINISHED,DELETED
	@Column(name="STATUS")
	private String status;
	
	//FREE_TRIAL,NORMAL
	@Column(name="TYPE")
	private String type;
	
	//CREATE,UPDATE
	@Column(name="ACTION")
	private String action;
}