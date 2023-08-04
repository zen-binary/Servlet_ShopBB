package com.example.servlet_shopbb.service;

import com.example.servlet_shopbb.entity.HoaDon;
import com.example.servlet_shopbb.entity.HoaDonChiTiet;
import com.example.servlet_shopbb.repositories.Impl.OderRepository;

import java.util.List;

public class OderService {
    OderRepository oderRepo = new OderRepository();
    public List<HoaDon> getOder(){
        return oderRepo.getOder();
    }

    public List<HoaDonChiTiet> getOderDetail(Integer idHD){
        return oderRepo.getOderDetail(idHD);
    }
}
