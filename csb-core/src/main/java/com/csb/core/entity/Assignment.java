package com.csb.core.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "csb_subscription")
public class Assignment extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name="user_id")
    private  User user;

    @ManyToOne
    @JoinColumn(name="subscription_id")
    private Subscription subscription;

}