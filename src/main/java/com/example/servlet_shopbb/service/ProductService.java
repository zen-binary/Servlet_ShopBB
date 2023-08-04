package com.example.servlet_shopbb.service;

import com.example.servlet_shopbb.repositories.Impl.ProductRepository;
import com.example.servlet_shopbb.viewmodel.ProductView;

import java.util.List;

public class ProductService {
    ProductRepository proRepo = new ProductRepository();
    public List<ProductView> getProductsAll(){
//        List<ProductView> lst = new ArrayList<>();
//        for (Object[] obj : proRepo.getLstProducts()) {
//            ProductView proView = new ProductView();
//            proView.setId((Integer) obj[0]);
//            proView.setTen((String) obj[1]);
//            proView.setHinhAnh((String) obj[2]);
//            proView.setGiaMin((Double) obj[3]);
//            proView.setGiaMax((Double) obj[4]);
//            proView.setSoLuongBan(Integer.valueOf(obj[5].toString()));
//            lst.add(proView);
//        }
        return proRepo.getLstProducts();
    }
}
