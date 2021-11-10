package com.saveo.Assignment.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseMessage {

    private String responseMessage;
    private List<Product> responseProductList;

    public ResponseMessage(String responseMessage, Product responseProduct) {
        this.responseMessage = responseMessage;
        this.responseProduct = responseProduct;
    }

    public Product getResponseProduct() {
        return responseProduct;
    }

    public void setResponseProduct(Product responseProduct) {
        this.responseProduct = responseProduct;
    }

    private Product responseProduct;
    public ResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public ResponseMessage(String responseMessage, List<Product> responseProductList) {
        this.responseMessage = responseMessage;
        this.responseProductList = responseProductList;
    }

    public List<Product> getResponseProductList() {
        return responseProductList;
    }

    public void setResponseProductList(List<Product> responseProductList) {
        this.responseProductList = responseProductList;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
