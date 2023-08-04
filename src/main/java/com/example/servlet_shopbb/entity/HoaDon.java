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
@Table(name = "HOADON")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HoaDon {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "IdND")
    private NguoiDung nguoiDung;
    @ManyToOne()
    @JoinColumn(name = "IdKH")
    private KhachHang khachHang;

    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "Email")
    private String email;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "NgayShip")
    @Temporal(TemporalType.DATE)
    private Date ngayShip;

    @Column(name = "NgayNhan")
    @Temporal(TemporalType.DATE)
    private Date ngayNhan;

    @Column(name = "NgayThanhToan")
    @Temporal(TemporalType.DATE)
    private Date ngayThanhToan;

    @Column(name = "NgayTao")
    @Temporal(TemporalType.DATE)
    private Date ngayTao;

    @Column(name = "NgaySua")
    @Temporal(TemporalType.DATE)
    private Date ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;


}
