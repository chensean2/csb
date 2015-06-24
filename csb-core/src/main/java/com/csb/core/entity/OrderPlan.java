package com.csb.core.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.csb.core.common.entity.BaseEntity;

@Entity
@Table(name = "tbl_csb_order_plan")
public class OrderPlan extends BaseEntity<Long> {

	@ManyToOne
	@JoinColumn(name = "ORDER_ID")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "APP_PLAN_ID")
	private AppPlan appPlan;

	@OneToMany(mappedBy = "orderPlan")
	private List<OrderPlanCost> orderPlanCostList;

	@OneToMany(mappedBy = "orderPlan")
	private List<OrderPlanParameter> orderPlanParameterList;

	@OneToOne
	@JoinColumn(name = "PAYMENT_PLAN_ID")
	private PaymentPlan paymentPlan;

	// SUBMITTED,REMOTE_INPROGRESS,FAILED,SUCCESS
	@Column(name = "STATUS")
	private String status;

	// FREE_TRIAL,NORMAL
	@Column(name = "TYPE")
	private String type;

	// CREATE,UPDATE
	@Column(name = "ACTION")
	private String action;
	
	//ONE_TIME, MONTHLY, QUATERLY, SIX_MONTHS, YEARLY, TWO_YEARS, DAILY
	@Column(name = "FREQUENCY")
	private String frequency;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DT")
	private Date startDt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_DT")
	private Date endDt;

	@Column(name = "PRICE", scale = 32, precision = 2)
	private BigDecimal price;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@ManyToOne
	@JoinColumn(name = "COMPANY_ID")
	private Company company;

	@Column(name = "DISCOUNT")
	private Float discount;
}