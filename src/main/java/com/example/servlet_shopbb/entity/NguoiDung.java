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
@Table(name = "NGUOIDUNG")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NguoiDung {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "IdVT")
    private VaiTro idVT;


    @Column(name = "Ten")
    private String ten;

    @Column(name = "TaiKhoan")
    private String taiKhoan;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "NgaySinh")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;

    @Column(name = "Email")
    private String email;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "GioiTinh")
    private Integer gioiTinh;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "HinhAnh")
    private String hinhAnh;

    @Column(name = "Google")
    private String google;

    @Column(name = "Facebook")
    private String facebook;

    @Column(name = "NgayTao")
    @Temporal(TemporalType.DATE)
    private Date ngayTao;

    @Column(name = "NgaySua")
    @Temporal(TemporalType.DATE)
    private Date ngaySua;

    @Column(name = "TrangThai")
    private Integer trangThai;
}
