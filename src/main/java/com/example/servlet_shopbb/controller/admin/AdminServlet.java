package com.example.servlet_shopbb.controller.admin;

import com.example.servlet_shopbb.repositories.Impl.AdminRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminServlet", value = {
        "/admin",
        "/admin/home",
})
public class AdminServlet extends HttpServlet {
    AdminRepository adRepo = new AdminRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        index(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("countPros",adRepo.getCountProducts());
        request.setAttribute("countOder",adRepo.getCountOder());


        request.setAttribute("view", "/admin/home.jsp");
        request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
    }

}
