<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/07/2023
  Time: 3:59 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <link rel="stylesheet" href="../css/main.css">


    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.1/js/bootstrap.min.js"
            integrity="sha512-fHY2UiQlipUq0dEabSM4s+phmn+bcxSYzXP4vAXItBvBHU7zAM/mkhCZjtBEIJexhOMzZbgFlPLuErlJF2b+0g=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/apexcharts/3.35.3/apexcharts.min.js"></script>

    <!-- Montserrat Font -->
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

    <!-- Material Icons -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined" rel="stylesheet">

</head>
<body>
<div class="mains ">

    <header>
        <div class="main_contaner">
            <div class="header_help">
                <ul>
                    <li>Help</li>
                    <li>Order Tracker</li>
                    <li>About Us</li>
                    <li>Newsletter Signup</li>
                </ul>
            </div>
            <div class="header_box row">
                <div class="header_box-logo col-3">
                    <img src="img/LOGO.png" alt="">
                </div>
                <div class="header_box-search col-6">

                    <div class="input-group mb-3">
                        <input type="text" class="form-control" placeholder="Tìm Kiếm">
                        <button class="btn btn-primary" type="button" id="button-addon2">Button</button>
                    </div>
                </div>
                <div class="header_box-profile col-3">
                    <c:if test="${empty nd}">
                        <div class="box_profile">
                            <div class="box_profile-login">
                                <a href="/login">Login</a>
                            </div>
                        </div>
                    </c:if>

                    <c:if test="${not empty nd}">
                        <div class="box_profile">
                            <div class="box_profile-login">
                                <a type="button" class="profile_user"><i class="fa-solid fa-user"></i></a>
                                <ul class="memu_profile hide">
                                    <li><a href="/profile"><i class="fa-solid fa-user"></i> My account</a></li>
                                    <c:if test="${nd.idVT != null}">
                                    <li><a href="/admin"><i class="fa-solid fa-wrench"></i> Admin</a></li>
                                    </c:if>

                                    <li><a href="/logout"><i class="fa-solid fa-right-from-bracket"></i> Đăng Xuất</a>
                                    </li>
                                </ul>

                            </div>
                        </div>
                    </c:if>

                    <div class="box_profile">
                        <div class="box_profile-login">
                            <a href=""><i class="fa-solid fa-heart"></i></a>
                        </div>
                    </div>
                    <div class="box_profile">
                        <div class="box_profile-login position-relative">
                            <a href="/cart">
                                <i class="fa-solid fa-cart-shopping"> </i>
                                <div class="bg-danger cart_quantity"><span>${countCart}</span></div>
                            </a>

                        </div>
                    </div>


                </div>
            </div>
        </div>
    </header>
    <nav class="navbar navbar-expand-lg bg-body-tertiary main_contaner">
        <div class="container-fluid">

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/home">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/products">Products</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/oder">Oder</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">HomeHome</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">HomeHome</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">HomeHome</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">HomeHome</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">HomeHome</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="header_line">

    </div>

    <jsp:include page="${ view }"></jsp:include>


    <footer>
        <div class="main_contaner">
            <div class="box_footer row ">
                <div class="box_footer-logo col-5">
                    <img src="img/LOGO.png" alt="">
                </div>
                <div class="box_footer-link col-7 row">
                    <div class="footer_link col-4">
                        <ul>
                            <li><h4>Our Company</h4></li>
                            <li>About Us</li>
                            <li>Careers</li>
                            <li>Contact</li>
                            <li>Store locations</li>
                        </ul>
                    </div>

                    <div class="footer_link col-4">
                        <ul>
                            <li><h4>Our Company</h4></li>
                            <li>About Us</li>
                            <li>Careers</li>
                            <li>Contact</li>
                            <li>Store locations</li>
                        </ul>
                    </div>

                    <div class="footer_link col-4">
                        <ul>
                            <li><h4>Our Company</h4></li>
                            <li>About Us</li>
                            <li>Careers</li>
                            <li>Contact</li>
                            <li>Store locations</li>
                        </ul>
                    </div>

                </div>
            </div>
        </div>
    </footer>

</div>


<script>
    var profile_user = document.querySelector('.profile_user');
    var memu_profile = document.querySelector('.memu_profile');
    var checkprofile_user = false;
    profile_user.addEventListener('click', function (event) {
        if (memu_profile.classList.contains('hide')) {
            memu_profile.classList.remove('hide');
        } else {
            memu_profile.classList.add('hide');
        }
    })
</script>
</body>
</html>
