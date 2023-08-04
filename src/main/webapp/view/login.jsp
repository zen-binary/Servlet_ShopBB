<!-- <%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/07/2023
  Time: 11:43 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/main.css">

</head>
<body>
  <div class="main">
      <div class="header">
        <div class="header_logo">
          <img src="img/LOGO.png" alt="">
        </div>
        <div class="header_help">
          <a href="">Need help?</a>
        </div>
      </div>
      <div class="box_backgroud">
        
        <div class="box_login">
            <div class="box_login-tile">
              <h3>Login</h3>
              <div class="login_tile-p">
                New to Meow Shop?
                <button  class="btn_login-register">Sign up</button>
              </div>
            </div>

            <div class="box_login-form">
              <form action="/login" method="post">
               <c:if test="${not empty errorMess}">
                   <div class="alert alert-danger" role="alert">
                       ${errorMess}
                   </div>
               </c:if>
              <div class="login-form">
                <input type="text" class="form-control form_control-radius" placeholder="UserName" name="user" value="${user}">
              </div>
              <div class="login-form">
                <input type="password" class="form-control form_control-radius" placeholder="Password" name="pass">
              </div>
              <div class="login-form-btn">
                <button type="submit" class="btn form_control-radius">Login</button>
              </div>
              </form>
            </div>
            <div class="box_register-form hide">
              <form action="/sign-up" method="post">
              <div class="register-form">
                  <div class="login-form">
                      <input type="text" class="form-control form_control-radius" placeholder="Họ Và Tên" name="ten">
                  </div>
                  <div class="row">
                      <div class="login-form col-6">
                          <input type="text" class="form-control form_control-radius" placeholder="UserName" name="taiKhoan">
                      </div>
                      <div class="login-form col-6">
                          <input type="password" class="form-control form_control-radius" placeholder="Password" name="matKhau">
                      </div>
                  </div>
                  <div class="login-form">
                      <input type="date" class="form-control form_control-radius" placeholder="Ngày Sinh" name="ngaySinh">
                  </div>
                  <div class="login-form" style="display: flex">
                      <div class="form-check" style="margin-right: 20px">
                          <input class="form-check-input" type="radio" name="gioiTinh" id="flexRadioDefault1">
                          <label class="form-check-label" for="flexRadioDefault1">
                              Nam
                          </label>
                      </div>
                      <div class="form-check">
                          <input class="form-check-input" type="radio" name="gioiTinh" id="flexRadioDefault2" checked>
                          <label class="form-check-label" for="flexRadioDefault2">
                              Nữ
                          </label>
                      </div>
                  </div>
                  <div class="login-form">
                      <input type="number" class="form-control form_control-radius" placeholder="Số Điện Thoại" name="sdt">
                  </div>
                  <div class="login-form">
                      <input type="email" class="form-control form_control-radius" placeholder="Email" name="email">
                  </div>

                  <div class="login-form">
                      <input type="text" class="form-control form_control-radius" placeholder="Địa Chỉ" name="diaChi">
                  </div>

              </div>
              <div class="login-form-btn">
                <button type="submit" class="btn form_control-radius">Sign-up</button>
              </div>
              </form>
            </div>
            <div class="box_login-forgot">
              <div>Forgot your password?</div>
              <div>Login with phone number</div>
            </div>
            <div class="box_login-line">
              <div>QR</div>
            </div>

            <div class="box_login-fbvagg">
              <div class="login_btn-gg">
                <button type="submit" class="btn btn-outline-primary form_control-radius ">


                  <svg xmlns="http://www.w3.org/2000/svg" width="29" height="28" viewBox="0 0 29 28" fill="none">
                    <path d="M25.9394 11.7151H24.9997V11.6667H14.4997V16.3333H21.0931C20.1312 19.0499 17.5464 21 14.4997 21C10.6339 21 7.49967 17.8658 7.49967 14C7.49967 10.1343 10.6339 7 14.4997 7C16.2841 7 17.9075 7.67317 19.1436 8.77275L22.4435 5.47284C20.3598 3.53092 17.5727 2.33334 14.4997 2.33334C8.05676 2.33334 2.83301 7.55709 2.83301 14C2.83301 20.4429 8.05676 25.6667 14.4997 25.6667C20.9426 25.6667 26.1663 20.4429 26.1663 14C26.1663 13.2178 26.0858 12.4542 25.9394 11.7151Z" fill="#FFC107"/>
                    <path d="M4.17871 8.56975L8.01179 11.3808C9.04896 8.813 11.5608 7 14.5002 7C16.2846 7 17.908 7.67317 19.1441 8.77275L22.444 5.47284C20.3604 3.53092 17.5732 2.33334 14.5002 2.33334C10.019 2.33334 6.13288 4.86325 4.17871 8.56975Z" fill="#FF3D00"/>
                    <path d="M14.4995 25.6667C17.513 25.6667 20.2512 24.5134 22.3214 22.638L18.7106 19.5825C17.4999 20.5032 16.0205 21.0012 14.4995 21C11.465 21 8.88845 19.0651 7.91778 16.3648L4.11328 19.2961C6.04411 23.0743 9.96528 25.6667 14.4995 25.6667Z" fill="#4CAF50"/>
                    <path d="M25.9397 11.7151H25V11.6667H14.5V16.3333H21.0934C20.6333 17.6262 19.8045 18.756 18.7093 19.5831L18.7111 19.5819L22.3219 22.6374C22.0664 22.8696 26.1667 19.8333 26.1667 14C26.1667 13.2177 26.0862 12.4542 25.9397 11.7151Z" fill="#1976D2"/>
                    </svg>
                  
                    Continue with Google</button>
              </div>
              <div class="login_btn-fb">
                <button type="submit" class="btn btn-outline-primary form_control-radius">
                  <svg xmlns="http://www.w3.org/2000/svg" width="25" height="24" viewBox="0 0 25 24" fill="none">
                    <g clip-path="url(#clip0_1657_23695)">
                    <path d="M24.5 12C24.5 5.37263 19.1274 0 12.5 0C5.87262 0 0.5 5.37253 0.5 12C0.5 17.9895 4.88825 22.954 10.625 23.8542V15.4688H7.57812V12H10.625V9.35625C10.625 6.34875 12.4166 4.6875 15.1575 4.6875C16.4705 4.6875 17.8438 4.92188 17.8438 4.92188V7.875H16.3306C14.8398 7.875 14.375 8.80003 14.375 9.74906V12H17.7031L17.1711 15.4688H14.375V23.8542C20.1118 22.954 24.5 17.9896 24.5 12Z" fill="#1877F2"/>
                    <path d="M17.1711 15.4688L17.7031 12H14.375V9.74906C14.375 8.79994 14.8399 7.875 16.3306 7.875H17.8438V4.92188C17.8438 4.92188 16.4705 4.6875 15.1575 4.6875C12.4166 4.6875 10.625 6.34875 10.625 9.35625V12H7.57812V15.4688H10.625V23.8542C11.2453 23.9514 11.8722 24.0002 12.5 24C13.1278 24.0002 13.7547 23.9514 14.375 23.8542V15.4688H17.1711Z" fill="white"/>
                    </g>
                    <defs>
                    <clipPath id="clip0_1657_23695">
                    <rect width="24" height="24" fill="white" transform="translate(0.5)"/>
                    </clipPath>
                    </defs>
                    </svg>
                    Continue with Facebook</button>
              </div>
            </div>
        </div>
      </div>
  </div>
  <script src="../js/main.js"></script>
</body>
</html>
