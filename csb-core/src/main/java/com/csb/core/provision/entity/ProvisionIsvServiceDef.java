package com.csb.core.provision.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.csb.core.common.entity.BaseEntity;


/**
 * The persistent class for the tbl_ss_provision_isv_service_def database table.
 * 
 */
@Entity
@Table(name="tbl_ss_provision_isv_service_def")
public class ProvisionIsvServiceDef extends BaseEntity<Long> {
	private static final long serialVersionUID = 1L;

	@Column(name="ISV_SERVICE_DEF_ID")
	private String isvServiceDefId;

	@ManyToOne
	@JoinColumn(name="ISV_ADAPTOR_ID",referencedColumnName="ISV_ADAPTOR_ID")
	private ProvisionIsvAdaptor provisionIsvAdaptor;

	@OneToMany(mappedBy="provisionIsvServiceDef")
	private List<ProvisionIsvServiceParaDef> provisionIsvServiceParaDefList;
	
	@Column(name="ISV_ROLLBACK_ADAPTOR_ID")
	private String isvRollbackAdaptorId;

	@Column(name="SERVICE_DEF_CATEGORY")
	private String serviceDefCategory;

	@Column(name="SERVICE_DEF_NAME")
	private String serviceDefName;

	@Column(name="SERVICE_DEF_OPERATION")
	private String serviceDefOperation;

	@Column(name="SERVICE_DEF_VERSION")
	private String serviceDefVersion;


	public ProvisionIsvServiceDef() {
	}


	public String getIsvServiceDefId() {
		return isvServiceDefId;
	}


	public void setIsvServiceDefId(String isvServiceDefId) {
		this.isvServiceDefId = isvServiceDefId;
	}



	public ProvisionIsvAdaptor getProvisionIsvAdaptor() {
		return provisionIsvAdaptor;
	}


	public void setProvisionIsvAdaptor(ProvisionIsvAdaptor provisionIsvAdaptor) {
		this.provisionIsvAdaptor = provisionIsvAdaptor;
	}


	public String getIsvRollbackAdaptorId() {
		return isvRollbackAdaptorId;
	}


	public void setIsvRollbackAdaptorId(String isvRollbackAdaptorId) {
		this.isvRollbackAdaptorId = isvRollbackAdaptorId;
	}


	public String getServiceDefCategory() {
		return serviceDefCategory;
	}


	public void setServiceDefCategory(String serviceDefCategory) {
		this.serviceDefCategory = serviceDefCategory;
	}


	public String getServiceDefName() {
		return serviceDefName;
	}


	public void setServiceDefName(String serviceDefName) {
		this.serviceDefName = serviceDefName;
	}


	public String getServiceDefOperation() {
		return serviceDefOperation;
	}


	public void setServiceDefOperation(String serviceDefOperation) {
		this.serviceDefOperation = serviceDefOperation;
	}


	public String getServiceDefVersion() {
		return serviceDefVersion;
	}


	public void setServiceDefVersion(String serviceDefVersion) {
		this.serviceDefVersion = serviceDefVersion;
	}


	public List<ProvisionIsvServiceParaDef> getProvisionIsvServiceParaDefList() {
		return provisionIsvServiceParaDefList;
	}


	public void setProvisionIsvServiceParaDefList(
			List<ProvisionIsvServiceParaDef> provisionIsvServiceParaDefList) {
		this.provisionIsvServiceParaDefList = provisionIsvServiceParaDefList;
	}


}