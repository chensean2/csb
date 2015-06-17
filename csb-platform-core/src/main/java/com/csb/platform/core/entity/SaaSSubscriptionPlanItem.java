package com.csb.platform.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_csb_platform_saas_subscription_plan_item")
public class SaaSSubscriptionPlanItem extends BaseEntity<Long> {
	
	@Column(name = "QUANTITY")
	private String quantity;
	
	@Column(name = "UNIT")
	private String unit;

	@ManyToOne
	@JoinColumn(name = "SAAS_SUBSCRIPTION_PLAN_ID")
	private SaaSSubscriptionPlan saaSSubscriptionPlan;
}