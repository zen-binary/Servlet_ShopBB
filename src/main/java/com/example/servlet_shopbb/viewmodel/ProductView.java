package com.example.servlet_shopbb.viewmodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductView {
    private Integer id;
    private String ten;
    private String hinhAnh;
    private Double giaMin;
    private Double giaMax;
    private Long soLuongBan;


}
