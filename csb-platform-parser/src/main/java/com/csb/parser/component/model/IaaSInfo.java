package com.csb.parser.component.model;

public class IaaSInfo {

	// OPENSTACK
	private String provider;

	// CREATE,UPDATE,CANCEL,START,STOP,..
	private String action;

	private String instanceName;
	private String instanceCount;
	private String imageName;
	private String flavor;
	private Integer cpus;
	private String memory;
	private String storage;

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public String getInstanceCount() {
		return instanceCount;
	}

	public void setInstanceCount(String instanceCount) {
		this.instanceCount = instanceCount;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public Integer getCpus() {
		return cpus;
	}

	public void setCpus(Integer cpus) {
		this.cpus = cpus;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

}
