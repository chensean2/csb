package com.csb.core.platform.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "csb_platform_saas_plan")
public class SaasPlan extends BaseEntity<Long> {

    
    //ASSIGNMENT,SUBSCRIPTION,NOTIFICATION,VALIDATION
    @Column(name = "type")
    private String type;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="saas_subscription_plan_id")
    private SaasSubscriptionPlan saasSubscriptionPlan;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="saas_assignment_plan")
    private SaasAssignmentPlan saasAssignmentPlan;
    
    @OneToMany(mappedBy = "saasPlan",cascade=CascadeType.ALL)
    private List<SaasValidationPlan> saasValidationPlanList;
    
    @OneToMany(mappedBy = "saasPlan",cascade=CascadeType.ALL)
    //@OrderBy("ID DESC")
    private List<SaasProvisionResponse> saasProvisionResponseList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SaasSubscriptionPlan getSaaSSubscriptionPlan() {
        return saasSubscriptionPlan;
    }

    public void setSaaSSubscriptionPlan(SaasSubscriptionPlan saasSubscriptionPlan) {
        this.saasSubscriptionPlan = saasSubscriptionPlan;
    }

    public SaasAssignmentPlan getSaaSAssignmentPlan() {
        return saasAssignmentPlan;
    }

    public void setSaaSAssignmentPlan(SaasAssignmentPlan saasAssignmentPlan) {
        this.saasAssignmentPlan = saasAssignmentPlan;
    }

    public List<SaasValidationPlan> getSaasValidationPlanList() {
        return saasValidationPlanList;
    }

    public void setSaaSValidationPlanList(List<SaasValidationPlan> saaSValidationPlanList) {
        this.saasValidationPlanList = saaSValidationPlanList;
    }

	public List<SaasProvisionResponse> getSaasProvisionResponseList() {
		return saasProvisionResponseList;
	}

	public void setSaaSProvisionResponseList(List<SaasProvisionResponse> saasProvisionResponseList) {
		this.saasProvisionResponseList = saasProvisionResponseList;
	}
    
    

    
}