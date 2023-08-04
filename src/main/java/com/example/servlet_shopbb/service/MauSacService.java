package com.example.servlet_shopbb.service;

import com.example.servlet_shopbb.entity.MauSac;
import com.example.servlet_shopbb.repositories.IRepository;
import com.example.servlet_shopbb.repositories.Impl.Repository;

import java.util.List;

public class MauSacService {

    IRepository<MauSac> msRepo = new Repository<MauSac>(MauSac.class);

    public List<MauSac> getAll(){
        return msRepo.getAll();
    }
    public MauSac getById(Integer id){
        return (MauSac) msRepo.getById(id);
    }

    public Boolean save(MauSac entity){
        return msRepo.save(entity);
    }

    public Boolean update(MauSac entity){
        return msRepo.update(entity);
    }

    public Boolean delete(MauSac entity){
        return msRepo.delete(entity);
    }

    public static void main(String[] args) {
        System.out.println(new MauSacService().getAll());
    }
}
