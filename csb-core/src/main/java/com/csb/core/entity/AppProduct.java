package com.csb.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "csb_app_product")
public class AppProduct extends BaseEntity<Long> {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "app_provider_id")
    private AppProvider appProvider;

    @OneToMany(mappedBy = "appProduct")
    private List<AppPlan> appPlanList;

    @OneToMany(mappedBy = "appProduct")
    private List<AppProductParameterDefinition> appProductParameterDefinitionList;
    
    @OneToOne
	@JoinColumn(name="app_product_integration_definition_id")
    private AppProductIntegrationDefinition appProductIntegrationDefinition;
    
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	//for default, a AppProduct must mapped to a AppPackage which is belong to SINGLE type
	@OneToOne
	@JoinColumn(name="app_package_id")
	private AppPackage appPackage;
	
	@Column(name="list_logo")
	private String listLogo;
	
	@Column(name="profile_logo")
	private String profileLogo;
}