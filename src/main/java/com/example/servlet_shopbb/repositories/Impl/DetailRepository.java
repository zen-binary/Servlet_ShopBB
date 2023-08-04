package com.example.servlet_shopbb.repositories.Impl;

import com.example.servlet_shopbb.config.HibernateConfig;
import com.example.servlet_shopbb.entity.ChiTietSanPham;
import com.example.servlet_shopbb.entity.KichThuoc;
import com.example.servlet_shopbb.entity.MauSac;
import com.example.servlet_shopbb.viewmodel.ProductView;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DetailRepository {
    public List<ChiTietSanPham> getDetailProducts(Integer idSP) {
        List<ChiTietSanPham> lstCtsp = new ArrayList<>();
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChiTietSanPham where sanPham.id = :idSP");
            query.setParameter("idSP", idSP);
            lstCtsp =  query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstCtsp;
    }

    public List<MauSac> getDetailMauSac(Integer idSP,String idKt) {
        List<MauSac> lstMs = new ArrayList<>();
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Query<MauSac> query = session.createQuery("SELECT DISTINCT ctsp.mauSac FROM ChiTietSanPham ctsp WHERE ctsp.sanPham.id = :idSP AND cast(ctsp.kichThuoc.id AS string) LIKE :idKt", MauSac.class);
//            Query<MauSac> query = session.createQuery("SELECT ctsp.mauSac FROM ChiTietSanPham ctsp WHERE ctsp.sanPham.id = :idSP GROUP BY ctsp.mauSac.id", MauSac.class);
            query.setParameter("idSP", idSP);
            query.setParameter("idKt", "%"+idKt+"%");

            lstMs = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstMs;
    }

    public List<KichThuoc> getDetailKichThuoc(Integer idSP,String idMs) {
        List<KichThuoc> lstKt = new ArrayList<>();
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Query<KichThuoc> query = session.createQuery("SELECT DISTINCT ctsp.kichThuoc FROM ChiTietSanPham ctsp WHERE ctsp.sanPham.id = :idSP AND cast(ctsp.mauSac.id AS string) LIKE :idMs", KichThuoc.class);
            query.setParameter("idSP", idSP);
            query.setParameter("idMs", "%"+idMs+"%");
            lstKt = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstKt;
    }


    public List<ChiTietSanPham> getDetailAttribute(Integer idSP, String idMs, String idKt) {
        List<ChiTietSanPham> lstCtsp = new ArrayList<>();
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChiTietSanPham ctsp where ctsp.sanPham.id = :idSP AND cast(ctsp.mauSac.id AS string) LIKE :idMs AND cast(ctsp.kichThuoc.id AS string) LIKE :idKt");
            query.setParameter("idSP", idSP);
            query.setParameter("idMs", "%"+idMs+"%");
            query.setParameter("idKt", "%"+idKt+"%");
            lstCtsp =  query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstCtsp;
    }
}
