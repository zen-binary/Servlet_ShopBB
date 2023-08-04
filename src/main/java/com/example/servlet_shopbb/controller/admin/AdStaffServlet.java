package com.example.servlet_shopbb.controller.admin;

import com.example.servlet_shopbb.entity.NguoiDung;
import com.example.servlet_shopbb.entity.VaiTro;
import com.example.servlet_shopbb.service.NguoiDungService;
import com.example.servlet_shopbb.service.UserService;
import com.example.servlet_shopbb.service.VaiTroService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import java.io.IOException;
import java.util.Date;

@WebServlet(name = "UserServlet", value = {
        "/admin/staff",
        "/admin/staff/add",
        "/admin/staff/update",
        "/admin/staff/remove"
})
public class AdStaffServlet extends HttpServlet {
    UserService userService = new UserService();
    NguoiDungService ndService = new NguoiDungService();
    VaiTroService vtService = new VaiTroService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
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
        request.setAttribute("view", "/admin/manage_staff.jsp");
        request.setAttribute("lstUser", userService.getStaff());
        request.setAttribute("lstVt",vtService.getAll());
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
        String idVt = request.getParameter("vaiTro");
        VaiTro vt = vtService.getById(Integer.valueOf(idVt));
        nd.setIdVT(vt);
        ndService.save(nd);
        response.sendRedirect("/admin/staff");
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
        String idVt = request.getParameter("vaiTro");
        VaiTro vt = vtService.getById(Integer.valueOf(idVt));
        nd.setIdVT(vt);

        ndService.update(nd);
        response.sendRedirect("/admin/staff");
    }
    protected void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NguoiDung nd = ndService.getById(Integer.valueOf(id));
        ndService.delete(nd);
        response.sendRedirect("/admin/staff");
    }
}
