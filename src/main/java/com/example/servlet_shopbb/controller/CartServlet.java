package com.example.servlet_shopbb.controller;

import com.example.servlet_shopbb.entity.ChiTietSanPham;
import com.example.servlet_shopbb.entity.HoaDon;
import com.example.servlet_shopbb.entity.HoaDonChiTiet;
import com.example.servlet_shopbb.service.CartService;
import com.example.servlet_shopbb.service.ChiTietSanPhamService;
import com.example.servlet_shopbb.service.HoaDonChiTietService;
import com.example.servlet_shopbb.service.HoaDonService;
import com.example.servlet_shopbb.service.HomeService;
import com.example.servlet_shopbb.ultilities.CookiesUltil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CardServlet", value = {
        "/cart/",
        "/cart/add",
        "/cart/delete",
        "/cart/buy",
        "/cart/update",
        "/cart/*",
})
public class CartServlet extends HttpServlet {
    CartService cartService = new CartService();
    HoaDonService hdService = new HoaDonService();
    HoaDonChiTietService hdctService = new HoaDonChiTietService();
    ChiTietSanPhamService ctspService = new ChiTietSanPhamService();
    HomeService homeService = new HomeService();
    HoaDon hd = null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idHd = "";
        idHd = CookiesUltil.getCookies(request,response,"user_hd_client");
        if (idHd==null) {
            idHd = CookiesUltil.getCookies(request,response,"user_hd_virtual");
        }
        hd = hdService.getById(Integer.parseInt(idHd));

        String uri = request.getRequestURI();
         if (uri.contains("/delete")) {
            delete(request, response);
        }else {
            index(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idHd = "";
        idHd = CookiesUltil.getCookies(request,response,"user_hd_client");
        if (idHd==null) {
            idHd = CookiesUltil.getCookies(request,response,"user_hd_virtual");
        }
        hd = hdService.getById(Integer.parseInt(idHd));

        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            add(request, response);
        }else if (uri.contains("/buy")){
            buy(request, response);
        }else if (uri.contains("/update")){
            update(request, response);
        }else if (uri.contains("/pay")){
            pay(request, response);
        }else {
            index(request, response);
        }
    }

    private void pay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("ten");
        String sdt = request.getParameter("sdt");
        String email = request.getParameter("email");
        String diaChi = request.getParameter("diaChi");

        hd.setNgaySua(new Date());
        hd.setDiaChi(diaChi);
        hd.setEmail(email);
        hd.setTenNguoiNhan(ten);
        hd.setSdt(sdt);
        hd.setTrangThai(1);
        hdService.update(hd);
        List<HoaDonChiTiet> lstHdct = cartService.getCartHD(hd.getId());

        for (HoaDonChiTiet hdct : lstHdct) {
            ChiTietSanPham ctsp = ctspService.getById(hdct.getChiTietSanPham().getId());
            ctsp.setSoLuongTon(ctsp.getSoLuongTon() - hdct.getSoLuong());
            ctsp.setSoLuongBan(ctsp.getSoLuongBan() + hdct.getSoLuong());
            ctspService.update(ctsp);
        }
        String idHdCk = CookiesUltil.getCookies(request,response,"user_hd_virtual");
        if(idHdCk != null){
            CookiesUltil.removeCookies(request,response,"user_hd_virtual");
        }
        response.sendRedirect("/home");

    }


    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("tongTien",cartService.getTongTien(hd.getId()));
        request.setAttribute("lstCart", cartService.getCartHD(hd.getId()));
        request.setAttribute("hoaDon",hd);
        request.setAttribute("view", "/view/cart.jsp");

        HttpSession session = request.getSession();
        session.setAttribute("countCart",homeService.getCountSP(hd.getId()));

        request.getRequestDispatcher("/view/index.jsp").forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        HoaDonChiTiet hdct =  hdctService.getById(Integer.valueOf(id));
        hdctService.delete(hdct);
        HttpSession session = request.getSession();
        session.setAttribute("countCart",homeService.getCountSP(hd.getId()));
        response.sendRedirect("/cart");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String quantity = request.getParameter("quantity");
        HoaDonChiTiet hdct =  hdctService.getById(Integer.valueOf(id));
        hdct.setSoLuong(Integer.valueOf(quantity));
        hdct.setNgaySua(new Date());
        hdctService.update(hdct);

        response.sendRedirect("/cart");
    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String quantity = request.getParameter("quantity");
        HoaDonChiTiet hdctBySP = cartService.getHdctByIdSP(hd.getId(),id);
        ChiTietSanPham ctsp = ctspService.getById(Integer.valueOf(id));

        if (hdctBySP != null) {
            hdctBySP.setSoLuong(hdctBySP.getSoLuong() + Integer.valueOf(quantity));
            hdctBySP.setNgaySua(new Date());
            hdctService.update(hdctBySP);
            System.out.println("Cộng rồn ok");

        }else {
            HoaDonChiTiet hdct = new HoaDonChiTiet();
            hdct.setChiTietSanPham(ctsp);
            hdct.setHoaDon(hd);
            hdct.setDonGia(ctsp.getGiaBan());
            hdct.setSoLuong(Integer.valueOf(quantity));
            hdct.setNgaySua(new Date());
            hdct.setNgayTao(new Date());
            hdctService.save(hdct);
            System.out.println("Tạo thêm mới ok");
        }

        HttpSession session = request.getSession();
        session.setAttribute("countCart",homeService.getCountSP(hd.getId()));

        response.sendRedirect("/details?id="+ctsp.getSanPham().getId());
    }

    private void buy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String quantity = request.getParameter("quantity");
        System.out.println(quantity);
        HoaDonChiTiet hdctBySP = cartService.getHdctByIdSP(hd.getId(),id);
        ChiTietSanPham ctsp = ctspService.getById(Integer.valueOf(id));
        if (hdctBySP != null) {
            hdctBySP.setSoLuong(hdctBySP.getSoLuong() + Integer.valueOf(quantity));
            hdctBySP.setNgaySua(new Date());
            hdctService.update(hdctBySP);
            System.out.println("Cộng rồn ok");

        }else {
            HoaDonChiTiet hdct = new HoaDonChiTiet();
            hdct.setChiTietSanPham(ctsp);
            hdct.setHoaDon(hd);
            hdct.setDonGia(ctsp.getGiaBan());
            hdct.setSoLuong(Integer.valueOf(quantity));
            hdct.setNgaySua(new Date());
            hdct.setNgayTao(new Date());
            hdctService.save(hdct);
            System.out.println("Tạo thêm mới ok");
        }

        response.sendRedirect("/cart");
    }
}
