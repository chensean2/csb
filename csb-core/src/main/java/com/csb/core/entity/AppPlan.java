package com.csb.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.csb.core.common.entity.BaseEntity;

@Entity
@Table(name = "tbl_csb_app_plan")
public class AppPlan extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "APP_PACKAGE_ID")
    private AppPackage appPackage;

    @ManyToOne
    @JoinColumn(name = "APP_PRODUCT_ID")
    private AppProduct appProduct;
    
    @OneToMany(mappedBy="appPlan")
    private List<Subscription> subscriptionList;

    @Column(name = "NAME")
    private String name;
    
    

}