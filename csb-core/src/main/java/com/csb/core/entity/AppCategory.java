package com.csb.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "csb_app_category")
public class AppCategory extends BaseEntity<Long> {

    @Column(name = "name")
    private String name;  
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "csb_app_category_package",
    joinColumns = { @JoinColumn(name = "category_id") }, 
    inverseJoinColumns = { @JoinColumn(name = "package_id") })
    @Fetch(FetchMode.JOIN)
    private List<AppPackage> appPackageList;


}