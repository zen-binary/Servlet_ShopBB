package com.example.servlet_shopbb.repositories;

import com.example.servlet_shopbb.entity.ChiTietSanPham;
import com.example.servlet_shopbb.repositories.Impl.DetailRepository;
import com.example.servlet_shopbb.repositories.Impl.Repository;

public class test {
    public static void main(String[] args){
        IRepository<ChiTietSanPham> repo = new Repository<ChiTietSanPham>(ChiTietSanPham.class);
//        VaiTro vt = new VaiTro();
//        vt.setTen("hissss");
//        repo.save(vt);
//        System.out.println(repo.getAll());
//        VaiTro vt = (VaiTro) repo.getById(1);
//        System.out.println(vt.toString());

//        System.out.println(repo.getAll());

        System.out.println(new DetailRepository().getDetailMauSac(1,""));
    }

}
