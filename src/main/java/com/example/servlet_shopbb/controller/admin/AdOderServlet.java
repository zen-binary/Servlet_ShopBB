package com.example.servlet_shopbb.controller.admin;

import com.example.servlet_shopbb.entity.HoaDon;
import com.example.servlet_shopbb.service.HoaDonChiTietService;
import com.example.servlet_shopbb.service.HoaDonService;
import com.example.servlet_shopbb.service.OderService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "AdOderServlet", value = {
        "/admin/oder",
        "/admin/oder/detail",
        "/admin/oder/confirm",
        "/admin/oder/remove"
})
public class AdOderServlet extends HttpServlet {
    OderService oderService = new OderService();
    HoaDonService hdService = new HoaDonService();
    HoaDonChiTietService hdctService = new HoaDonChiTietService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("detail")){
            detail(request, response);
        }else if (uri.contains("confirm")) {
            confirm(request, response);
        }else if (uri.contains("remove")) {
            remove(request, response);
        }else {
            index(request, response);

        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("lstHd", oderService.getOder());
        request.setAttribute("view", "/admin/manage_oder.jsp");
        request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("hd", hdService.getById(Integer.valueOf(id)));
        request.setAttribute("lstHdct", oderService.getOderDetail(Integer.valueOf(id)));
        request.setAttribute("view", "/admin/manage_oder_detail.jsp");
        request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
    }

    protected void confirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        HoaDon hd = hdService.getById(Integer.valueOf(id));
        hd.setTrangThai(2);
        hd.setNgaySua(new Date());
        hdService.update(hd);
        response.sendRedirect("/admin/oder");
    }
    protected void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        HoaDon hd = hdService.getById(Integer.valueOf(id));
        hd.setTrangThai(0);
        hd.setNgaySua(new Date());
        hdService.update(hd);
        response.sendRedirect("/admin/oder");
    }
}
