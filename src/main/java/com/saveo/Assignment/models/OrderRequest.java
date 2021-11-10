package com.saveo.Assignment.models;

import javax.persistence.Id;

public class OrderRequest {

    private Integer cUniqueId;
    private Integer quantity;
    private String cName;

    public Integer getcUniqueId() {
        return cUniqueId;
    }

    public void setcUniqueId(Integer cUniqueId) {
        this.cUniqueId = cUniqueId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }


}
