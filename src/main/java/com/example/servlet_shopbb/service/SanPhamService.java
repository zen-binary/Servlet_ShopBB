package com.example.servlet_shopbb.service;

import com.example.servlet_shopbb.entity.SanPham;
import com.example.servlet_shopbb.repositories.IRepository;
import com.example.servlet_shopbb.repositories.Impl.Repository;

import java.util.List;

public class SanPhamService {

    IRepository<SanPham> spRepo = new Repository<SanPham>(SanPham.class);

    public List<SanPham> getAll(){
        return spRepo.getAll();
    }
    public SanPham getById(Integer id){
        return (SanPham) spRepo.getById(id);
    }

    public Boolean save(SanPham entity){
        return spRepo.save(entity);
    }

    public Boolean update(SanPham entity){
        return spRepo.update(entity);
    }

    public Boolean delete(SanPham entity){
        return spRepo.delete(entity);
    }

}
