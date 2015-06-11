package com.saas.provision.to;

import com.saas.common.to.SCBaseTO;

public class IsvServiceParaDefTO extends SCBaseTO {

    /**
     * 
     */
    private static final long serialVersionUID = 7456760452997873888L;

    private String isvServiceParaDefId;
    private String isvServiceDefId;
    private String isvServiceParaName;
    private Integer isvServiceParaSequence;

    public String getIsvServiceParaDefId() {
        return isvServiceParaDefId;
    }

    public void setIsvServiceParaDefId(String isvServiceParaDefId) {
        this.isvServiceParaDefId = isvServiceParaDefId;
    }

    public String getIsvServiceDefId() {
        return isvServiceDefId;
    }

    public void setIsvServiceDefId(String isvServiceDefId) {
        this.isvServiceDefId = isvServiceDefId;
    }

    public String getIsvServiceParaName() {
        return isvServiceParaName;
    }

    public void setIsvServiceParaName(String isvServiceParaName) {
        this.isvServiceParaName = isvServiceParaName;
    }

    public Integer getIsvServiceParaSequence() {
        return isvServiceParaSequence;
    }

    public void setIsvServiceParaSequence(Integer isvServiceParaSequence) {
        this.isvServiceParaSequence = isvServiceParaSequence;
    }

}
