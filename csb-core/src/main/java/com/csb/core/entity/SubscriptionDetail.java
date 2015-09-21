package com.csb.core.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "tbl_csb_subscription_detail")
public class SubscriptionDetail extends BaseEntity<Long> {

	@ManyToOne
	@JoinColumn(name = "SUBSCRIPTION_ID")
	private Subscription subscription;

	@ManyToOne
	@JoinColumn(name = "ORDER_PLAN_ID")
	private OrderPlan orderPlan;

	@JoinColumn(name = "IS_ACTIVE")
	private Boolean isActive;
	
	@ManyToOne
        @JoinColumn(name = "APP_PLAN_ID")
        private AppPlan appPlan;
	
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
        
        @Column(name = "MAX_USER")
        private Integer maxUser;

}