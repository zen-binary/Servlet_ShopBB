package com.example.servlet_shopbb.config;

import com.example.servlet_shopbb.entity.ChiTietSanPham;
import com.example.servlet_shopbb.entity.HoaDon;
import com.example.servlet_shopbb.entity.HoaDonChiTiet;
import com.example.servlet_shopbb.entity.KhachHang;
import com.example.servlet_shopbb.entity.KichThuoc;
import com.example.servlet_shopbb.entity.Loai;
import com.example.servlet_shopbb.entity.MauSac;
import com.example.servlet_shopbb.entity.NguoiDung;
import com.example.servlet_shopbb.entity.SanPham;
import com.example.servlet_shopbb.entity.VaiTro;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateConfig {

    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=SHOP_BB");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123456");
        properties.put(Environment.SHOW_SQL, "true");

        conf.addAnnotatedClass(VaiTro.class);
        conf.addAnnotatedClass(NguoiDung.class);
        conf.addAnnotatedClass(Loai.class);
        conf.addAnnotatedClass(KichThuoc.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(ChiTietSanPham.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);

        conf.setProperties(properties);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        getFACTORY();
    }

}
