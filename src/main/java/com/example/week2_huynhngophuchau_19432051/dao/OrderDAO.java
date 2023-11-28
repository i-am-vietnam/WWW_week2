package com.example.week2_huynhngophuchau_19432051.dao;

import com.example.week2_huynhngophuchau_19432051.entity.Order;

import java.sql.*;

public class OrderDAO {
    public void addOrder(Order order) {
        try (Connection connection = DataBaseConection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO `order` (order_date, emp_id) VALUES (?, ?)",
                     Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setDate(1, new java.sql.Date(order.getOrderDate().getTime()));
            preparedStatement.setInt(2, order.getEmpId());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating order failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    order.setOrderId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating order failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Order getOrderById(int orderId) {
        Order order = null;

        try (Connection connection = DataBaseConection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM `order` WHERE order_id = ?")) {

            preparedStatement.setInt(1, orderId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    order = new Order();
                    order.setOrderId(resultSet.getInt("order_id"));
                    order.setOrderDate(resultSet.getDate("order_date"));
                    order.setEmpId(resultSet.getInt("emp_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }
    public void updateOrder(Order order) {
        try (Connection connection = DataBaseConection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE `order` SET order_date = ?, emp_id = ? WHERE order_id = ?")) {

            preparedStatement.setDate(1, new java.sql.Date(order.getOrderDate().getTime()));
            preparedStatement.setInt(2, order.getEmpId());
            preparedStatement.setInt(3, order.getOrderId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteOrder(int orderId) {
        try (Connection connection = DataBaseConection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM `order` WHERE order_id = ?")) {

            preparedStatement.setInt(1, orderId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
