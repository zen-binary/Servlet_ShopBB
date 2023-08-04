package com.example.servlet_shopbb.repositories.Impl;

import com.example.servlet_shopbb.config.HibernateConfig;
import com.example.servlet_shopbb.entity.HoaDon;
import com.example.servlet_shopbb.entity.HoaDonChiTiet;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class HomeReposetory {

    public HoaDon getHoaDonByNd(Integer idNd) {
        HoaDon hd = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM HoaDon where nguoiDung.id = :idNd and trangThai = null or trangThai = 0");
            query.setParameter("idNd", idNd);
            hd = (HoaDon) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hd;
    }

    public Long getCountSP(Integer idHd) {
        Long count = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Query query = session.createQuery("select count(hdct.id) FROM HoaDonChiTiet hdct where hdct.hoaDon.id = :idHd");
            query.setParameter("idHd", idHd);
            count = (Long) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new HomeReposetory().getCountSP(62));
    }
}
