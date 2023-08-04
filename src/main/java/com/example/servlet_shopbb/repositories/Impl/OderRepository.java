package com.example.servlet_shopbb.repositories.Impl;

import com.example.servlet_shopbb.config.HibernateConfig;
import com.example.servlet_shopbb.entity.ChiTietSanPham;
import com.example.servlet_shopbb.entity.HoaDon;
import com.example.servlet_shopbb.entity.HoaDonChiTiet;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class OderRepository {
    public List<HoaDonChiTiet> getOderDetail(Integer idHD) {
        List<HoaDonChiTiet> lstHdct = new ArrayList<>();
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM HoaDonChiTiet where hoaDon.id = :idHD ");
            query.setParameter("idHD",idHD);
            lstHdct = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstHdct;
    }

    public List<HoaDon> getOder() {
        List<HoaDon> lstHd = new ArrayList<>();
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM HoaDon where trangThai is not null");
            lstHd =  query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstHd;
    }

    public List<HoaDon> getOderByNd(Integer idNd) {
        List<HoaDon> lstHd = new ArrayList<>();
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM HoaDon where nguoiDung.id = :idNd");
            query.setParameter("idNd",idNd);
            lstHd =  query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstHd;
    }
}
