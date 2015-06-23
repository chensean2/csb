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
@Table(name = "tbl_csb_subscription")
public class Subscription extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name="COMPANY_ID")
    private Company company;

    @ManyToOne
    @JoinColumn(name="APP_PLAN_ID")
    private AppPlan appPlan;

    @OneToMany(mappedBy = "subscription")
    private List<Assignment> assignmentList;
    
  //ACTIVE,SUSPENDED,CANCELLED,FREE_TRIAL,,FREE_TRIAL_EXPIRED
    @Column(name="STATUS")
    private String status;
    
//    @OneToOne
//    @JoinColumn(name="ORDER_PLAN_ID")
//    private OrderPlan activeOrderPlan;
    
    @OneToMany(mappedBy="subscription")
    List<SubscriptionOrderPlan> subscriptionOrderPlanList;
    
}