package com.example.servlet_shopbb.controller;

import com.example.servlet_shopbb.entity.NguoiDung;
import com.example.servlet_shopbb.repositories.Impl.OderRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "OderServlet", value = {
        "/oder"
})
public class OderServlet extends HttpServlet {
    OderRepository oderRepository = new OderRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        index(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        NguoiDung nd = (NguoiDung) session.getAttribute("nd");
        if(nd != null) {
            request.setAttribute("lstHd", oderRepository.getOderByNd(nd.getId()));
        }
        request.setAttribute("view","/view/oder.jsp");
        request.getRequestDispatcher("/view/index.jsp").forward(request, response);
    }
}
