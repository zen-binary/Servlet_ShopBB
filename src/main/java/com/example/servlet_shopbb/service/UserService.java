package com.example.servlet_shopbb.service;

import com.example.servlet_shopbb.entity.NguoiDung;
import com.example.servlet_shopbb.repositories.Impl.UserRepository;

import java.util.List;

public class UserService {
    UserRepository userRepo = new UserRepository();
    public List<NguoiDung> getUser() {
        return userRepo.getUser();
    }
    public List<NguoiDung> getStaff() {
        return userRepo.getStaff();
    }
}
