package com.csb.platform.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_csb_platform_saas_validation_plan")
public class SaaSValidationPlan extends BaseEntity<Long> {

    @Column(name = "NAME")
    private String name;

    @Column(name = "VALUE")
    private String value;

    @ManyToOne
    @JoinColumn(name = "SAAS_PLAN_ID")
    private SaaSPlan saasPlan;
}