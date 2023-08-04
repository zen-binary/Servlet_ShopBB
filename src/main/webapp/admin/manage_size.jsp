<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/07/2023
  Time: 3:30 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Main -->
<main class="main-container">
    <div class="main-title">
        <p class="font-weight-bold">Manage size</p>
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
                    <form action="/admin/size/add" method="post">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="">size</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form action="">
                                    <div class="mb-3">
                                        <label class="form-label">size Name</label>
                                        <input type="text" class="form-control" name="ten">
                                    </div>

                                    <div class="mb-3">
                                        <label class="form-label">Tình Trạng</label>
                                        <select class="form-select" aria-label="Default select example" name="trangThai">
                                            <option value="1" selected>Đang On</option>
                                            <option value="2">Đang Off</option>
                                        </select>
                                    </div>
                                </form>
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
                    <th scope="col">Trạng Thái</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="size" items="${lstSize}">
                    <tr>
                        <td scope="row">${size.id}</td>
                        <td>${size.ten}</td>
                        <td>${size.trangThai==1?"Đang On":"Đang Off"}</td>
                        <td>
                            <div class="table_action">
                                <!-- Button trigger modal -->
                                <a type="button" data-bs-toggle="modal" data-bs-target="#exampleModal${size.id}"
                                   class="box_btn-product"><i class="fa-solid fa-pen"></i></a>

                                <a href="/admin/size/delete?id=${size.id}" class="box_btn-product"><i
                                        class="fa-solid fa-trash"></i></a>
                            </div>
                        </td>
                        <!-- Modal -->
                        <div class="modal fade" id="exampleModal${size.id}" tabindex="-1"
                             aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <form method="POST" action="/admin/size/update?id=${size.id}">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabel">size</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">

                                            <div class="mb-3">
                                                <label class="form-label">ID</label>
                                                <input type="text" class="form-control" value="${size.id}" name="id" disabled>
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">size Name</label>
                                                <input type="text" class="form-control" value="${size.ten}" name="ten">
                                            </div>

                                            <div class="mb-3">
                                                <label class="form-label">Trạng Thái</label>
                                                <select class="form-select" aria-label="Default select example" name="trangThai">
                                                    <option value="1" ${size.trangThai == 1?"selected":""} >Đang On</option>
                                                    <option value="2" ${size.trangThai == 2?"selected":""}>Đang Off</option>
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
