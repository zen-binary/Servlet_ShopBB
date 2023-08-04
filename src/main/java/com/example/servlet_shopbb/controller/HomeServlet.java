package com.example.servlet_shopbb.controller;

import com.example.servlet_shopbb.entity.HoaDon;
import com.example.servlet_shopbb.entity.NguoiDung;
import com.example.servlet_shopbb.repositories.Impl.AdminRepository;
import com.example.servlet_shopbb.repositories.Impl.HomeReposetory;
import com.example.servlet_shopbb.service.HoaDonService;
import com.example.servlet_shopbb.service.HomeService;
import com.example.servlet_shopbb.ultilities.CookiesUltil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "HomeServlet", value = {
        "/home",
        "/home/*",
        "/index"
})
public class HomeServlet extends HttpServlet {
    HomeService homeService = new HomeService();
    HoaDonService hdService = new HoaDonService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        HoaDon hd = null;
        NguoiDung nd = (NguoiDung) session.getAttribute("nd");
        if (nd != null) {
            hd = homeService.getHoaDonByNd(nd.getId());
            if (hd == null) {
                hd = new HoaDon();
                hd.setNgayTao(new Date());
                hd.setNguoiDung(nd);
                hdService.save(hd);
            }
            CookiesUltil.setCookies(request,response,"user_hd_client",hd.getId().toString());

        }else {
            String idHd = CookiesUltil.getCookies(request,response,"user_hd_virtual");
            if (idHd != null) {
                hd = hdService.getById(Integer.parseInt(idHd));

            }else {
                hd = new HoaDon();
                hd.setNgayTao(new Date());
                hdService.save(hd);
                CookiesUltil.setCookies(request,response,"user_hd_virtual",hd.getId().toString());

            }
        }
        session.setAttribute("hd", hd);
        session.setAttribute("countCart", homeService.getCountSP(hd.getId()));
        session.setAttribute("nd",nd);


        request.setAttribute("view","/view/home.jsp");
        request.getRequestDispatcher("/view/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
