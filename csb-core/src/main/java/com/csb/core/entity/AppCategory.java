package com.csb.core.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.csb.core.common.BaseEntity;
import com.csb.core.common.BaseEntity1;

@Entity
@Table(name = "csb_app_category")
public class AppCategory extends BaseEntity1{
    
    

    @Column(name = "name")
    private String name;  
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



//	@ManyToMany(fetch=FetchType.LAZY)
//    @JoinTable(name = "csb_app_category_package",
//    joinColumns = { @JoinColumn(name = "category_id") }, 
//    inverseJoinColumns = { @JoinColumn(name = "package_id") })
//    @Fetch(FetchMode.JOIN)
//    private List<AppPackage> appPackageList;


}