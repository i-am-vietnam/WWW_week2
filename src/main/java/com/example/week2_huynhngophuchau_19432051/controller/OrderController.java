package com.example.week2_huynhngophuchau_19432051.controller;

import com.example.week2_huynhngophuchau_19432051.dao.OrderDAO;
import com.example.week2_huynhngophuchau_19432051.entity.Order;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/OrderServlet")
public class OrderController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OrderDAO orderDAO;
    public void init() {
        orderDAO = new OrderDAO();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "list":
                listOrders(request, response);
                break;
            case "showForm":
                showOrderForm(request, response);
                break;
            case "add":
                addOrder(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateOrder(request, response);
                break;
            case "delete":
                deleteOrder(request, response);
                break;
            default:
                listOrders(request, response);
        }
    }
    private void listOrders(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Order> orders = orderDAO.getAllOrders();
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("order-list.jsp").forward(request, response);
    }
    private void showOrderForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("order-form.jsp").forward(request, response);
    }
    private void addOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String orderDateStr = request.getParameter("orderDate");
        int empId = Integer.parseInt(request.getParameter("empId"));

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date orderDate = dateFormat.parse(orderDateStr);
            Order order = new Order();
            order.setOrderDate(orderDate);
            order.setEmpId(empId);
            orderDAO.addOrder(order);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        listOrders(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        Order order = orderDAO.getOrderById(orderId);

        request.setAttribute("order", order);
        request.getRequestDispatcher("order-edit-form.jsp").forward(request, response);
    }
    private void updateOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));

        String orderDateStr = request.getParameter("orderDate");
        int empId = Integer.parseInt(request.getParameter("empId"));

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date orderDate = dateFormat.parse(orderDateStr);

            Order updatedOrder = new Order();
            updatedOrder.setOrderId(orderId);
            updatedOrder.setOrderDate(orderDate);
            updatedOrder.setEmpId(empId);

            orderDAO.updateOrder(updatedOrder);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        listOrders(request, response);
    }
    private void deleteOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        orderDAO.deleteOrder(orderId);
        listOrders(request, response);
    }

    private void listOrdersByDate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy theo ngày
        String dateStr = request.getParameter("date");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(dateStr);
            List<Order> orders = orderDAO.getOrdersByDateRange(date);
            request.setAttribute("orders", orders);
            request.getRequestDispatcher("order-list.jsp").forward(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
            // Xử lý lỗi
        }
    }

    private void listOrdersByDateRange(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // lấy theo khoảng thời gian
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = dateFormat.parse(startDateStr);
            Date endDate = dateFormat.parse(endDateStr);
            List<Order> orders = orderDAO.getOrdersByDateRange(startDate, endDate);
            request.setAttribute("orders", orders);
            request.getRequestDispatcher("order-list.jsp").forward(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
            // Xử lý lỗi chuyển đổi ngày
        }
    }

}
