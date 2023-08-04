package com.example.servlet_shopbb.controller.admin;

import com.example.servlet_shopbb.entity.Loai;
import com.example.servlet_shopbb.service.LoaiService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdCategoryServlet", value = {
        "/admin/category",
        "/admin/category/add",
        "/admin/category/update",
        "/admin/category/delete"
})
public class AdCategoryServlet extends HttpServlet {
    LoaiService loaiService;

    public AdCategoryServlet() {
        loaiService = new LoaiService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("category/delete")){
            delete(request, response);
        }else {
            index(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("category/add")){
            add(request, response);
        }else if(uri.contains("category/update")){
            update(request, response);
        }else {
            index(request, response);
        }
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/admin/manage_category.jsp");
        request.setAttribute("lstCategory", loaiService.getAll());
        request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("ten");
        String trangThai = request.getParameter("trangThai");
        Loai loai = new Loai();
        loai.setTen(ten);

        loai.setTrangThai(Integer.valueOf(trangThai));
        loaiService.save(loai);
        response.sendRedirect("/admin/category");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String ten = request.getParameter("ten");
        String trangThai = request.getParameter("trangThai");

        Loai loai = loaiService.getById(Integer.valueOf(id));
        loai.setTen(ten);
        loai.setTrangThai(Integer.valueOf(trangThai));
        loaiService.update(loai);
        response.sendRedirect("/admin/category");

    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        Loai loai = loaiService.getById(Integer.valueOf(id));

        loaiService.delete(loai);
        response.sendRedirect("/admin/category");
    }

}
