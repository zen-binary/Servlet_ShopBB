<%-- Created by IntelliJ IDEA. User: Admin Date: 31/07/2023 Time: 3:30 CH To
change this template use File | Settings | File Templates. --%> <%@ page
contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

    <!-- Main -->
    <main class="main-container">
      <div class="main-title">
        <p class="font-weight-bold">Manage Oder</p>
      </div>

      <div class="main-product">
        <div class="box_product-body">
          <table class="table">
            <thead>
              <tr>
                <th scope="col">ID</th>
                <th scope="col">Khach Hàng</th>
                <th scope="col">Ngày Tạo</th>
                <th scope="col">Trạng Thái</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="hd" items="${lstHd}">
                <tr>
                  <td scope="row">${hd.id}</td>
                  <td>${hd.nguoiDung==null?"Khách Lẻ":hd.nguoiDung.ten}</td>
                  <td>${hd.ngayTao}</td>
                  <td>${hd.trangThai==1?"Đang Chờ Xác nhận":hd.trangThai == 2?"Xác Nhận Thành Công":"Đã Hủy"}</td>
                  <td>
                    <div class="table_action">
                    <a href="/admin/oder/detail?id=${hd.id}"class="box_btn-product">
                      <i class="fa-solid fa-eye"></i>
                    </a>
                    <a href="/admin/oder/confirm?id=${hd.id}"class="box_btn-product">
                      <i class="fa-solid fa-check"></i>
                    </a>
                    <a href="/admin/oder/remove?id=${hd.id}"class="box_btn-product">
                      <i class="fa-solid fa-xmark"></i>
                    </a>
                    </div>
                  </td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </main>
    <!-- End Main -->
