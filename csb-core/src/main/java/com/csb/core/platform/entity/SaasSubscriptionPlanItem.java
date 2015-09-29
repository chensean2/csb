package com.csb.core.platform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "csb_platform_saas_subscription_plan_item")
public class SaasSubscriptionPlanItem extends BaseEntity<Long> {

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unit")
    private String unit;

    @ManyToOne
    @JoinColumn(name = "saas_subscription_plan_id")
    private SaasSubscriptionPlan saasSubscriptionPlan;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public SaasSubscriptionPlan getSaaSSubscriptionPlan() {
        return saasSubscriptionPlan;
    }

    public void setSaaSSubscriptionPlan(SaasSubscriptionPlan saasSubscriptionPlan) {
        this.saasSubscriptionPlan = saasSubscriptionPlan;
    }

}