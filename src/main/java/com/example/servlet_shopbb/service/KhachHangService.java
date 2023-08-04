package com.example.servlet_shopbb.service;

import com.example.servlet_shopbb.entity.KhachHang;
import com.example.servlet_shopbb.repositories.IRepository;
import com.example.servlet_shopbb.repositories.Impl.Repository;

import java.util.List;

public class KhachHangService {

    IRepository khRepo = new Repository(KhachHang.class);

    public List<KhachHang> getAll(){
        return khRepo.getAll();
    }
    public KhachHang getById(Integer id){
        return (KhachHang) khRepo.getById(id);
    }

    public Boolean save(KhachHang entity){
        return khRepo.save(entity);
    }

    public Boolean update(KhachHang entity){
        return khRepo.update(entity);
    }

    public Boolean delete(KhachHang entity){
        return khRepo.delete(entity);
    }

}
