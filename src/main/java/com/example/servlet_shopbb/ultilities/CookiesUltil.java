package com.example.servlet_shopbb.ultilities;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookiesUltil {
    public static String getCookies(HttpServletRequest request, HttpServletResponse response, String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(key)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static void setCookies(HttpServletRequest request, HttpServletResponse response, String key, String value) {
        Cookie cookie = new Cookie(key,value);
        cookie.setMaxAge(60*60);
        cookie.setPath("/");
        response.addCookie(cookie);

    }

    public static void removeCookies(HttpServletRequest request, HttpServletResponse response, String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(key)) {
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    System.out.println("Removed ok cokie");
                    break;
                }
            }
        }
    }

}

