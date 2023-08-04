package com.example.servlet_shopbb.service;

import com.example.servlet_shopbb.entity.ChiTietSanPham;
import com.example.servlet_shopbb.entity.KichThuoc;
import com.example.servlet_shopbb.entity.MauSac;
import com.example.servlet_shopbb.repositories.Impl.DetailRepository;

import java.util.ArrayList;
import java.util.List;

public class DetailService {
    DetailRepository detailRepo;

    public DetailService() {
        detailRepo = new DetailRepository();
    }

    public List<ChiTietSanPham> getDetailProducts(Integer idSp){
        List<ChiTietSanPham> lst = new ArrayList<>();
        try{

            lst =  detailRepo.getDetailProducts(idSp);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }

    public List<MauSac> getDetailMauSac(String idSp,String idKt){
        List<MauSac> lst = new ArrayList<>();
        try{
            Integer id = Integer.parseInt(idSp);
            lst =  detailRepo.getDetailMauSac(id,idKt);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }

    public List<KichThuoc> getDetailKichThuoc(String idSp,String idMs){
        List<KichThuoc> lst = new ArrayList<>();
        try{
            Integer id = Integer.parseInt(idSp);
            lst =  detailRepo.getDetailKichThuoc(id,idMs);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }

    public List<ChiTietSanPham> getDetailAttribute(String idSp, String idMs, String idKt){

        List<ChiTietSanPham> lst = new ArrayList<>();
        try{
            Integer id = Integer.parseInt(idSp);
            lst =  detailRepo.getDetailAttribute(id,idMs,idKt);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lst;
    }
}
