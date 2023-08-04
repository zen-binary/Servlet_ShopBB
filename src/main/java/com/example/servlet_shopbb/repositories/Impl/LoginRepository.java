package com.example.servlet_shopbb.repositories.Impl;

import com.example.servlet_shopbb.config.HibernateConfig;
import com.example.servlet_shopbb.entity.NguoiDung;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class LoginRepository {

    public NguoiDung getAccount(String taiKhoan) {
        NguoiDung nguoiDung = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM NguoiDung WHERE taiKhoan = :taiKhoan");
            query.setParameter("taiKhoan", taiKhoan);
            System.out.println(taiKhoan);
            nguoiDung = (NguoiDung) query.getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("Không Tìm thấy Tk "+ ex.toString());
        }
        return nguoiDung;
    }
}
