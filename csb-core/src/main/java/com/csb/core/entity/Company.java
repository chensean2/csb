package com.csb.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "csb_company")
public class Company extends BaseEntity<Long> {

    @OneToMany(mappedBy = "company")
    private List<Subscription> subscription;

    @OneToMany(mappedBy = "company")
    private List<Order> orderList;
    
    @Column(name = "name")
    private String name;


}