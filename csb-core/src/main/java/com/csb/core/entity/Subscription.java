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
@Table(name = "tbl_csb_subscription")
public class Subscription extends BaseEntity<Long> {

	@ManyToOne
	@JoinColumn(name = "COMPANY_ID")
	private Company company;

	@ManyToOne
	@JoinColumn(name = "APP_PLAN_ID")
	private AppPlan appPlan;

	@OneToMany(mappedBy = "subscription")
	private List<Assignment> assignmentList;

	// ACTIVE,SUSPENDED,CANCELLED,FREE_TRIAL,,FREE_TRIAL_EXPIRED
	@Column(name = "STATUS")
	private String status;

	// @OneToOne
	// @JoinColumn(name="ORDER_PLAN_ID")
	// private OrderPlan activeOrderPlan;

	@OneToMany(mappedBy = "subscription")
	List<SubscriptionOrderPlan> subscriptionOrderPlanList;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DT")
	private Date startDt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_DT")
	private Date endDt;

	@Column(name = "IS_TRAIL")
	private Boolean isTrail;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TRIAL_END_DT")
	private Date TrialEndDt;

	@Column(name = "EXTERNAL_ACCOUNT_ID")
	private String externalAccountId;

	@Column(name = "MAX_USER")
	private Integer maxUser;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

}