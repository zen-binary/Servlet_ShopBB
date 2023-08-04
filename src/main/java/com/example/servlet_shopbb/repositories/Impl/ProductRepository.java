package com.example.servlet_shopbb.repositories.Impl;

import com.example.servlet_shopbb.config.HibernateConfig;
import com.example.servlet_shopbb.viewmodel.ProductView;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    public List<ProductView> getLstProducts() {
        List<ProductView> lst = new ArrayList<>();
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Query query = session.createQuery("SELECT NEW com.example.servlet_shopbb.viewmodel.ProductView(csp.sanPham.id,csp.sanPham.ten, csp.sanPham.hinhAnh, MIN(csp.giaBan) AS min, MAX(csp.giaBan) AS max, SUM(csp.soLuongBan) as soluong) FROM ChiTietSanPham csp GROUP BY csp.sanPham.id,csp.sanPham.ten, csp.sanPham.hinhAnh");
//            Query query = session.createQuery("SELECT  csp.sanPham.id,csp.sanPham.ten, csp.sanPham.hinhAnh, MIN(csp.giaBan) AS min, MAX(csp.giaBan) AS max, SUM(csp.soLuongBan) AS sl FROM ChiTietSanPham csp GROUP BY csp.sanPham.id,csp.sanPham.ten, csp.sanPham.hinhAnh");
            lst = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }


}
