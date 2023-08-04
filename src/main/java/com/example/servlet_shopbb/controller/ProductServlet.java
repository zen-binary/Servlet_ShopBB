package com.example.servlet_shopbb.controller;

import com.example.servlet_shopbb.service.ChiTietSanPhamService;
import com.example.servlet_shopbb.service.ProductService;
import com.example.servlet_shopbb.service.SanPhamService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ProductServlet", value = {
        "/product",
        "/products",
})
public class ProductServlet extends HttpServlet {
   ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view","/view/products.jsp");
        request.setAttribute("lstProduct",productService.getProductsAll());
        request.getRequestDispatcher("/view/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
