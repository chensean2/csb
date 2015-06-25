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
@Table(name = "tbl_csb_user")
public class User extends BaseEntity<Long> {

    
    @OneToMany(mappedBy="appPlan")
    private List<Subscription> subscriptionList;

    @Column(name = "NAME")
    private String name;
    
    

}