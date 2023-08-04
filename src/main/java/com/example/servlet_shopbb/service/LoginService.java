package com.example.servlet_shopbb.service;

import com.example.servlet_shopbb.entity.NguoiDung;
import com.example.servlet_shopbb.repositories.Impl.LoginRepository;

public class LoginService {
    LoginRepository loginRepo;

    public LoginService() {
        loginRepo = new LoginRepository();
    }

    public NguoiDung loginAccount(String user, String pass){
        NguoiDung ng = loginRepo.getAccount(user);
        if (ng != null){
            if (ng.getMatKhau().equals(pass)){
                return ng;
            }
        }

        return null;
    }
}
