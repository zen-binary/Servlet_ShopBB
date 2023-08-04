<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/07/2023
  Time: 6:17 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <div class="main_contaner">
    <div class="row">
      <div class="box_profile-tile col-12 row">
        <div class="profile_tile col-6">
          <h4>Hồ Sơ Của Tôi</h4>
          <p>Quản lý thông tin hồ sơ để bảo mật tài khoản</p>
        </div>
        <div class="profile_btn col-6">
          <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#doimk">Đổi Mật
            Khẩu</button>

          <div class="modal fade" id="doimk" tabindex="-1" aria-labelledby="exampleModalLabel"
               aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h1 class="modal-title fs-5" id="exampleModalLabel">
                    Đổi Mật Khẩu
                  </h1>
                  <button type="button" class="btn-close" data-bs-dismiss="modal"
                          aria-label="Close"></button>
                </div>
                <div class="modal-body">
                  <form class="row g-3">
                    <div class="col-12">
                      <label for="name" class="form-label">Mật Khẩu Cũ</label>
                      <input type="text" class="form-control" id="name" placeholder="Mật Khẩu"
                             ng-model="form_password.password">
                    </div>
                    <div class="col-12">
                      <label for="matKhauNew" class="form-label">Mật Khẩu Mới</label>
                      <input type="text" class="form-control" id="matKhauNew"
                             ng-model="form_password.password_confirm" placeholder="Mật Khẩu Mới">
                    </div>
                    <div class="col-12">
                      <label for="xacNhanMatKhau" class="form-label">Xác Nhận Mật Khẩu</label>
                      <input type="text" class="form-control" id="xacNhanMatKhau"
                             ng-model="form_password.password_confirm_confirm" placeholder="Mật Khẩu Xác Nhận">
                    </div>
                  </form>


                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-primary" ng-click="updatePassword($event)">
                    Save
                  </button>
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                    Close
                  </button>

                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <hr>
      <div class="profile_left col-4">
        <div class="box_avatar">
          <div class="box_avatar-img">
            <img src="/img/Rectangl.png" alt="">
          </div>
          <div class="box_input-avatar">
            <input type="file" value="Chọn Ảnh" >
          </div>
          <div class="box_dec">
            <p>Dụng lượng file tối đa 1 MB <br>
              Định dạng:.JPEG, .PNG</p>
          </div>
        </div>
      </div>
      <div class="profile_right col-8">
        <form>
          <div class="mb-3">
            <label for="hoTen" class="form-label">Họ Và Tên</label>
            <input type="text" class="form-control" id="hoTen" ng-model="form_user.name">
          </div>
          <div class="mb-3">
            <label for="emaildk" class="form-label">Email address</label>
            <input type="email" class="form-control" id="emaildk" aria-describedby="emailHelp"
                   ng-model="form_user.email" disabled>
          </div>
          <div class="mb-3">
            <label class="form-label">Giới Tính</label><br>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="inlineRadioOptions" id="gtNam"
                     value="1" ng-model="form_user.gender" ng-checked="form_user.gender == 'true'">
              <label class="form-check-label" for="gtNam">Nam</label>
            </div>
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="radio" name="inlineRadioOptions" id="gtNu"
                     value="0" ng-model="form_user.gender"ng-checked="form_user.gender == 'false'">
              <label class="form-check-label" for="gtNu">Nữ</label>
            </div>
          </div>
          <div class="mb-3">
            <label for="ngaysinh" class="form-label">Ngày Sinh</label>
            <input type="date" class="form-control" id="ngaysinh" ng-model="form_user.birthday">
          </div>
          <div class="mb-3">
            <label for="diachi" class="form-label">Địa Chỉ</label>
            <textarea name="" id="diachi" class="form-control"
                      ng-model="form_user.address"></textarea>
          </div>
          <button type="submit" class="btn btn-primary" ng-click="updateInfo($event)">Lưu</button>
        </form>
      </div>
    </div>
  </div>
