package com.csb.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;


@Entity
@Table(name="csb_app_product_parameter_definition")
public class AppProductParameterDefinition extends BaseEntity<Long>  {

	@ManyToOne
	@JoinColumn(name="app_product_id")
	private AppProduct appProduct;
	
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;
	
	@Column(name="max_length")
	private Integer maxLength;
	
	@Column(name="sequence")
	private Integer sequence;

}