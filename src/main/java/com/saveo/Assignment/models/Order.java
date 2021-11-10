package com.saveo.Assignment.models;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table(name = "medicine_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Integer orderId;
    private Integer cUniqueId;
    private Integer quantity;
    private String cName;

    public Order() {
    }

    public Order(Integer orderId, Integer cUniqueId, Integer quantity, String cName) {
        this.orderId = orderId;
        this.cUniqueId = cUniqueId;
        this.quantity = quantity;
        this.cName = cName;
    }
    public Order(Integer cUniqueId, Integer quantity, String cName) {
        this.cUniqueId = cUniqueId;
        this.quantity = quantity;
        this.cName = cName;
    }





    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

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
