package com.csb.core.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.csb.core.common.entity.BaseEntity;


@Entity
@Table(name="tbl_csb_order_plan_cost")
public class OrderPlanCost extends BaseEntity<Long>  {

	@ManyToOne
	@JoinColumn(name="ORDER_PLAN_ID")
	private OrderPlan orderPlan;
	
	//PAYMENT,DISCOUNT
	@Column(name = "TYPE")
	private String type;
	
	//Refer to AppPlanCost unit, for DISCOUNT type, the unit will be null
	@Column(name = "UNIT")
	private String unit;
	
	@Column(name = "QUANTITY")
	private Integer quantity;

	@Column(name = "PRICE", scale = 32, precision = 2)
	private BigDecimal price;
	
	//if type is DISCOUNT
	@Column(name = "DISCOUNT_PERCENTAGE")
	private float discountPercentage;
	
	@Column(name = "TOTAL_PRICE", scale = 32, precision = 2)
	private BigDecimal totalPrice;
}