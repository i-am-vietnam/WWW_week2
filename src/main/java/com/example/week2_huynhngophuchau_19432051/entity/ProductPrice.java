package com.example.week2_huynhngophuchau_19432051.entity;

import java.util.Date;

public class ProductPrice {
    private int productId;
    private Date priceDateTime;
    private double price;
    private String note;

    public ProductPrice(int productId, Date priceDateTime, double price, String note) {
        this.productId = productId;
        this.priceDateTime = priceDateTime;
        this.price = price;
        this.note = note;
    }

    public ProductPrice() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Date getPriceDateTime() {
        return priceDateTime;
    }

    public void setPriceDateTime(Date priceDateTime) {
        this.priceDateTime = priceDateTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
