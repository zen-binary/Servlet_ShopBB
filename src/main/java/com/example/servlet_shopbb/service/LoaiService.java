package com.example.servlet_shopbb.service;

import com.example.servlet_shopbb.entity.Loai;
import com.example.servlet_shopbb.repositories.IRepository;
import com.example.servlet_shopbb.repositories.Impl.Repository;

import java.util.List;

public class LoaiService {

    IRepository<Loai> loaiRepo = new Repository<Loai>(Loai.class);

    public List<Loai> getAll(){
        return loaiRepo.getAll();
    }
    public Loai getById(Integer id){
        return (Loai) loaiRepo.getById(id);
    }

    public Boolean save(Loai entity){
        return loaiRepo.save(entity);
    }

    public Boolean update(Loai entity){
        return loaiRepo.update(entity);
    }

    public Boolean delete(Loai entity){
        return loaiRepo.delete(entity);
    }

}
