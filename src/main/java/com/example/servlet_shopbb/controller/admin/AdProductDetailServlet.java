package com.example.servlet_shopbb.controller.admin;

import com.example.servlet_shopbb.entity.ChiTietSanPham;
import com.example.servlet_shopbb.entity.KichThuoc;
import com.example.servlet_shopbb.entity.MauSac;
import com.example.servlet_shopbb.entity.SanPham;
import com.example.servlet_shopbb.repositories.Impl.DetailRepository;
import com.example.servlet_shopbb.service.ChiTietSanPhamService;
import com.example.servlet_shopbb.service.DetailService;
import com.example.servlet_shopbb.service.KichThuocService;
import com.example.servlet_shopbb.service.MauSacService;
import com.example.servlet_shopbb.service.SanPhamService;
import com.example.servlet_shopbb.ultilities.SaveFileUltil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,    // 10MB
        maxRequestSize = 1024 * 1024 * 50,
        location = "")
@WebServlet(name = "AdProductDetailServlet", value = {
        "/admin/product/detail/*",
        "/admin/product/detail/add",
        "/admin/product/detail/update",
        "/admin/product/detail/delete"
})
public class AdProductDetailServlet extends HttpServlet {
    DetailService detailService;
    ChiTietSanPhamService ctspService;
    KichThuocService ktService;
    MauSacService msService;
    SanPhamService spService;
    String idSp = "";

    public AdProductDetailServlet() {
        detailService  = new DetailService();
        ctspService = new ChiTietSanPhamService();
        ktService = new KichThuocService();
        msService = new MauSacService();
        spService = new SanPhamService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/delete")){
            delete(request, response);
        }else {
            index(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")){
            add(request, response);
        }else if (uri.contains("/update")){
            update(request, response);
        }else {
            index(request,response);
        }
    }
    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        idSp  = request.getParameter("id");
        StringBuffer requestURL = request.getRequestURL();

        request.setAttribute("sp",spService.getById(Integer.valueOf(idSp)));
        request.setAttribute("lstDetail", detailService.getDetailProducts(Integer.valueOf(idSp)));
        request.setAttribute("lstMs",msService.getAll());
        request.setAttribute("lstKt",ktService.getAll());
        request.setAttribute("view","/admin/manage_product_detail.jsp");
        request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
        System.out.println("ssss");

    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part photo = request.getPart("hinhAnh");
        String fileName= photo.getSubmittedFileName();
        File file = new File("/img/product/");
        SaveFileUltil.saveFile(request,response,file,photo);

        String id = request.getParameter("id");
        String mauSac = request.getParameter("mauSac");
        String kichThuoc = request.getParameter("kichThuoc");
        String soLuong = request.getParameter("soLuong");
        String giaBan = request.getParameter("giaBan");
        String giaNhap = request.getParameter("giaNhap");
        String trangThai = request.getParameter("trangThai");
        SanPham sp = spService.getById(Integer.valueOf(id));
        MauSac ms = msService.getById(Integer.valueOf(mauSac));
        KichThuoc kt = ktService.getById(Integer.valueOf(kichThuoc));
        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp.setHinhAnh(fileName);
        ctsp.setSanPham(sp);
        ctsp.setMauSac(ms);
        ctsp.setKichThuoc(kt);
        ctsp.setSoLuongTon(Integer.valueOf(soLuong));
        ctsp.setSoLuongBan(0);
        ctsp.setGiaBan(Double.valueOf(giaBan));
        ctsp.setGiaNhap(Double.valueOf(giaNhap));
        ctsp.setTrangThai(Integer.valueOf(trangThai));
        ctspService.save(ctsp);
        System.out.println("add ok");

        response.sendRedirect("/admin/product/detail?id="+id);

    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part photo = request.getPart("hinhAnh");
        String fileName= photo.getSubmittedFileName();
        File file = new File("/img/product/");
        SaveFileUltil.saveFile(request,response,file,photo);

        String id = request.getParameter("id");
        String mauSac = request.getParameter("mauSac");
        String kichThuoc = request.getParameter("kichThuoc");
        String soLuong = request.getParameter("soLuong");
        String giaBan = request.getParameter("giaBan");
        String giaNhap = request.getParameter("giaNhap");
        String trangThai = request.getParameter("trangThai");
        MauSac ms = msService.getById(Integer.valueOf(mauSac));
        KichThuoc kt = ktService.getById(Integer.valueOf(kichThuoc));
        ChiTietSanPham ctsp = ctspService.getById(Integer.valueOf(id));
        ctsp.setMauSac(ms);
        ctsp.setKichThuoc(kt);
        ctsp.setHinhAnh(fileName);
        ctsp.setSoLuongTon(Integer.valueOf(soLuong));
        ctsp.setGiaBan(Double.valueOf(giaBan));
        ctsp.setGiaNhap(Double.valueOf(giaNhap));
        ctsp.setTrangThai(Integer.valueOf(trangThai));
        ctspService.update(ctsp);
        System.out.println(" ok");

        response.sendRedirect("/admin/product/detail?id="+idSp);
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChiTietSanPham ctsp = ctspService.getById(Integer.valueOf(id));
        ctspService.delete(ctsp);
        response.sendRedirect("/admin/product/detail?id="+idSp);
    }
}
