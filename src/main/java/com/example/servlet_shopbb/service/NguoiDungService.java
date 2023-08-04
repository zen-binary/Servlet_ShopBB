package com.example.servlet_shopbb.service;

import com.example.servlet_shopbb.entity.NguoiDung;
import com.example.servlet_shopbb.repositories.IRepository;
import com.example.servlet_shopbb.repositories.Impl.Repository;

import java.util.List;

public class NguoiDungService {

    IRepository<NguoiDung> ndRepo = new Repository<NguoiDung>(NguoiDung.class);

    public List<NguoiDung> getAll(){
        return ndRepo.getAll();
    }
    public NguoiDung getById(Integer id){
        return (NguoiDung) ndRepo.getById(id);
    }

    public Boolean save(NguoiDung entity){
        return ndRepo.save(entity);
    }

    public Boolean update(NguoiDung entity){
        return ndRepo.update(entity);
    }

    public Boolean delete(NguoiDung entity){
        return ndRepo.delete(entity);
    }

}
