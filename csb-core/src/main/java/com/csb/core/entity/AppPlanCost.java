package com.csb.core.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "tbl_csb_app_plan_cost")
public class AppPlanCost extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "APP_PLAN_ID")
    private AppPlan appPlan;
    
    //ONE_TIME_SETUP,FLAT_RATE,USER,GIGABYTE
    @Column(name = "UNIT")
    private String unit;
    
    @Column(name = "MIN_UNITS")
    private Integer minUnits;
    
    @Column(name = "MAX_UNITS")
    private Integer maxUnits;

    @Column(name = "PRICE", scale = 30, precision = 2)
    private BigDecimal price;

}