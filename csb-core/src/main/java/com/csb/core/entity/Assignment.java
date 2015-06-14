package com.csb.core.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.csb.core.common.entity.BaseEntity;

@Entity
@Table(name = "tbl_csb_subscription")
public class Assignment extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private  User user;

    @ManyToOne
    @JoinColumn(name="SUBSCRIPTION_ID")
    private Subscription subscription;

}