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

	@OneToMany(mappedBy = "subscription")
	private List<Assignment> assignmentList;

	// ACTIVE,SUSPENDED,CANCELLED,FREE_TRIAL,,FREE_TRIAL_EXPIRED
	@Column(name = "STATUS")
	private String status;

	// @OneToOne
	// @JoinColumn(name="ORDER_PLAN_ID")
	// private OrderPlan activeOrderPlan;

	@OneToMany(mappedBy = "subscription")
	List<SubscriptionDetail> subscriptionOrderPlanList;

	@Column(name = "EXTERNAL_ACCOUNT_ID")
	private String externalAccountId;

}