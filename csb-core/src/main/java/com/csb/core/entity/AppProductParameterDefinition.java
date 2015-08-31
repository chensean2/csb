package com.csb.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;


@Entity
@Table(name="tbl_csb_app_product_parameter_definition")
public class AppProductParameterDefinition extends BaseEntity<Long>  {

	@ManyToOne
	@JoinColumn(name="APP_PRODUCT_ID")
	private AppProduct appProduct;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="TYPE")
	private String type;
	
	@Column(name="MAX_LENGTH")
	private Integer maxLength;
	
	@Column(name="SEQUENCE")
	private Integer sequence;

}