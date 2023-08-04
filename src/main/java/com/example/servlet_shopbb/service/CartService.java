package com.example.servlet_shopbb.service;

import com.example.servlet_shopbb.entity.HoaDonChiTiet;
import com.example.servlet_shopbb.repositories.Impl.CartRepository;

import java.util.List;

public class CartService {
    CartRepository cartRepo = new CartRepository();
    public List<HoaDonChiTiet> getCartHD(Integer idHD){
        return  cartRepo.getCartHD(idHD);
    }

    public HoaDonChiTiet getHdctByIdSP(Integer idHd,String idSP){
        try {
            int id = Integer.parseInt(idSP);
            return cartRepo.getHdctByIdSP(idHd,id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public Double getTongTien(Integer idHD){
        return cartRepo.getTongTien(idHD);
    }

}
