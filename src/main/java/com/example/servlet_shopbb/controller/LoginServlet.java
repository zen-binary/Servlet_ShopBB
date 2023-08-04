package com.example.servlet_shopbb.controller;

import com.example.servlet_shopbb.entity.NguoiDung;
import com.example.servlet_shopbb.service.LoginService;
import com.example.servlet_shopbb.service.NguoiDungService;
import com.example.servlet_shopbb.ultilities.CookiesUltil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "LoginServlet", value = {
        "/login",
        "/sign-up",
        "/logout",
        "/login/*"
})
public class LoginServlet extends HttpServlet {
    LoginService loginService = new LoginService();
    NguoiDungService ndService = new NguoiDungService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (uri.contains("/logout")){
            logOut(request, response);
        }else {
            index(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if (uri.contains("/login")){
            loginAcc(request, response);
        }else if (uri.contains("/sign-up")){
            signUp(request, response);
        }else {
            index(request, response);
        }
    }

    protected void signUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DateTimeConverter dtc = new DateConverter(new Date());
        dtc.setPattern("MM/dd/yyyy");
        ConvertUtils.register(dtc, Date.class);
        NguoiDung nd = new NguoiDung();
        try {
            BeanUtils.populate(nd, request.getParameterMap());
        }catch (Exception e) {
            e.printStackTrace();
        }

        ndService.save(nd);
        response.sendRedirect("/login");
    }
    protected void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("nd");
        CookiesUltil.removeCookies(request,response,"user_hd_client");
        response.sendRedirect("/home");
        System.out.println("Đăng Xuất Ok");

    }

    protected void loginAcc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        NguoiDung nd = loginService.loginAccount(user, pass);
        Cookie cookie = new Cookie("c_user",user);
        cookie.setMaxAge(60*60);
        cookie.setPath("/");
        response.addCookie(cookie);
        HttpSession session = request.getSession();

        if(nd != null){
            Cookie cookie2 = new Cookie("c_pass",pass);
            cookie2.setMaxAge(60*60);
            cookie2.setPath("/");
            response.addCookie(cookie2);
            session.setAttribute("nd",nd);
            response.sendRedirect("/home");
        }else {
            request.setAttribute("errorMess","Tài Khoản Mật Khẩu Không Chính Xác");
            index(request, response);
        }
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getC_User(request, response);
        request.getRequestDispatcher("/view/login.jsp").forward(request, response);
    }
    public void getC_User(HttpServletRequest request, HttpServletResponse response){

        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies){
                if (cookie.getName().equals("c_user")){
                    request.setAttribute("user",cookie.getValue());
                }
            }
        }
    }

}
