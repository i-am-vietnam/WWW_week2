package com.example.week2_huynhngophuchau_19432051.entity;

public class ProductImage {
    private int productId;
    private int imageId;
    private String path;
    private String alternative;

    public ProductImage(int productId, int imageId, String path, String alternative) {
        this.productId = productId;
        this.imageId = imageId;
        this.path = path;
        this.alternative = alternative;
    }

    public ProductImage() {
    }


}
