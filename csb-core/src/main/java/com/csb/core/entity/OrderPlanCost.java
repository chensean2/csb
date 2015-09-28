package com.csb.core.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;


@Entity
@Table(name="csb_order_plan_cost")
public class OrderPlanCost extends BaseEntity<Long>  {

	@ManyToOne
	@JoinColumn(name="order_plan_id")
	private OrderPlan orderPlan;
	
	//PAYMENT,DISCOUNT
	@Column(name = "type")
	private String type;
	
	//Refer to AppPlanCost unit, for DISCOUNT type, the unit will be null
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "price", scale = 30, precision = 2)
	private BigDecimal price;
	
	//if type is DISCOUNT
	@Column(name = "discount_percentage")
	private float discountPercentage;
	
	@Column(name = "total_price", scale = 32, precision = 2)
	private BigDecimal totalPrice;
}