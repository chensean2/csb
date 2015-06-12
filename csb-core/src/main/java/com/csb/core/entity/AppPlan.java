package com.csb.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.csb.core.common.entity.BaseEntity;


/**
 * The persistent class for the tbl_ss_app_product database table.
 * 
 */
@Entity
@Table(name="tbl_csb_app_product")
public class AppPlan extends BaseEntity<Long>  {
	
	@ManyToMany(mappedBy="appProductList")
	private List<AppPackage> appPackageList;
	
	@ManyToOne
	@JoinColumn(name="APP_PRODUCT_ID")
	private AppProduct appProduct;
	
	@Column(name="NAME")
	private String name;


}