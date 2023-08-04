package com.example.servlet_shopbb.service;

import com.example.servlet_shopbb.entity.HoaDon;
import com.example.servlet_shopbb.repositories.IRepository;
import com.example.servlet_shopbb.repositories.Impl.Repository;

import java.util.List;

public class HoaDonService {

    IRepository<HoaDon> hdRepo = new Repository<HoaDon>(HoaDon.class);

    public List<HoaDon> getAll(){
        return hdRepo.getAll();
    }
    public HoaDon getById(Integer id){
        return (HoaDon) hdRepo.getById(id);
    }

    public Boolean save(HoaDon entity){
        return hdRepo.save(entity);
    }

    public Boolean update(HoaDon entity){
        return hdRepo.update(entity);
    }

    public Boolean delete(HoaDon entity){
        return hdRepo.delete(entity);
    }

}
