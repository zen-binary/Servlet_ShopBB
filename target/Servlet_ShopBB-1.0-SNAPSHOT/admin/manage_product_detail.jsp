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
                <div class="product_info-img">
                    <img src="../../img/product/${sp.hinhAnh}" alt="" style="width: 200px; height: 160px;">
                </div>
                <div class="product_info-box">
                    <div class="product-tile">
                        ${sp.ten}
                    </div>
                    <div class="product-dec">
                        Mô Tả: <span>${sp.moTa}</span>
                    </div>
                    <div class="product-category">
                        Loại: <span>${sp.loai}</span>
                    </div>
                </div>

            </div>

            <div class="box_product-btn">

                <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    <i class="fa-solid fa-plus"></i> New
                </button>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <form action="/admin/product/detail/add?id=${sp.id}" method="post" enctype="multipart/form-data">

                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h1 class="modal-title fs-5">Product Detail</h1>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label class="form-label">Hình Ảnh</label>
                                        <input type="file" class="form-control" name="hinhAnh">
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label">Màu Sắc</label>
                                        <select class="form-select" aria-label="Default select example" name="mauSac">
                                            <c:forEach var="ms" items="${lstMs}">
                                                <option value="${ms.id}">${ms}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label">Kích Thước</label>
                                        <select class="form-select" aria-label="Default select example"
                                                name="kichThuoc">
                                            <c:forEach var="kt" items="${lstKt}">
                                                <option value="${kt.id}">${kt}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <div class="mb-3">
                                        <label class="form-label">Số Lượng</label>
                                        <input type="number" class="form-control" name="soLuong">
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label">Giá Nhập</label>
                                        <input type="number" class="form-control" name="giaNhap">
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label">Giá Bán</label>
                                        <input type="number" class="form-control" name="giaBan">
                                    </div>

                                    <div class="mb-3">
                                        <label class="form-label">Tình Trạng</label>
                                        <select class="form-select" aria-label="Default select example" name="trangThai">
                                            <option value="1">Đang On</option>
                                            <option value="0">Đang Off</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                                    </button>
                                    <button type="submit" class="btn btn-primary">Save</button>
                                </div>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </div>
        <div class="box_product-body">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Hình Ảnh</th>
                    <th scope="col">Màu Sắc</th>
                    <th scope="col">Kích Thước</th>
                    <th scope="col">Số Lượng</th>
                    <th scope="col">Giá Bán</th>
                    <th scope="col">Giá Nhập</th>
                    <th scope="col">Tình Trạng</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="detail" items="${lstDetail}">

                    <tr>
                        <td scope="row">${detail.id}</td>
                        <td>
                            <img src="../../img/product/${detail.hinhAnh}" alt="" style="width: 100px; height: 80px; ">
                        </td>

                        <td>${detail.mauSac}</td>
                        <td>${detail.kichThuoc}</td>
                        <td>${detail.soLuongTon}</td>
                        <td>${detail.giaNhap}</td>
                        <td>${detail.giaBan}</td>
                        <td>${detail.trangThai == 1?"Đang On":"Đang Off"}</td>
                        <td>
                            <div class="table_action">
                                <!-- Button trigger modal -->
                                <a type="button" data-bs-toggle="modal" data-bs-target="#exampleModal${detail.id}"
                                   class="box_btn-product"><i class="fa-solid fa-pen"></i></a>

                                <a href="/admin/product/detail/delete?id=${detail.id}" class="box_btn-product"><i
                                        class="fa-solid fa-trash"></i></a>
                            </div>
                        </td>
                        <!-- Modal -->
                        <div class="modal fade" id="exampleModal${detail.id}" tabindex="-1"
                             aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <form action="/admin/product/detail/update?id=${detail.id}" enctype="multipart/form-data" method="post">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabel">Product Details ${detail.id}</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="mb-3">
                                                <label class="form-label">Hình Ảnh</label>
                                                <input type="file" class="form-control" name="hinhAnh">
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">Màu Sắc</label>
                                                <select class="form-select" aria-label="Default select example" name="mauSac">
                                                    <c:forEach var="ms" items="${lstMs}">
                                                        <option value="${ms.id}" ${detail.mauSac.id == ms.id?"selected":""}>${ms}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">Kích Thước</label>
                                                <select class="form-select" aria-label="Default select example" name="kichThuoc">
                                                    <c:forEach var="kt" items="${lstKt}">
                                                        <option value="${kt.id}"  ${detail.kichThuoc.id == kt.id?"selected":""}>${kt}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>

                                            <div class="mb-3">
                                                <label class="form-label">Số Lượng</label>
                                                <input type="number" class="form-control" name="soLuong" value="${detail.soLuongTon}">
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">Giá Nhập</label>
                                                <input type="number" class="form-control" name="giaNhap"
                                                       value="${detail.giaNhap}">
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">Giá Bán</label>
                                                <input type="number" class="form-control" name="giaBan" value="${detail.giaBan}">
                                            </div>

                                            <div class="mb-3">
                                                <label class="form-label">Tình Trạng</label>
                                                <select class="form-select" aria-label="Default select example" name="trangThai">
                                                    <option value="1" ${detail.trangThai == 1?"selected":""} >Đang On</option>
                                                    <option value="0" ${detail.trangThai == 0?"selected":""} >Đang Off</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary"
                                                    data-bs-dismiss="modal">Close
                                            </button>
                                            <button type="submit" class="btn btn-primary">Update</button>
                                        </div>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
</main>
<!-- End Main -->
