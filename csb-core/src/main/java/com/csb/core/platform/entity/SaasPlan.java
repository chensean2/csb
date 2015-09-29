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
public class SaaSPlan extends BaseEntity<Long> {

    
    //ASSIGNMENT,SUBSCRIPTION,NOTIFICATION,VALIDATION
    @Column(name = "type")
    private String type;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="saas_subscription_plan_id")
    private SaaSSubscriptionPlan saaSSubscriptionPlan;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="saas_assignment_plan")
    private SaaSAssignmentPlan saaSAssignmentPlan;
    
    @OneToMany(mappedBy = "saasPlan",cascade=CascadeType.ALL)
    private List<SaaSValidationPlan> saaSValidationPlanList;
    
    @OneToMany(mappedBy = "saasPlan",cascade=CascadeType.ALL)
    //@OrderBy("ID DESC")
    private List<SaaSProvisionResponse> saaSProvisionResponseList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SaaSSubscriptionPlan getSaaSSubscriptionPlan() {
        return saaSSubscriptionPlan;
    }

    public void setSaaSSubscriptionPlan(SaaSSubscriptionPlan saaSSubscriptionPlan) {
        this.saaSSubscriptionPlan = saaSSubscriptionPlan;
    }

    public SaaSAssignmentPlan getSaaSAssignmentPlan() {
        return saaSAssignmentPlan;
    }

    public void setSaaSAssignmentPlan(SaaSAssignmentPlan saaSAssignmentPlan) {
        this.saaSAssignmentPlan = saaSAssignmentPlan;
    }

    public List<SaaSValidationPlan> getSaaSValidationPlanList() {
        return saaSValidationPlanList;
    }

    public void setSaaSValidationPlanList(List<SaaSValidationPlan> saaSValidationPlanList) {
        this.saaSValidationPlanList = saaSValidationPlanList;
    }

	public List<SaaSProvisionResponse> getSaaSProvisionResponseList() {
		return saaSProvisionResponseList;
	}

	public void setSaaSProvisionResponseList(List<SaaSProvisionResponse> saaSProvisionResponseList) {
		this.saaSProvisionResponseList = saaSProvisionResponseList;
	}
    
    

    
}