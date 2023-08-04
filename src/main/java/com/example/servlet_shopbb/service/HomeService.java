package com.example.servlet_shopbb.service;

import com.example.servlet_shopbb.entity.HoaDon;
import com.example.servlet_shopbb.repositories.Impl.HomeReposetory;

public class HomeService {
    HomeReposetory homeRepo  = new HomeReposetory();
    public HoaDon getHoaDonByNd(Integer idNd){
        return homeRepo.getHoaDonByNd(idNd);
    }
    public Long getCountSP(Integer idHd){
        return homeRepo.getCountSP(idHd);
    }
}
