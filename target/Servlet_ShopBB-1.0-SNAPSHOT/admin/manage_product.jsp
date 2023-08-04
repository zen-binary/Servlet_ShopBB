<!-- <%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/07/2023
  Time: 3:30 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!-- Main -->
    <main class="main-container">
        <div class="main-title">
            <p class="font-weight-bold">Manage Products</p>
        </div>

        <div class="main-product">
            <div class="box_product-add">
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    <i class="fa-solid fa-plus"></i> New
                </button>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                    aria-hidden="true">
                    <div class="modal-dialog">
                        <form action="/admin/product/add" method="post" enctype="multipart/form-data">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="exampleModalLabel">Product</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                    <div class="mb-3">
                                        <label class="form-label">Tên Sản Phẩm</label>
                                        <input type="text" class="form-control" name="ten">
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label">Hình Ảnh</label>
                                        <input type="file" class="form-control" name="hinhAnh">
                                    </div>
                                    <div class="mb-3">
                                    <label class="form-label">Loại</label>
                                        <select class="form-select" aria-label="Default select example" name="loai">
                                            <c:forEach var="loai" items="${lstLoai}">
                                                <option value="${loai.id}">${loai}</option>
                                            </c:forEach>

                                        </select>
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label">Mô Tả</label>
                                        <textarea class="form-control" rows="3" name="moTa"></textarea>
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label">Tình Trạng</label>
                                        <select class="form-select" aria-label="Default select example" name="trangThai">
                                            <option value="1" selected>Đang On</option>
                                            <option value="2">Đang Off</option>
                                        </select>
                                    </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary">Save</button>
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
                            <th scope="col">Tên</th>
                            <th scope="col">Hình Ảnh</th>
                            <th scope="col">Loại</th>
                            <th scope="col">Trạng Thái</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${lstSp}" var="sp">

                        <tr>
                            <td scope="row">${sp.id}</td>
                            <td>${sp.ten}</td>
                            <td><img src="../../img/product/${sp.hinhAnh}" alt="" style="width: 100px; height: 80px; "></td>

                            <td>
                                ${sp.loai}
                            </td>
                            <td>${sp.trangThai==1?"Đang On":"Đang Off"}</td>
                            <td>
                                <div class="table_action">

                                    <a href="/admin/product/detail?id=${sp.id}" class="box_btn-product"><i
                                            class="fa-sharp fa-solid fa-plus"></i></a>

                                    <!-- Button trigger modal -->
                                    <a type="button" data-bs-toggle="modal" data-bs-target="#exampleModal${sp.id}"
                                        class="box_btn-product"><i class="fa-solid fa-pen"></i></a>

                                    <a href="/admin/product/delete?id=${sp.id}" class="box_btn-product"><i
                                            class="fa-solid fa-trash"></i></a>
                                </div>
                            </td>
                            <!-- Modal -->
                            <div class="modal fade" id="exampleModal${sp.id}" tabindex="-1"
                                aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <form action="/admin/product/update?id=${sp.id}" method="post" enctype="multipart/form-data">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h1 class="modal-title fs-5" id="exampleModalLabels">Product</h1>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                <div class="mb-3">
                                                    <label class="form-label">Tên Sản Phẩm</label>
                                                    <input type="text" class="form-control" name="ten" value="${sp.ten}">
                                                </div>
                                                <div class="mb-3">
                                                    <label class="form-label">Hình Ảnh</label>
                                                    <input type="file" class="form-control" name="hinhAnh">
                                                </div>
                                                <div class="mb-3">
                                                    <label class="form-label">Loại</label>
                                                    <select class="form-select" aria-label="Default select example" name="loai">
                                                        <c:forEach var="loai" items="${lstLoai}">
                                                            <option value="${loai.id}"  ${sp.loai.id == loai.id?"selected":""} >${loai}</option>
                                                        </c:forEach>

                                                    </select>
                                                </div>
                                                <div class="mb-3">
                                                    <label class="form-label">Mô Tả</label>
                                                    <textarea class="form-control" rows="3" name="moTa" >${sp.moTa}</textarea>
                                                </div>
                                                <div class="mb-3">
                                                    <label class="form-label">Tình Trạng</label>
                                                    <select class="form-select" aria-label="Default select example" name="trangThai">
                                                        <option value="1"  ${sp.trangThai == 1?"selected":""}>Đang On</option>
                                                        <option value="2" ${sp.trangThai == 2?"selected":""}>Đang Off</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                <button type="submit" class="btn btn-primary">Save</button>
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
