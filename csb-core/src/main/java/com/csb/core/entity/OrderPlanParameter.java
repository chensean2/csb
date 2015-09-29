package com.csb.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;


@Entity
@Table(name="csb_order_plan_parameter")
public class OrderPlanParameter extends BaseEntity<Long>  {

	@ManyToOne
	@JoinColumn(name="order_plan_id")
	private OrderPlan orderPlan;
	
	@Column(name="name")
	private String name;
	
	@Column(name="value")
	private String value;

}