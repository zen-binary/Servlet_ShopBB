package com.example.servlet_shopbb;

import com.example.servlet_shopbb.repositories.Impl.DetailRepository;
import com.example.servlet_shopbb.repositories.Impl.ProductRepository;
import com.example.servlet_shopbb.service.CartService;
import com.example.servlet_shopbb.viewmodel.ProductView;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
//        System.out.println(new ProductService().getProductsAll());
//        System.out.println(new ProductRepository().getLstProducts());
//        List<ProductView> pro = new ArrayList<>();
//        pro = new ProductRepository().getLstProducts();
//        for (ProductView view : pro) {
//            System.out.println(view);
//        }
//        System.out.println();
//        System.out.println(new DetailRepository().getDetailProducts(2));

        System.out.println(new CartService().getCartHD(1));
    }


}
