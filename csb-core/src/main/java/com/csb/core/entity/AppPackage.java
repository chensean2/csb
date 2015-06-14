package com.csb.core.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.csb.core.common.entity.BaseEntity;

@Entity
@Table(name = "tbl_csb_app_package")
public class AppPackage extends BaseEntity<Long> {

	@OneToMany(mappedBy="appPackage")
	private List<AppPlan> appPlanList;

	@ManyToMany(mappedBy="appPackageList")
	private List<AppCategory> appCategoryList;
	

}