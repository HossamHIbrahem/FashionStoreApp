package com.sotre.entities;

public class Product_Country {

    private int productId;
    private int productIdFK;
    private String countryName;
    private int productModel;
    private int productCountryQty;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductIdFK() {
        return productIdFK;
    }

    public void setProductIdFK(int productIdFK) {
        this.productIdFK = productIdFK;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getProductModel() {
        return productModel;
    }

    public void setProductModel(int productModel) {
        this.productModel = productModel;
    }

    public int getProductCountryQty() {
        return productCountryQty;
    }

    public void setProductCountryQty(int productCountryQty) {
        this.productCountryQty = productCountryQty;
    }

}
