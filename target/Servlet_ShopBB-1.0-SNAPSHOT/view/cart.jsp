<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div class="main_contaner">
        <div class="box_cart-link">
            <a href="">Home</a> /
            <a href="">Cart</a>
        </div>

        <div class="box_cart">
            <div class="box_cart-tile " >
                <div class="cart_tile row">
                    <div class="cart_tile-product col-5">
                        Sản Phẩm
                    </div>
                    <div class="cart_tile-quantity col-2">
                        Pice
                    </div>
                    <div class="cart_tile-quantity col-2">
                        Quantity
                    </div>
                    <div class="cart_tile-total col-2">
                        Total
                    </div>
                    <div class="cart_tile-total col-1">
                        Action
                    </div>
                </div>


            </div>

            <div class="box_cart-body">
                <c:forEach var="product" items="${lstCart}">

                <div class="cart_body row">
                    <div class="cart_body-product col-5">
                        <div class="body_product-img">
                            <img src="/img/product/${product.chiTietSanPham.sanPham.hinhAnh}" alt="" style="width: 100px; height: 100px;" >
                        </div>
                        <div class="body_product-tile">
                            <div class="product_tile-name">
                                ${product.chiTietSanPham.sanPham}
                            </div>
                            <div class="product_tile-tyle">
                                Màu Sắc: ${product.chiTietSanPham.mauSac} <br>
                                Size: ${product.chiTietSanPham.kichThuoc}
                            </div>

                        </div>
                    </div>
                    <div class="cart_body-pice col-2">
                            ${product.donGia}
                    </div>
                    <div class="cart_body-quantity col-2">
                        <form method="post" action="/cart/update?id=${product.id}" >
                        <div class="box_quantity" >
                            <input type="button" class="inputBo" value="-" onclick="giamSluong(this)">
                            <input name="quantity" type="number" min="1" value="${product.soLuong}" class="input_quantity" onblur="this.form.submit()">
                            <input type="button" class="inputThem" value="+" onclick="tangSluong(this)">
                        </div>
                        </form>
                    </div>
                    <div class="cart_body-total col-2">
                            ${product.donGia * product.soLuong}
                    </div>
                    <div class="cart_body-total col-1">
                        <a href="/cart/delete?id=${product.id}" class="btn btn-danger">Xóa</a>
                    </div>
                </div>
                </c:forEach>
            </div>


            <div class="box_cart-footer row">
                    <div>
                        Tổng Tiền: ${tongTien}
                    </div>


            </div>

        </div>

        <div class="box_cart-address">
            <form action="/cart/pay" method="post" >

            <div class="cart_address-tile col-8">
                Địa Chỉ Nhận Hàng
            </div>
            <div class="row">
            <div class="cart_address col-8">
                    <div class="col-12">
                      <label class="form-label">Họ Và Tên</label>
                      <input type="text" class="form-control" placeholder="Họ Và Tên" name="ten">
                    </div>
                    <div class="col-12">
                      <label  class="form-label">Số Điện Thoại</label>
                      <input type="text" class="form-control" placeholder="SDT" name="sdt">
                    </div>
                    <div class="col-12">
                        <label  class="form-label">Email</label>
                        <input type="email" class="form-control" placeholder="Email" name="email">
                    </div>
                    <div class="col-12">
                        <label  class="form-label">Địa Chỉ</label>
                        <input type="text" class="form-control" placeholder="Địa Chỉ" name="diaChi">
                    </div>
            </div>
            <div class="cart_pay col-4">
                <div class="cart_pay-tile">
                    Thông tin Thanh Toán
                </div>
                <div class="cart_pay-box">
                    <div class="pay_box-tile">
                        Tiền Hàng:
                    </div>
                    <div class="pay_box-conten">
                        ${tongTien}
                    </div>
                </div>

                <div class="cart_pay-box">
                    <div class="pay_box-tile">
                        Phí Vận Chuyển:
                    </div>
                    <div class="pay_box-conten">
                        0
                    </div>
                </div>

                <div class="cart_pay-box">
                    <div class="pay_box-tile">
                        Giảm Giá:
                    </div>
                    <div class="pay_box-conten">
                        0
                    </div>
                </div>

                <div class="cart_pay-box">
                    <div class="pay_box-tile">
                       TỔng số Tiền:
                    </div>
                    <div class="pay_box-conten">
                        ${tongTien}
                    </div>
                </div>

                <div class="buy_btn">
                    <button type="submit" class="btn btn-primary col-12">Thanh Toán</button>
                </div>
            </div>
            </div>

            </form>
        </div>

    </div>
    <script>

        // Đoạn mã JavaScript
        function giamSluong(event) {
            const inputQuantity = event.parentElement.querySelector('input[name="quantity"]');
            if (inputQuantity.value > 1) {
                inputQuantity.value = parseInt(inputQuantity.value) - 1;
                inputQuantity.closest('form').submit();
            }
        }

        function tangSluong(event) {
            const inputQuantity = event.parentElement.querySelector('input[name="quantity"]');
            inputQuantity.value = parseInt(inputQuantity.value) + 1;
            inputQuantity.closest('form').submit();
        }

    </script>
