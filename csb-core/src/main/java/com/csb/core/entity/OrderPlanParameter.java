package com.csb.core.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.csb.core.common.entity.BaseEntity;


@Entity
@Table(name="tbl_csb_order_plan_item")
public class OrderPlanParameter extends BaseEntity<Long>  {

	@ManyToOne
	@JoinColumn(name="ORDER_PLAN_ID")
	private OrderPlan orderPlan;
	


}