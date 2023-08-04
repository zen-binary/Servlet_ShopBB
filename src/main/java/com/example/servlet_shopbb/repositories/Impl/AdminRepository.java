package com.example.servlet_shopbb.repositories.Impl;

import com.example.servlet_shopbb.config.HibernateConfig;
import com.example.servlet_shopbb.entity.ChiTietSanPham;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class AdminRepository {
    public Long getCountProducts() {
        Long count= new Long(0);
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Query query = session.createQuery("select count(sp.id) FROM SanPham sp");
            count = (Long) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public Long getCountOder() {
        Long count= new Long(0);
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Query query = session.createQuery("select count(hd.id) FROM HoaDon hd where hd.trangThai is not null");
            count = (Long) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
