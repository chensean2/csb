package com.csb.platform.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_csb_platform_saas_plan")
public class SaaSPlan extends BaseEntity<Long> {

    // for the client/ provider query subscription/assignment information
    @Column(name = "EVENT_ID", unique=true)
    private String eventId;
    
    @Column(name = "APP_PROVIDER_ID")
    private String appProviderId;
    
    //ASSIGNMENT,SUBSCRIPTION,NOTIFICATION,VALIDATION
    @Column(name = "TYPE")
    private String type;
    
    @Column(name = "TRACE_ID")
    private String traceId;
    
  //status of the provision, INPROGRESS,SUCCESS,FAILED
    @Column(name = "STATUS")
    private String status;
    
    @Column(name = "MESSAGE")
    private String message;

    @OneToOne
    @JoinColumn(name="SAAS_SUBSCRIPTION_PLAN_ID")
    private SaaSSubscriptionPlan saaSSubscriptionPlan;

    @OneToOne
    @JoinColumn(name="SAAS_ASSIGNMENT_PLAN")
    private SaaSAssignmentPlan saaSAssignmentPlan;
    
    @OneToMany(mappedBy = "saasPlan")
    private List<SaaSValidationPlan> saaSValidationPlanList;

}