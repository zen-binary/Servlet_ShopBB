package com.example.servlet_shopbb.service;

import com.example.servlet_shopbb.entity.ChiTietSanPham;
import com.example.servlet_shopbb.repositories.IRepository;
import com.example.servlet_shopbb.repositories.Impl.Repository;

import java.util.List;

public class ChiTietSanPhamService {

    IRepository<ChiTietSanPham> ctspRepo = new Repository<ChiTietSanPham>(ChiTietSanPham.class);

    public List<ChiTietSanPham> getAll(){
        return ctspRepo.getAll();
    }

    public ChiTietSanPham getById(Integer id){
        return (ChiTietSanPham) ctspRepo.getById(id);
    }

    public Boolean save(ChiTietSanPham entity){
        return ctspRepo.save(entity);
    }

    public Boolean update(ChiTietSanPham entity){
        return ctspRepo.update(entity);
    }

    public Boolean delete(ChiTietSanPham entity){
        return ctspRepo.delete(entity);
    }

}
