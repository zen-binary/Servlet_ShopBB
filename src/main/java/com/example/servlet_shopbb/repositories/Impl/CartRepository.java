package com.example.servlet_shopbb.repositories.Impl;

import com.example.servlet_shopbb.config.HibernateConfig;
import com.example.servlet_shopbb.entity.ChiTietSanPham;
import com.example.servlet_shopbb.entity.HoaDonChiTiet;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CartRepository {
    public List<HoaDonChiTiet> getCartHD(Integer idHD) {
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

    public HoaDonChiTiet getHdctByIdSP(Integer idHd, Integer idSP) {
        HoaDonChiTiet hdct = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM HoaDonChiTiet where hoaDon.id =:idHd  and chiTietSanPham.id = :idSP");
            query.setParameter("idHd",idHd);
            query.setParameter("idSP",idSP);
            hdct = (HoaDonChiTiet) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hdct;
    }

    public Double getTongTien(Integer idHD) {
        Double tongTien = 0.0;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Query query = session.createQuery("SELECT SUM(hdct.donGia*hdct.soLuong) FROM HoaDonChiTiet hdct where hdct.hoaDon.id = :idHD");
            query.setParameter("idHD",idHD);
            tongTien = (Double) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tongTien;
    }
}
