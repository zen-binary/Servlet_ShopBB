package com.example.servlet_shopbb.controller.admin;

import com.example.servlet_shopbb.entity.NguoiDung;
import com.example.servlet_shopbb.service.NguoiDungService;
import com.example.servlet_shopbb.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "UsersServlet", value = {
        "/admin/user",
        "/admin/user/add",
        "/admin/user/update",
        "/admin/user/remove"
})
public class AdUserServlet extends HttpServlet {
    UserService userService = new UserService();
    NguoiDungService ndService = new NguoiDungService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        System.out.println("sdđ");
        if(uri.contains("remove")){
            remove(request, response);
        }else {
            index(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            add(request, response);
        }else if (uri.contains("update")){
            update(request, response);
        }else{
            index(request, response);
        }
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("lstUser", userService.getUser());
        request.setAttribute("view", "/admin/manage_user.jsp");
        request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        response.sendRedirect("/admin/user");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        DateTimeConverter dtc = new DateConverter(new Date());
        dtc.setPattern("MM/dd/yyyy");
        ConvertUtils.register(dtc, Date.class);
        NguoiDung nd = ndService.getById(Integer.valueOf(id));
        try {
            BeanUtils.populate(nd, request.getParameterMap());
        }catch (Exception e) {
            e.printStackTrace();
        }

        ndService.update(nd);
        response.sendRedirect("/admin/user");
    }
    protected void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NguoiDung nd = ndService.getById(Integer.valueOf(id));
        ndService.delete(nd);
        response.sendRedirect("/admin/user");
    }
}
