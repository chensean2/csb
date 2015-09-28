package com.csb.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "tbl_csb_app_package")
public class AppPackage extends BaseEntity<Long> {

//	@ManyToMany(mappedBy = "appPackageList")
//	private List<AppCategory> appCategoryList;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	// SINGLE: it contains AppPlans which belong to one single product
	// MULTIPLE: TODO: it contains AppPlans which belong to multiple product
	@Column(name = "TYPE")
	private String type;

	//only for MULTIPLE type, Package is combination for appPlan
	@OneToMany(mappedBy = "appPackage")
	private List<AppPlan> appPlanList;

	// only for SINGLE type
	@OneToOne(mappedBy = "appPackage")
	private AppProduct appProduct;

}