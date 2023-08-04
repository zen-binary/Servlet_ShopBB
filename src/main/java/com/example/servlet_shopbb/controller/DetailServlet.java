package com.example.servlet_shopbb.controller;

import com.example.servlet_shopbb.entity.ChiTietSanPham;
import com.example.servlet_shopbb.service.ChiTietSanPhamService;
import com.example.servlet_shopbb.service.DetailService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DetailServlet", value = {
        "/detail",
        "/details",
        "/details/*"
})
public class DetailServlet extends HttpServlet {
    ChiTietSanPhamService ctspService = new ChiTietSanPhamService();
    DetailService detailService = new DetailService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.equals("/details")) {
            index(request, response);
        }else if (uri.equals("/detail")){
            detailRadio(request, response);
        }else {
            index(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        List<ChiTietSanPham> lstDetail = detailService.getDetailProducts(Integer.valueOf(id));
        request.setAttribute("image", lstDetail.get(0).getSanPham().getHinhAnh());
        request.setAttribute("lstDetailPro", lstDetail);
        request.setAttribute("lstMS", detailService.getDetailMauSac(id,""));
        request.setAttribute("lstKt", detailService.getDetailKichThuoc(id,""));
        request.setAttribute("view","/view/detail.jsp");
        request.getRequestDispatcher("/view/index.jsp").forward(request, response);
    }

    protected void detailRadio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String color = request.getParameter("color");
        String size = request.getParameter("size");
        String quantity = request.getParameter("quantity");
        if (color == null) {
            color = "";
        }else {
            request.setAttribute("color", color);
        }
        if (size == null) {
            size = "";
        }else {
            request.setAttribute("size", size);
        }
        request.setAttribute("quantity", quantity);
        System.out.println(detailService.getDetailAttribute(id,color,size));
        List<ChiTietSanPham> lstDetail = detailService.getDetailAttribute(id,color,size);
        request.setAttribute("image", lstDetail.get(0).getHinhAnh());
        request.setAttribute("lstDetailPro", lstDetail);
        request.setAttribute("lstMS", detailService.getDetailMauSac(id,size));
        request.setAttribute("lstKt", detailService.getDetailKichThuoc(id,color));
        request.setAttribute("view","/view/detail.jsp");
        request.getRequestDispatcher("/view/index.jsp").forward(request, response);
    }

}
