<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/07/2023
  Time: 3:30 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <title>Admin Dashboard</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.1/js/bootstrap.min.js"
        integrity="sha512-fHY2UiQlipUq0dEabSM4s+phmn+bcxSYzXP4vAXItBvBHU7zAM/mkhCZjtBEIJexhOMzZbgFlPLuErlJF2b+0g=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/apexcharts/3.35.3/apexcharts.min.js"></script>

    <!-- Montserrat Font -->
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

    <!-- Material Icons -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined" rel="stylesheet">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="/admin/css/styles.css">
  </head>
  <body>
<!-- Main -->
<main class="main-container">
    <div class="main-title">
        <p class="font-weight-bold">Manage User</p>
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
                    <form action="/admin/staff/add" method="post">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="">User</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <div class="mb-3">
                                    <label class="form-label">Tên</label>
                                    <input type="text" class="form-control" name="ten">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Tài Khoản</label>
                                    <input type="text" class="form-control" name="taiKhoan">
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Vai Trò</label>
                                   <div>
                                       <select class="form-select" aria-label="Default select example" name="vaiTro">
                                           <c:forEach var="vt" items="${lstVt}">
                                               <option value="${vt.id}">${vt.ten}</option>
                                           </c:forEach>

                                       </select>
                                   </div>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Mật Khẩu</label>
                                    <input type="text" class="form-control" name="matKhau">
                                </div>

                                <div class="mb-3">
                                    <label class="form-label">Ngày Sinh</label>
                                    <input type="date" class="form-control" name="ngaySinh">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Giới Tính</label>
                                    <div style="display: flex;">
                                        <div class="form-check">
                                            <input class="form-check-input" type="radio" name="gioiTinh" value="1" checked>
                                            <label class="form-check-label" >
                                                Nam
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" type="radio" name="gioiTinh" value="2">
                                            <label class="form-check-label" >
                                                Nữ
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Email</label>
                                    <input type="email" class="form-control" name="email">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Sdt</label>
                                    <input type="number" class="form-control" name="sdt">
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Địa Chỉ</label>
                                    <input type="text" class="form-control" name="diaChi">
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
                    <th scope="col">Tài Khoản</th>
                    <th scope="col">Vai Trò</th>
                    <th scope="col">Ngày Sinh</th>
                    <th scope="col">Giới Tính</th>
                    <th scope="col">Email</th>
                    <th scope="col">Sdt</th>
                    <th scope="col">Địa Chỉ</th>
                    <th scope="col">Trạng Thái</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${lstUser}">
                    <tr>
                        <td scope="row">${user.id}</td>
                        <td>${user.ten}</td>
                        <td>${user.taiKhoan}</td>
                        <td>${user.idVT.ten}</td>
                        <td>${user.ngaySinh}</td>
                        <td>${user.gioiTinh== 1?"Nam":"Nữ"}</td>
                        <td>${user.email}</td>
                        <td>${user.sdt}</td>
                        <td>${user.diaChi}</td>
                        <td>${user.trangThai==1?"Đang On":"Đang Off"}</td>
                        <td>
                            <div class="table_action">
                                <!-- Button trigger modal -->
                                <a type="button" data-bs-toggle="modal" data-bs-target="#exampleModal${user.id}"
                                   class="box_btn-product"><i class="fa-solid fa-pen"></i></a>

                                <a href="/admin/staff/delete?id=${user.id}" class="box_btn-product"><i
                                        class="fa-solid fa-trash"></i></a>
                            </div>
                        </td>
                        <!-- Modal -->
                        <div class="modal fade" id="exampleModal${user.id}" tabindex="-1"
                             aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <form method="POST" action="/admin/staff/update?id=${user.id}">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="exampleModalLabel">Color</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="mb-3">
                                                <label class="form-label">Tên</label>
                                                <input type="text" class="form-control" name="ten" value="${user.ten}">
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">Tài Khoản</label>
                                                <input type="text" class="form-control" name="taiKhoan" value="${user.taiKhoan}">
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">Vai Trò</label>
                                                <div>
                                                    <select class="form-select" aria-label="Default select example" name="vaiTro">
                                                        <c:forEach var="vt" items="${lstVt}">
                                                            <option value="${vt.id}" ${user.idVT.id ==vt.id ?"selected":""} >${vt.ten}</option>
                                                        </c:forEach>

                                                    </select>
                                                </div>
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">Mật Khẩu</label>
                                                <input type="text" class="form-control" name="matKhau" value="${user.matKhau}">
                                            </div>

                                            <div class="mb-3">
                                                <label class="form-label">Ngày Sinh</label>
                                                <input type="date" class="form-control" name="ngaySinh" value="${user.ngaySinh}">
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">Giới Tính</label>
                                                <div style="display: flex;">
                                                    <div class="form-check">
                                                        <input class="form-check-input" type="radio" name="gioiTinh" value="1"  ${user.gioiTinh==1?"checked":""}>
                                                        <label class="form-check-label" >
                                                            Nam
                                                        </label>
                                                    </div>
                                                    <div class="form-check">
                                                        <input class="form-check-input" type="radio" name="gioiTinh" value="2" ${user.gioiTinh==2?"checked":""}>
                                                        <label class="form-check-label" >
                                                            Nữ
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">Email</label>
                                                <input type="email" class="form-control" name="email" value="${user.email}">
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">Sdt</label>
                                                <input type="number" class="form-control" name="sdt" value="${user.sdt}">
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">Địa Chỉ</label>
                                                <input type="text" class="form-control" name="diaChi" value="${user.diaChi}">
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">Tình Trạng</label>
                                                <select class="form-select" aria-label="Default select example" name="trangThai">
                                                    <option value="1" selected ${user.trangThai ==1?"selected":""}>Đang On</option>
                                                    <option value="2" ${user.trangThai ==2?"selected":""} >Đang Off</option>
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
</body>
</html>