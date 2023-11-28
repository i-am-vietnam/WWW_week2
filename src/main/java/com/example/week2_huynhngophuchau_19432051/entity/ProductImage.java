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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }
}
