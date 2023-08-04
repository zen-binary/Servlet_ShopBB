<!-- <%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/07/2023
  Time: 3:30 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Main -->
<main class="main-container">
    <div class="main-title">
        <p class="font-weight-bold">Manage Products Details</p>
    </div>

    <div class="main-product">
        <div class="box_product-add">
            <div class="box_product-info">
                
                <div class="product_info-box" style="width: 100%;">
                    <div class="product-tile">
                        Hóa Đơn: ${hd.id}
                    </div>
                    <div style="display: flex; width: 100%; justify-content: space-between">
                        <div >
                            <div class="product-dec">
                                Người Dùng: <span>${hd.nguoiDung.ten}</span>
                             </div>
                             <div class="product-dec">
                                Ngày Tạo: <span>${hd.ngayTao}</span>
                             </div>
                        </div>

                        <div >
                            <div class="product-dec">
                                Tên Người Nhận: <span>${hd.tenNguoiNhan}</span>
                             </div>
                             <div class="product-dec">
                                Số Điện Thoại: <span>${hd.sdt}</span>
                             </div>
                        </div>

                        <div >
                            <div class="product-dec">
                                Email: <span>${hd.email}</span>
                             </div>
                             <div class="product-dec">
                                Địa Chỉ: <span>${hd.diaChi}</span>
                             </div>
                        </div>
                        <div >
                            <div class="product-dec">
                                Ngày Ship: <span>${hd.ngayShip}</span>
                             </div>
                             <div class="product-dec">
                                Ngày Nhận: <span>${hd.ngayNhan}</span>
                             </div>
                        </div>

                        <div >
                            <div class="product-dec">
                                Ngày Thanh Toán: <span>${hd.ngayThanhToan}</span>
                             </div>
                             <div class="product-dec">
                                Trạng Thái: <span>${hd.trangThai}</span>
                             </div>
                        </div>
                    </div>

                    
                    
                </div>

            </div>

        </div>
        <div class="box_product-body">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Hình Ảnh</th>
                    <th scope="col">Sản Phẩm</th>
                    <th scope="col">Màu Sắc</th>
                    <th scope="col">Kích Thước</th>
                    <th scope="col">Số Lượng</th>
                    <th scope="col">Đơn Giá</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach var="hdct" items="${lstHdct}">

                    <tr>
                        <td scope="row">${hdct.id}</td>
                        <td>
                            <img src="../../img/product/${hdct.chiTietSanPham.sanPham.hinhAnh}" alt="" style="width: 100px; height: 80px; ">
                        </td>
                        <td>${hdct.chiTietSanPham.sanPham}</td>
                        <td>${hdct.chiTietSanPham.mauSac}</td>
                        <td>${hdct.chiTietSanPham.kichThuoc}</td>
                        <td>${hdct.soLuong}</td>
                        <td>${hdct.donGia}</td>

                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</main>
<!-- End Main -->

