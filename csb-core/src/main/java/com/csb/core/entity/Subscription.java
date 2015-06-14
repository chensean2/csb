package com.csb.core.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.csb.core.common.entity.BaseEntity;

@Entity
@Table(name = "tbl_csb_subscription")
public class Subscription extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name="COMPANY_ID")
    private Company company;

    @ManyToOne
    @JoinColumn(name="APP_PLAN_ID")
    private AppPlan appPlan;

    @OneToMany(mappedBy = "subscription")
    private List<Assignment> assignmentList;
}