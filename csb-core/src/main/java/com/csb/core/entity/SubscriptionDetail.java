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
@Table(name = "csb_subscription_detail")
public class SubscriptionDetail extends BaseEntity<Long> {

	@ManyToOne
	@JoinColumn(name = "subscription_id")
	private Subscription subscription;

	@ManyToOne
	@JoinColumn(name = "order_plan_id")
	private OrderPlan orderPlan;

	@JoinColumn(name = "is_active")
	private Boolean isActive;
	
	@ManyToOne
        @JoinColumn(name = "app_plan_id")
        private AppPlan appPlan;
	
	@Temporal(TemporalType.TIMESTAMP)
        @Column(name = "start_dt")
        private Date startDt;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "end_dt")
        private Date endDt;

        @Column(name = "is_trail")
        private Boolean isTrail;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "trial_end_dt")
        private Date TrialEndDt;
        
        @Column(name = "max_user")
        private Integer maxUser;

}