package com.example.servlet_shopbb.repositories.Impl;

import com.example.servlet_shopbb.config.HibernateConfig;
import com.example.servlet_shopbb.entity.HoaDonChiTiet;
import com.example.servlet_shopbb.entity.NguoiDung;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public List<NguoiDung> getUser() {
        List<NguoiDung> lstNd = new ArrayList<>();
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NguoiDung nd where nd.idVT.id is null");
            lstNd = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstNd;
    }

    public List<NguoiDung> getStaff() {
        List<NguoiDung> lstNd = new ArrayList<>();
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NguoiDung nd where nd.idVT.id is not null");
            lstNd = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstNd;
    }
}
