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

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "csb_order_plan")
public class OrderPlan extends BaseEntity<Long> {

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "app_plan_id")
	private AppPlan appPlan;

	@OneToMany(mappedBy = "orderPlan")
	private List<OrderPlanCost> orderPlanCostList;

	@OneToMany(mappedBy = "orderPlan")
	private List<OrderPlanParameter> orderPlanParameterList;

	@OneToOne
	@JoinColumn(name = "payment_plan_id")
	private PaymentPlan paymentPlan;

	// SUBMITTED,REMOTE_INPROGRESS,FAILED,SUCCESS
	@Column(name = "status")
	private String status;

	// FREE_TRIAL,NORMAL
	@Column(name = "type")
	private String type;

	// CREATE,UPDATE
	@Column(name = "action")
	private String action;
	
	//ONE_TIME, MONTHLY, QUATERLY, SIX_MONTHS, YEARLY, TWO_YEARS, DAILY
	@Column(name = "frequency")
	private String frequency;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_dt")
	private Date startDt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_dt")
	private Date endDt;

	@Column(name = "price", scale = 2, precision = 32)
	private BigDecimal price;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@Column(name = "discount")
	private Float discount;
}