package com.csb.core.platform.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "csb_platform_saas_provision_response")
public class SaasProvisionResponse extends BaseEntity<Long> {

    private static final long serialVersionUID = -9108760868920972643L;

    @Column(name = "success_code")
    private String successCode;

    @Column(name = "message")
    private String message;

    @Column(name = "raw")
    private String raw;

    @ManyToOne
    @JoinColumn(name = "saas_plan_id")
    private SaasPlan saasPlan;

    public String getSuccessCode() {
        return successCode;
    }

    public void setSuccessCode(String successCode) {
        this.successCode = successCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }


    public SaasPlan getSaasPlan() {
        return saasPlan;
    }

    public void setSaasPlan(SaasPlan saasPlan) {
        this.saasPlan = saasPlan;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}