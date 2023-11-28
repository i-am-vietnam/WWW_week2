package com.example.week2_huynhngophuchau_19432051.dao;

import com.example.week2_huynhngophuchau_19432051.entity.Product;
import com.example.week2_huynhngophuchau_19432051.entity.ProductImage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        try (Connection connection = DataBaseConection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getInt("product_id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setUnit(resultSet.getString("unit"));
                product.setManufacturerName(resultSet.getString("manufacturer_name"));
                product.setStatus(resultSet.getInt("status"));

                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product getProductById(int productId) {
        Product product = null;

        try (Connection connection = DataBaseConection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product WHERE product_id = ?")) {

            preparedStatement.setInt(1, productId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    product = new Product();
                    product.setProductId(resultSet.getInt("product_id"));
                    product.setName(resultSet.getString("name"));
                    product.setDescription(resultSet.getString("description"));
                    product.setUnit(resultSet.getString("unit"));
                    product.setManufacturerName(resultSet.getString("manufacturer_name"));
                    product.setStatus(resultSet.getInt("status"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public List<ProductImage> getProductImages(int productId) {
        List<ProductImage> productImages = new ArrayList<>();

        try (Connection connection = DataBaseConection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product_image WHERE product_id = ?")) {

            preparedStatement.setInt(1, productId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    ProductImage productImage = new ProductImage();
                    productImage.setProductId(resultSet.getInt("product_id"));
                    productImage.setImageId(resultSet.getInt("image_id"));
                    productImage.setPath(resultSet.getString("path"));
                    productImage.setAlternative(resultSet.getString("alternative"));

                    productImages.add(productImage);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productImages;
    }
}
