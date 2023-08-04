package com.example.servlet_shopbb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "CHITIETSANPHAM")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ChiTietSanPham {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="IdSP")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name="IdMS")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name="IdKT")
    private KichThuoc kichThuoc;

    @Column(name = "HinhAnh")
    private String hinhAnh;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "SoLuongBan")
    private Integer soLuongBan;

    @Column(name = "GiaNhap")
    private Double giaNhap;

    @Column(name = "GiaBan")
    private Double giaBan;

    @Column(name = "NgayTao")
    @Temporal(TemporalType.DATE)
    private Date ngayTao;

    @Column(name = "NgaySua")
    @Temporal(TemporalType.DATE)
    private Date ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;
}
