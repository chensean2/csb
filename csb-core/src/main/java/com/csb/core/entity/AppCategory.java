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

import com.csb.core.common.entity.BaseEntity;

@Entity
@Table(name = "tbl_csb_app_category")
public class AppCategory extends BaseEntity<Long> {

    @Column(name = "NAME")
    private String name;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "tbl_ss_app_category_package",
    joinColumns = { @JoinColumn(name = "CATEGORY_ID") }, 
    inverseJoinColumns = { @JoinColumn(name = "PACKAGE_ID") })
    @Fetch(FetchMode.JOIN)
    private List<AppPackage> appPackageList;


}