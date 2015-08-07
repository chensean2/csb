package com.csb.core.rest.to;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("iaas")
public class PocIaaSInfoTO implements Serializable {

	private static final long serialVersionUID = 3354244180827684121L;


	private String instanceName;

	// private String instanceCount;

	private String imageName;

	@JsonIgnore
	private String flavor;

	private Integer cpus;

	private String memory;

	private String storage;


	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
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
