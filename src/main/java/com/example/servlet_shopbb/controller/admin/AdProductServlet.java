package com.example.servlet_shopbb.controller.admin;

import com.example.servlet_shopbb.entity.Loai;
import com.example.servlet_shopbb.entity.SanPham;
import com.example.servlet_shopbb.service.LoaiService;
import com.example.servlet_shopbb.service.SanPhamService;
import com.example.servlet_shopbb.ultilities.SaveFileUltil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "AdproductServlet", value = {
        "/admin/product",
        "/admin/product/add",
        "/admin/product/update",
        "/admin/product/delete"
})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,    // 10MB
        maxRequestSize = 1024 * 1024 * 50)
public class AdProductServlet extends HttpServlet {
    SanPhamService spService;
    LoaiService loaiService;

    public AdProductServlet() {
        spService = new SanPhamService();
        loaiService = new LoaiService();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("product/delete")){
            delete(request, response);
        }else {
            index(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("product/add")){
            add(request, response);
        }else if(uri.contains("product/update")){
            update(request, response);
        }else {
            index(request, response);
        }
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "/admin/manage_product.jsp");
        request.setAttribute("lstSp", spService.getAll());
        request.setAttribute("lstLoai", loaiService.getAll());
        request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Part photo = request.getPart("hinhAnh");
        String fileName= photo.getSubmittedFileName();
        File file = new File("/img/product/");
        SaveFileUltil.saveFile(request,response,file,photo);

        String ten = request.getParameter("ten");
        String idLoai = request.getParameter("loai");
        String hinhAnh = request.getParameter("hinhAnh");
        String moTa = request.getParameter("moTa");
        String trangThai = request.getParameter("trangThai");
        SanPham sp = new SanPham();
        Loai loai = loaiService.getById(Integer.valueOf(idLoai));
        sp.setTen(ten);
        sp.setLoai(loai);
        sp.setHinhAnh(fileName);
        sp.setMoTa(moTa);
        sp.setTrangThai(Integer.valueOf(trangThai));
        spService.save(sp);
        System.out.println(sp.getHinhAnh());
        response.sendRedirect("/admin/product");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part photo = request.getPart("hinhAnh");
        String fileName = photo.getSubmittedFileName();
        File file = new File("/img/product/");
        SaveFileUltil.saveFile(request,response,file,photo);
        System.out.println(fileName);
        String id = request.getParameter("id");
        String ten = request.getParameter("ten");
        String idLoai = request.getParameter("loai");
        String hinhAnh = request.getParameter("hinhAnh");
        String moTa = request.getParameter("moTa");
        String trangThai = request.getParameter("trangThai");
        Loai loai = loaiService.getById(Integer.valueOf(idLoai));
        SanPham sp = spService.getById(Integer.valueOf(id));
        sp.setTen(ten);
        sp.setLoai(loai);
        sp.setHinhAnh(fileName);
        sp.setMoTa(moTa);
        sp.setTrangThai(Integer.valueOf(trangThai));
        System.out.println("sp");
        spService.update(sp);
        response.sendRedirect("/admin/product");

    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        SanPham sp = spService.getById(Integer.valueOf(id));

        spService.delete(sp);
        response.sendRedirect("/admin/product");
    }

}
