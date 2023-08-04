package com.example.servlet_shopbb.service;

import com.example.servlet_shopbb.entity.KichThuoc;
import com.example.servlet_shopbb.repositories.IRepository;
import com.example.servlet_shopbb.repositories.Impl.Repository;

import java.util.List;

public class KichThuocService {

    IRepository<KichThuoc> ktRepo = new Repository<KichThuoc>(KichThuoc.class);

    public List<KichThuoc> getAll(){
        return ktRepo.getAll();
    }
    public KichThuoc getById(Integer id){
        return (KichThuoc) ktRepo.getById(id);
    }

    public Boolean save(KichThuoc entity){
        return ktRepo.save(entity);
    }

    public Boolean update(KichThuoc entity){
        return ktRepo.update(entity);
    }

    public Boolean delete(KichThuoc entity){
        return ktRepo.delete(entity);
    }

    public static void main(String[] args) {
        System.out.println(new KichThuocService().getAll());
    }
}
