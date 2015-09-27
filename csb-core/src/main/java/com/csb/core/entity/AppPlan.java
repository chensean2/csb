package com.csb.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "csb_app_plan")
public class AppPlan extends BaseEntity<Long> {

	//only for MULTIPLE type, Package is combination for appPlan,  so here need a foreign key to connect 
    @ManyToOne
    @JoinColumn(name = "app_package_id")
    private AppPackage appPackage;

    @ManyToOne
    @JoinColumn(name = "app_product_id")
    private AppProduct appProduct;
    
    @OneToMany(mappedBy="appPlan")
    private List<AppPlanCost> appPlanCostList;
    
    @OneToMany(mappedBy="appPlan")
    private List<Subscription> subscriptionList;

    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
  //ONE_TIME, MONTHLY, QUATERLY, SIX_MONTHS, YEARLY, TWO_YEARS, DAILY
    @Column(name = "frequency")
    private String frequency;

    @Column(name = "trial_days")
    private Integer trialDays;
}