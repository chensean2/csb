package com.csb.parser.component.model;

public class SaaSOrderItem {

	 private String name;
	 
    private Integer quantity;

    private String unit;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
