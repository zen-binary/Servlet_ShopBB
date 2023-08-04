<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="main_contaner">
        <div class="box_cart-link">
            <a href="">Home</a> /
            <a href="">oder</a>
        </div>

        <div class="box_cart">
            <div class="box_cart-tile " >
                <div class="cart_tile row">
                    <div class="cart_tile-product col-3">
                        Id
                    </div>
                    <div class="cart_tile-quantity col-3">
                        Ngày Tạo
                    </div>
                    <div class="cart_tile-quantity col-3">
                        Trạng Thái
                    </div>
                    <div class="cart_tile-total col-3">
                        Action
                    </div>
                </div>


            </div>

            <div class="box_cart-body">
                <c:forEach var="hd" items="${lstHd}">

                <div class="cart_body row">
                    <div class="cart_body-pice col-3">
                        ${hd.id}
                    </div>
                    <div class="cart_body-quantity col-3">
                            ${hd.ngayTao}

                    </div>
                    <div class="cart_body-total col-3">
                            ${hd.trangThai == 1?"Đang Chờ Xác Nhận":hd.trangThai == 2?"Đã Xác Nhận":"Đã Hủy"}

                    </div>
                    <div class="cart_body-total col-3">
                            <a class="btn btn-primary" href=""><i class="fa-solid fa-pen"></i></a>
                    </div>
                </div>
                </c:forEach>
            </div>

        </div>
    </div>
