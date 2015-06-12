package com.csb.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.csb.core.common.entity.BaseEntity;

@Entity
@Table(name="tbl_csb_app_provider")
public class AppProvider extends BaseEntity<Long>  {
	
	@OneToMany(mappedBy="appProvider")
	private List<AppProduct> appProductList;
	
	@Column(name="NAME")
	private String name;


}