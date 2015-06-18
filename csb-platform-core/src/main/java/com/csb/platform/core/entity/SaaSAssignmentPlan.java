package com.csb.platform.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_csb_platform_saas_assignment_plan")
public class SaaSAssignmentPlan extends BaseEntity<Long> {

    // ASSIGN,UNASSIGN
	@Column(name = "ACTION")
	private String action;

	@Column(name = "CREATOR_OPENID")
	private String creatorOpenId;

	@Column(name = "CREATOR_EMAIL")
	private String creatorEmail;

	@Column(name = "CREATOR_FIRSTNAME")
	private String creatorFirstName;
	
	@Column(name = "CREATOR_LASTNAME")
	private String creatorLastName;
	
	@Column(name = "EXTERNAL_ACCOUT_ID")
	private String externalAccoutId;
	
	//for provider return a unique id for this assignment if there is
	@Column(name = "EXTERNAL_ASSIGNMENT_ID")
        private String externalAssignmentId;
	
	@Column(name = "USER_OPENID")
        private String userOpenId;

        @Column(name = "USER_EMAIL")
        private String userEmail;

        @Column(name = "USER_FIRSTNAME")
        private String userFirstName;
        
        @Column(name = "USER_LASTNAME")
        private String userLastName;
        
	//status of the provision, INPROGRESS,SUCCESS,FAILED
	@Column(name = "STATUS")
	private String status;
	
}