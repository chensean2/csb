package com.csb.core.common;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public abstract class AbstractEntity1 implements Serializable{

    public abstract Long getId();

   
    public abstract void setId(final Long id);

    
    public boolean isNew() {

        return null == getId();
    }

   
    @Override
    public boolean equals(Object obj) {

        if (null == obj) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (!getClass().equals(obj.getClass())) {
            return false;
        }

        AbstractEntity1 that = (AbstractEntity1) obj;

        return null == this.getId() ? false : this.getId().equals(that.getId());
    }

   
    @Override
    public int hashCode() {

        int hashCode = 17;

        hashCode += null == getId() ? 0 : getId().hashCode() * 31;

        return hashCode;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
