package com.saveo.Assignment.models;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity

@Table(name = "product_list")
public class Product {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "c_name")
    private String cName;

    @Column(name = "c_batch_no")
    private String cBatchNo;

    @Column(name = "d_expiry_date")
    private String dExpiryDate;

    @Column(name = "n_balance_qty")
    private Integer nBalanceQty;

    @Column(name = "c_packaging")
    private String cPackaging;

    @Column(name = "c_unique_code")
    private Integer cUniqueCode;

    @Column(name = "c_schemes")
    private String cSchemes;

    @Column(name = "n_mrp")
    private Double nMrp;

    @Column(name = "c_manufacturer")
    private String cManufacturer;

    @Column(name = "hsn_code")
    private Integer hsnCode;

    public Product() {
    }

    public Product(String cName, String cBatchNo, String dExpiryDate, Integer nBalanceQty, String cPackaging, Integer cUniqueCode, String cSchemes, Double nMrp, String cManufacturer, Integer hsnCode, Long id) {
        this.cName = cName;
        this.cBatchNo = cBatchNo;
        this.dExpiryDate = dExpiryDate;
        this.nBalanceQty = nBalanceQty;
        this.cPackaging = cPackaging;
        this.cUniqueCode = cUniqueCode;
        this.cSchemes = cSchemes;
        this.nMrp = nMrp;
        this.cManufacturer = cManufacturer;
        this.hsnCode = hsnCode;
        this.id = id;
    }

    public Integer getcUniqueCode() {
        return cUniqueCode;
    }

    public void setcUniqueCode(Integer cUniqueCode) {
        this.cUniqueCode = cUniqueCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcBatchNo() {
        return cBatchNo;
    }

    public void setcBatchNo(String cBatchNo) {
        this.cBatchNo = cBatchNo;
    }

    public String getdExpiryDate() {
        return dExpiryDate;
    }

    public void setdExpiryDate(String dExpiryDate) {
        this.dExpiryDate = dExpiryDate;
    }

    public Integer getnBalanceQty() {
        return nBalanceQty;
    }

    public void setnBalanceQty(Integer nBalanceQty) {
        this.nBalanceQty = nBalanceQty;
    }

    public String getcPackaging() {
        return cPackaging;
    }

    public void setcPackaging(String cPackaging) {
        this.cPackaging = cPackaging;
    }



    public String getcSchemes() {
        return cSchemes;
    }

    public void setcSchemes(String cSchemes) {
        this.cSchemes = cSchemes;
    }

    public Double getnMrp() {
        return nMrp;
    }

    public void setnMrp(Double nMrp) {
        this.nMrp = nMrp;
    }

    public String getcManufacturer() {
        return cManufacturer;
    }

    public void setcManufacturer(String cManufacturer) {
        this.cManufacturer = cManufacturer;
    }

    public Integer getHsnCode() {
        return hsnCode;
    }

    public void setHsnCode(Integer hsnCode) {
        this.hsnCode = hsnCode;
    }




}
