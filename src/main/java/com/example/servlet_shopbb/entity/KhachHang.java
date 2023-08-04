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
@Table(name = "KHACHHANG")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class KhachHang {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "NgaySinh")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "GioiTinh")
    private Integer gioiTinh;

    @Column(name = "DiaChi")
    private String diaChi;

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
