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
@Table(name = "csb_app_plan_cost")
public class AppPlanCost extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "app_plan_id")
    private AppPlan appPlan;
    
    //ONE_TIME_SETUP,FLAT_RATE,USER,GIGABYTE
    @Column(name = "unit")
    private String unit;
    
    @Column(name = "min_units")
    private Integer minUnits;
    
    @Column(name = "max_units")
    private Integer maxUnits;

    @Column(name = "price", scale = 30, precision = 2)
    private BigDecimal price;

}