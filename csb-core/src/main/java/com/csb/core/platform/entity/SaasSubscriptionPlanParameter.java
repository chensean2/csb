package com.csb.core.platform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "csb_platform_saas_subscription_plan_parameter")
public class SaasSubscriptionPlanParameter extends BaseEntity<Long> {

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "saas_subscription_plan_id")
    private SaasSubscriptionPlan saasSubscriptionPlan;

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

    public SaasSubscriptionPlan getSaaSSubscriptionPlan() {
        return saasSubscriptionPlan;
    }

    public void setSaaSSubscriptionPlan(SaasSubscriptionPlan saasSubscriptionPlan) {
        this.saasSubscriptionPlan = saasSubscriptionPlan;
    }

}