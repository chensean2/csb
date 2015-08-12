package com.csb.openapi.event.model;

import java.util.List;

public class Subscription {

	private String term;

	private String action;

	private Creator creator;

	private Company company;

	private Order order;

	private List<CustomeAttribute> customeAttributes;

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Creator getCreator() {
		return creator;
	}

	public void setCreator(Creator creator) {
		this.creator = creator;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<CustomeAttribute> getCustomeAttributes() {
		return customeAttributes;
	}

	public void setCustomeAttributes(List<CustomeAttribute> customeAttributes) {
		this.customeAttributes = customeAttributes;
	}

}
