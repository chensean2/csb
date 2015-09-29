package com.csb.core.platform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "csb_platform_saas_subscription_plan_parameter")
public class SaaSSubscriptionPlanParameter extends BaseEntity<Long> {

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "saas_subscription_plan_id")
    private SaaSSubscriptionPlan saaSSubscriptionPlan;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public SaaSSubscriptionPlan getSaaSSubscriptionPlan() {
        return saaSSubscriptionPlan;
    }

    public void setSaaSSubscriptionPlan(SaaSSubscriptionPlan saaSSubscriptionPlan) {
        this.saaSSubscriptionPlan = saaSSubscriptionPlan;
    }

}