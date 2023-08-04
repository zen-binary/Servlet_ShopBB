package com.example.servlet_shopbb.fillter;

import com.example.servlet_shopbb.entity.NguoiDung;
import com.example.servlet_shopbb.ultilities.CookiesUltil;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "loginFilter", value = {
        "/login",
        "/login/*",
})
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        NguoiDung nd = (NguoiDung) session.getAttribute("nd");
        if (nd == null) {
            System.out.println(nd);
            chain.doFilter(request, response);
        }else {
            res.sendRedirect("/home");

        }
    }
}
