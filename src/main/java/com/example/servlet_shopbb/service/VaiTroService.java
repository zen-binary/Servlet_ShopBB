package com.example.servlet_shopbb.service;

import com.example.servlet_shopbb.entity.VaiTro;
import com.example.servlet_shopbb.repositories.IRepository;
import com.example.servlet_shopbb.repositories.Impl.Repository;

import java.util.List;

public class VaiTroService {

    IRepository vtRepo = new Repository(VaiTro.class);

    public List<VaiTro> getAll(){
        return vtRepo.getAll();
    }
    public VaiTro getById(Integer id){
        return (VaiTro) vtRepo.getById(id);
    }


    public Boolean save(VaiTro entity){
        return vtRepo.save(entity);
    }

    public Boolean update(VaiTro entity){
        return vtRepo.update(entity);
    }

    public Boolean delete(VaiTro entity){
        return vtRepo.delete(entity);
    }

}
