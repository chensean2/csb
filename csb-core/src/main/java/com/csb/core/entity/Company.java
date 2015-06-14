package com.csb.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.csb.core.common.entity.BaseEntity;

@Entity
@Table(name = "tbl_csb_company")
public class Company extends BaseEntity<Long> {

    @OneToMany(mappedBy = "company")
    private List<Subscription> subscription;

    @OneToMany(mappedBy = "company")
    private List<Order> orderList;
    
    @Column(name = "NAME")
    private String name;


}