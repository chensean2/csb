package com.csb.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.csb.core.common.entity.BaseEntity;

@Entity
@Table(name = "tbl_csb_app_product")
public class AppProduct extends BaseEntity<Long> {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "APP_PROVIDER_ID")
    private AppProvider appProvider;

    @OneToMany(mappedBy = "appProduct")
    private List<AppPlan> appPlanList;

    @OneToMany(mappedBy = "appProduct")
    private List<AppProductParameterDefinition> appProductParameterDefinitionList;
    
    @OneToOne
	@JoinColumn(name="App_Product_Integration_Definition")
    private AppProductIntegrationDefinition appProductIntegrationDefinition;
    
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	//for default, a AppProduct must mapped to a AppPackage which is belong to SINGLE type
	@OneToOne
	@JoinColumn(name="APP_PACKAGE_ID")
	private AppPackage appPackage;
	
	@Column(name="LIST_LOGO")
	private String listLogo;
	
	@Column(name="PROFILE_LOGO")
	private String profileLogo;
}