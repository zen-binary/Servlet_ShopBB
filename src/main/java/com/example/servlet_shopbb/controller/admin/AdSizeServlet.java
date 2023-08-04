package com.example.servlet_shopbb.controller.admin;

import com.example.servlet_shopbb.entity.KichThuoc;
import com.example.servlet_shopbb.service.KichThuocService;
import com.example.servlet_shopbb.service.KichThuocService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdsizeServlet", value = {
        "/admin/size",
        "/admin/size/add",
        "/admin/size/update",
        "/admin/size/delete"
})
public class AdSizeServlet extends HttpServlet {
    KichThuocService ktService;

    public AdSizeServlet() {
        ktService = new KichThuocService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("size/delete")){
            delete(request, response);
        }else {
            index(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("size/add")){
            add(request, response);
        }else if(uri.contains("size/update")){
            update(request, response);
        }else {
            index(request, response);
        }
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("lstSize",ktService.getAll());
        request.setAttribute("view", "/admin/manage_size.jsp");
        request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("ten");
        String trangThai = request.getParameter("trangThai");
        KichThuoc kt = new KichThuoc();
        kt.setTen(ten);
        kt.setTrangThai(Integer.valueOf(trangThai));
        ktService.save(kt);
        response.sendRedirect("/admin/size");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String ten = request.getParameter("ten");
        String trangThai = request.getParameter("trangThai");

        KichThuoc kt = ktService.getById(Integer.valueOf(id));
        kt.setTen(ten);
        kt.setTrangThai(Integer.valueOf(trangThai));
        ktService.update(kt);
        response.sendRedirect("/admin/size");

    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        KichThuoc kt = ktService.getById(Integer.valueOf(id));

        ktService.delete(kt);
        response.sendRedirect("/admin/size");
    }

}
