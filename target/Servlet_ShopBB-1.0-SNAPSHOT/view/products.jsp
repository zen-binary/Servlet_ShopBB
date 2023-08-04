<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14/07/2023
  Time: 1:44 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>
  <div class="main_contaner">

    <div class="box_headerpro-link">
      <a href="">Home</a> /
      <a href="">Product</a>
    </div>
    <div class="box_headerpro">
      <div class="box_headerpro-tile">
        <h4>Product</h4>
        <span>100</span>
      </div>
      <div class="box_headerpro-find">
        <select class="form-select" aria-label="Default select example">
          <option selected>Open this select menu</option>
          <option value="1">One</option>
          <option value="2">Two</option>
          <option value="3">Three</option>
        </select>
      </div>
    </div>

    <div class="box_bodypro row">
        <div class="box_bodypro-find col-2">
          <h5><i class="fa-solid fa-list-ul"></i> Tất cả Danh mục</h5>
          <div class="box_find">
            <div class="box_find-tile find1" id="find1">
              Loại
            </div>
            <div class="box_find-body">
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" >
                <label class="form-check-label" for="flexCheckDefault">
                  Default checkbox
                </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="checkbox" value=""   checked>
                <label class="form-check-label"  >
                  Checked checkbox
                </label>
              </div>
            </div>
            
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
              <label class="form-check-label" for="flexCheckDefault">
                Default checkbox
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input" type="checkbox" value=""   checked>
              <label class="form-check-label"  >
                Checked checkbox
              </label>
            </div>
          </div>
        </div>
        <div class="box_bodypro-product col-10  row">

          <c:forEach var="pro" items="${lstProduct}">
                  <div class="products col-3">
                      <a  href="/details?id=${pro.id}" style="text-decoration: none; color: black">
                      <div class="product_img">
                          <img src="/img/product/${pro.hinhAnh}" alt="">
                      </div>
                      <div class="product_tile">
                              ${pro.ten}
                      </div>
                      <div class="product_star">
                          <div>
                              <i class="fa-solid fa-star"></i>
                          </div>
                          <div>
                              <i class="fa-solid fa-star"></i>
                          </div>
                          <div>
                              <i class="fa-solid fa-star"></i>
                          </div>
                          <div>
                              <i class="fa-solid fa-star"></i>
                          </div>
                      </div>
                      <div class="product_picesold">
                          <div class="product_picesold-pice">
                               Giá: ${pro.giaMin} - ${pro.giaMax}
                          </div>
                          <div class="product_picesold-sold">
                                 Số Lượng Bán: ${pro.soLuongBan}
                          </div>
                      </div>
                      </a>
                  </div>
          </c:forEach>


        </div>
    </div>

  </div>
  <script src="../js/main.js"></script>
</body>
</html>


