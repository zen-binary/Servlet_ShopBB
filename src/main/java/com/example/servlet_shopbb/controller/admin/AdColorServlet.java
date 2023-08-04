package com.example.servlet_shopbb.controller.admin;

import com.example.servlet_shopbb.entity.MauSac;
import com.example.servlet_shopbb.service.MauSacService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdcolorServlet", value = {
        "/admin/color",
        "/admin/color/add",
        "/admin/color/update",
        "/admin/color/delete"
})
public class AdColorServlet extends HttpServlet {
    MauSacService msService;
    public AdColorServlet() {
        msService = new MauSacService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("color/delete")){
            delete(request, response);
        }else {
            index(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("color/add")){
            add(request, response);
        }else if(uri.contains("color/update")){
            update(request, response);
        }else {
            index(request, response);
        }
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/admin/manage_color.jsp");
        request.setAttribute("lstMs",msService.getAll());
        request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("ten");
        String trangThai = request.getParameter("trangThai");
        MauSac ms = new MauSac();
        ms.setTen(ten);
        ms.setTrangThai(Integer.valueOf(trangThai));
        msService.save(ms);
        response.sendRedirect("/admin/color");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String ten = request.getParameter("ten");
        String trangThai = request.getParameter("trangThai");

        MauSac ms = msService.getById(Integer.valueOf(id));
        ms.setTen(ten);
        ms.setTrangThai(Integer.valueOf(trangThai));
        msService.update(ms);
        response.sendRedirect("/admin/color");

    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        MauSac ms = msService.getById(Integer.valueOf(id));

        msService.delete(ms);
        response.sendRedirect("/admin/color");
    }

}
