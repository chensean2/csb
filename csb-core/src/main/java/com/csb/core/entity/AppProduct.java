package com.csb.core.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.csb.core.common.entity.BaseEntity;

@Entity
@Table(name = "tbl_csb_app_product")
public class AppProduct extends BaseEntity<Long> {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "APP_PROVIDER_ID")
    private AppProvider appProvider;

    @OneToMany(mappedBy = "appProduct")
    private List<AppPlan> appPlanList;

    @OneToMany(mappedBy = "appProduct")
    private List<AppProductParameterDefinition> appProductParameterDefinitionList;
}