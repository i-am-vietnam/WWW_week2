package com.example.week2_huynhngophuchau_19432051.controller;

import com.example.week2_huynhngophuchau_19432051.dao.ProductDAO;
import com.example.week2_huynhngophuchau_19432051.entity.Product;
import com.example.week2_huynhngophuchau_19432051.entity.ProductImage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/ProductServlet")
public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listProducts(request, response);
                break;
            case "showDetails":
                showProductDetails(request, response);
                break;
            default:
                listProducts(request, response);
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> products = productDAO.getAllProducts();
        request.setAttribute("products", products);
        request.getRequestDispatcher("product-list.jsp").forward(request, response);
    }

    private void showProductDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));

        Product product = productDAO.getProductById(productId);
        List<ProductImage> productImages = productDAO.getProductImages(productId);

        request.setAttribute("product", product);
        request.setAttribute("productImages", productImages);
        request.getRequestDispatcher("product-details.jsp").forward(request, response);
    }
}
