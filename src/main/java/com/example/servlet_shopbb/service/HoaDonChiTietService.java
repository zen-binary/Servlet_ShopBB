package com.example.servlet_shopbb.service;

import com.example.servlet_shopbb.entity.HoaDonChiTiet;
import com.example.servlet_shopbb.repositories.IRepository;
import com.example.servlet_shopbb.repositories.Impl.Repository;

import java.util.List;

public class HoaDonChiTietService {

    IRepository hdctRepo = new Repository(HoaDonChiTiet.class);

    public List<HoaDonChiTiet> getAll(){
        return hdctRepo.getAll();
    }
    public HoaDonChiTiet getById(Integer id){
        return (HoaDonChiTiet) hdctRepo.getById(id);
    }


    public Boolean save(HoaDonChiTiet entity){
        return hdctRepo.save(entity);
    }

    public Boolean update(HoaDonChiTiet entity){
        return hdctRepo.update(entity);
    }

    public Boolean delete(HoaDonChiTiet entity){
        return hdctRepo.delete(entity);
    }

}
