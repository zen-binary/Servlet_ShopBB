package com.example.servlet_shopbb.fillter;

import com.example.servlet_shopbb.ultilities.CookiesUltil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "CartFilter", value = {
        "/cart/*",
        "/products/*",
        "/details/*",
        "/detail/*"
})
public class CartFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String idHd = CookiesUltil.getCookies(req,res,"user_hd_virtual");
        if (idHd == null) {
            res.sendRedirect("/home");
        }else {
            chain.doFilter(request, response);
        }
    }
}
