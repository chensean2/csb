package com.saas.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.csb.common.entity.BaseEntity;


/**
 * The persistent class for the tbl_ss_app_group database table.
 * 
 */
@Entity
@Table(name="tbl_ss_app_group")
public class AppGroup extends BaseEntity<Long> {

	@Column(name="ALLOW_DIFF_PACKAGE")
	private String allowDiffPackage;

	@Column(name="GROUP_DESC")
	private String groupDesc;

	@Column(name="GROUP_ID")
	private String groupId;

	@Column(name="GROUP_NAME")
	private String groupName;

	public AppGroup() {
	}

	public String getAllowDiffPackage() {
		return this.allowDiffPackage;
	}

	public void setAllowDiffPackage(String allowDiffPackage) {
		this.allowDiffPackage = allowDiffPackage;
	}

	public String getGroupDesc() {
		return this.groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}

	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


}