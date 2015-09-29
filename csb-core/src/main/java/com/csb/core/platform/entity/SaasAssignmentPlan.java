package com.csb.core.platform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "csb_platform_saas_assignment_plan")
public class SaasAssignmentPlan extends BaseEntity<Long> {

    // ASSIGN,UNASSIGN
    @Column(name = "action")
    private String action;

    @Column(name = "creator_openid")
    private String creatorOpenId;

    @Column(name = "creator_email")
    private String creatorEmail;

    @Column(name = "creator_firstname")
    private String creatorFirstName;

    @Column(name = "creator_lastname")
    private String creatorLastName;

    @Column(name = "external_accout_id")
    private String externalAccoutId;

    // for provider return a unique id for this assignment if there is
    @Column(name = "external_assignment_id")
    private String externalAssignmentId;

    @Column(name = "user_openid")
    private String userOpenId;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_firstname")
    private String userFirstName;

    @Column(name = "user_lastname")
    private String userLastName;

    // status of the provision, INPROGRESS,SUCCESS,FAILED
    @Column(name = "status")
    private String status;

}