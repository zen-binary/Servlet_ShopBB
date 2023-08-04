<!-- <%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/07/2023
  Time: 1:44 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
          integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
          integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/main.css">

</head>
<body>
<div class="main_contaner">

    <div class="box_headerpro-link">
        <a href="">Home</a> /
        <a href="">Product</a>
    </div>
    <div class="box_product-detail row">
        <div class="product_detail-img col-7">
            <img src="/img/product/${image}" alt="" style="width: 100%;height: 480px">
        </div>
        <div class="product_detail-info col-5">
            <div class="detail_info-tile">
                ${lstDetailPro.get(0).sanPham}
            </div>
            <div class="detail_info-desc">
                ${lstDetailPro.get(0).sanPham.moTa}
            </div>
            <div class="detail_info-piceqantity">

            <div class="detail_info-pice">
                <div>Giá:</div>
                <div class="pice">${lstDetailPro.get(0).giaBan} đ</div>
            </div>
            <div class="detail_info-quantity">
                <div>Số Lượng Bán: </div>
                <div class="quantity">${lstDetailPro.get(0).soLuongBan}</div>
            </div>
        </div>

            <form method="get" action="/detail?id=${lstDetailPro.get(0).id}&">
                <form method="get" action="/detail">
                <input type="hidden" name="id" value="${lstDetailPro.get(0).sanPham.id}">
            <div class="detail_info-radio">
                <div class="radio_tile">
                    Màu Sắc:
                </div>

                <div class="radio_box-groud">
                    <div class="radio_box">
                        <c:forEach var="colors" items="${lstMS}">
                        <label onchange="this.form.submit()">
                            <input class="single-checkbox" type="checkbox" name="color" value="${colors.id}" ${colors.id == color?"checked":""}>
                            <span>${colors}</span>
                        </label>
                        </c:forEach>
                    </div>

                </div>

            </div>

            <div class="detail_info-radio">
                <div class="radio_tile">
                    Size:
                </div>
                <div class="radio_box-groud">
                    <div class="radio_box">
                        <c:forEach var="sizes" items="${lstKt}">
                        <label onchange="this.form.submit()" >
                            <input class="single-checkbox2" type="checkbox" name="size" value="${sizes.id}" ${sizes.id == size?"checked":""} >
                            <span>${sizes}</span>
                        </label>
                        </c:forEach>

                    </div>

                </div>

            </div>


            <div class="detail_info-quantity">
                <div class="quantity-tile">
                    Số Lượng:
                </div>
                <div class="box_quantity">

                    <input type="button" class="inputBo" value="-">
                    <input name="quantity" type="number" min="1" value="${quantity==nul?"1":quantity}" class="input_quantity" style="appearance: none">
                    <input type="button" class="inputThem" value="+">
                </div>
            </div>

                </form>

            <div class="detail_info-total">
                <div class="total-tile">
                    Sản Phẩm có sẵn:
                </div>
                <div class="box_total">
                    ${lstDetailPro.get(0).soLuongTon}
                </div>
            </div>


            <div class="detail_info-buy">
                <form action="/cart/add?id=${lstDetailPro.get(0).id}" method="post">
                <input type="hidden" name="quantity" class="input_quantity-add" value="${quantity==nul?"1":quantity}">
                <div class="detail_info-buycart">
                    <button type="submit" class="btn btn-outline-secondary" ><i
                            class="fa-sharp fa-solid fa-cart-shopping"></i> Thêm Vào Giỏ Hàng
                    </button>
                </div>

                </form>

                <form action="/cart/buy?id=${lstDetailPro.get(0).id}" method="post">
                    <input type="hidden" name="quantity" class="input_quantity-buy" value="${quantity==nul?"1":quantity}">
                <div class="detail_info-buycart" >
                    <button  type="submit"  class="btn btn-danger btn_box">Mua Ngay</button>
                </div>
                </form>
            </div>


        </div>
    </div>

</div>

<script>
    console.log("aaa")

    console.log("${lstDetailPro.get(0).toString()}");

    var input_quantity = document.querySelector('.input_quantity');
    var input_quantity_add = document.querySelector('.input_quantity-add');
    var input_quantity_buy = document.querySelector('.input_quantity-buy');
    var inputThem = document.querySelector('.inputThem');
    var inputBo = document.querySelector('.inputBo');
    inputThem.addEventListener('click', function () {
        input_quantity.value = parseInt(input_quantity.value) + 1;
        input_quantity_add.value = input_quantity.value;
        input_quantity_buy.value = input_quantity.value;
    })

    inputBo.addEventListener('click', function () {
        if (input_quantity.value > 1) {
            input_quantity.value = parseInt(input_quantity.value) - 1;
            input_quantity_add.value = input_quantity.value;
            input_quantity_buy.value = input_quantity.value;

        }
    })

    const checkboxes = document.querySelectorAll('.single-checkbox');
    console.log(checkboxes)
    checkboxes.forEach(checkbox => {
        checkbox.addEventListener('change', function() {
            if (this.checked) {
                // Nếu checkbox hiện tại được chọn, hủy chọn tất cả các checkbox còn lại
                checkboxes.forEach(cb => {
                    if (cb !== this) {
                        cb.checked = false;
                    }
                });
            }
        });
    });

    const checkboxes2 = document.querySelectorAll('.single-checkbox2');
    console.log(checkboxes2)
    checkboxes2.forEach(checkbox => {
        checkbox.addEventListener('change', function() {
            if (this.checked) {
                // Nếu checkbox hiện tại được chọn, hủy chọn tất cả các checkbox còn lại
                checkboxes2.forEach(cb => {
                    if (cb !== this) {
                        cb.checked = false;
                    }
                });
            }
        });
    });


</script>
</body>
</html>
