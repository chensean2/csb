package com.csb.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.csb.core.common.entity.BaseEntity;

@Entity
@Table(name = "tbl_csb_subscription_order_plan")
public class SubscriptionOrderPlan extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name="SUBSCRIPTION_ID")
    private Subscription subscription;

    @ManyToOne
    @JoinColumn(name="ORDER_PLAN_ID")
    private  OrderPlan orderPlan;

    @OneToOne
    @JoinColumn(name="IS_ACTIVE")
    private Boolean isActive;
    
}