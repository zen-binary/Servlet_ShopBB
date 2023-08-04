CREATE DATABASE SHOP_BB
GO

USE SHOP_BB
GO

CREATE TABLE VAITRO(
	Id INT IDENTITY PRIMARY KEY,
	Ten NVARCHAR(50),
	NgayTao DATETIME,
	NgaySua DATETIME,
	TrangThai INT
)
GO

CREATE TABLE NGUOIDUNG(
	Id INT IDENTITY PRIMARY KEY,
	IdVT INT REFERENCES dbo.VAITRO(Id),
	Ten NVARCHAR(100),
	TaiKhoan VARCHAR(100),
	MatKhau VARCHAR(100),
	HinhAnh NVARCHAR(MAX),
	NgaySinh DATE,
	GioiTinh INT,
	Email VARCHAR(20),
	Sdt VARCHAR(20),
	DiaChi NVARCHAR(MAX),
	Google NVARCHAR(MAX),
	Facebook NVARCHAR(MAX),
	NgayTao DATETIME,
	NgaySua DATETIME,
	TrangThai INT
)

GO

CREATE TABLE KHACHHANG(
	Id INT IDENTITY PRIMARY KEY,
	Ten NVARCHAR(100),
	NgaySinh DATE,
	GioiTinh INT,
	Sdt VARCHAR(20),
	DiaChi NVARCHAR(MAX),
	Google NVARCHAR(MAX),
	Facebook NVARCHAR(MAX),
	NgayTao DATETIME,
	NgaySua DATETIME,
	TrangThai INT
)
GO


CREATE TABLE LOAI(
	Id INT IDENTITY PRIMARY KEY,
	Ten NVARCHAR(MAX),
	NgayTao DATETIME,
	NgaySua DATETIME,
	TrangThai INT
)

GO

CREATE TABLE KICHTHUOC(
	Id INT IDENTITY PRIMARY KEY,
	Ten NVARCHAR(MAX),
	NgayTao DATETIME,
	NgaySua DATETIME,
	TrangThai INT
)

GO

CREATE TABLE MAUSAC(
	Id INT IDENTITY PRIMARY KEY,
	Ten NVARCHAR(MAX),
	NgayTao DATETIME,
	NgaySua DATETIME,
	TrangThai INT
)

GO

CREATE TABLE SANPHAM(
	Id INT IDENTITY PRIMARY KEY,
	IdLoai INT REFERENCES dbo.LOAI(Id),
	Ten NVARCHAR(MAX),
	HinhAnh NVARCHAR(MAX),
	MoTa NVARCHAR(MAX),
	NgayTao DATETIME,
	NgaySua DATETIME,
	TrangThai INT
)

GO

CREATE TABLE CHITIETSANPHAM(
	Id INT IDENTITY PRIMARY KEY,
	IdSP INT REFERENCES dbo.SANPHAM(Id),
	IdMS INT REFERENCES dbo.MAUSAC(Id),
	IdKT INT REFERENCES dbo.KICHTHUOC(Id),
	HinhAnh NVARCHAR(MAX),
	SoLuongTon INT,
	SoLuongBan INT,
	GiaNhap FLOAT,
	GiaBan FLOAT,
	NgayTao DATETIME,
	NgaySua DATETIME,
	TrangThai INT
)

GO

CREATE TABLE HOADON(
	Id INT IDENTITY PRIMARY KEY,
	IdND INT REFERENCES dbo.NGUOIDUNG(Id),
	IdKH INT REFERENCES dbo.KHACHHANG(Id),
	TenNguoiNhan NVARCHAR(MAX),
	Sdt VARCHAR(20),
	Email VARCHAR(20),
	DiaChi NVARCHAR(MAX),
	NgayShip DATETIME,
	NgayNhan DATETIME,
	NgayThanhToan DATETIME,
	NgayTao DATETIME,
	NgaySua DATETIME,
	TrangThai INT
)
GO

CREATE TABLE HOADONCHITIET(
	Id INT IDENTITY PRIMARY KEY,
	IdHD INT REFERENCES dbo.HOADON(Id),
	IdCTSP INT REFERENCES dbo.CHITIETSANPHAM(Id),
	SoLuong INT,
	DonGia FLOAT,
	NgayTao DATETIME,
	NgaySua DATETIME,
	TrangThai INT
)

GO
-- Insert data into VAITRO table
INSERT INTO VAITRO (Ten, NgayTao, NgaySua, TrangThai)
VALUES
  ('Role1', '2023-07-26 12:00:00', '2023-07-26 12:30:00', 1),
  ('Role2', '2023-07-25 09:15:00', '2023-07-26 11:00:00', 1),
  ('Role3', '2023-07-24 14:45:00', '2023-07-26 10:20:00', 1);

-- Insert data into NGUOIDUNG table
INSERT INTO NGUOIDUNG (IdVT, Ten, TaiKhoan, MatKhau, NgaySinh, GioiTinh, Sdt, DiaChi, Google, Facebook, NgayTao, NgaySua, TrangThai)
VALUES
  (1, 'User1', 'user1@example.com', 'password1', '2000-01-01', 1, '123456789', 'Address 1', '', '', '2023-07-26 08:00:00', '2023-07-26 08:30:00', 1),
  (2, 'User2', 'user2@example.com', 'password2', '1995-05-15', 2, '987654321', 'Address 2', '', '', '2023-07-25 10:00:00', '2023-07-26 09:30:00', 1),
  (3, 'User3', 'user3@example.com', 'password3', '1988-11-30', 1, '555555555', 'Address 3', '', '', '2023-07-24 13:00:00', '2023-07-26 07:30:00', 1);

-- Continue with INSERT statements for other tables with sample data.

INSERT INTO KHACHHANG (Ten, NgaySinh, GioiTinh, Sdt, DiaChi, Google, Facebook, NgayTao, NgaySua, TrangThai)
VALUES
  ('John Doe', '1990-05-15', 1, '123456789', 'Address 1', '', 'john.doe@gmail.com', '2023-07-26 08:00:00', '2023-07-26 08:30:00', 1),
  ('Jane Smith', '1985-11-30', 0, '987654321', 'Address 2', '', 'jane.smith@gmail.com', '2023-07-25 10:00:00', '2023-07-26 09:30:00', 1),
  ('Michael Johnson', '1998-03-25', 1, '555555555', 'Address 3', 'michael.johnson@gmail.com', '', '2023-07-24 13:00:00', '2023-07-26 07:30:00', 1);

GO

INSERT INTO KICHTHUOC (Ten, NgayTao, NgaySua, TrangThai)
VALUES
  ('Small', '2023-07-26 08:00:00', '2023-07-26 08:30:00', 1),
  ('Medium', '2023-07-25 10:00:00', '2023-07-26 09:30:00', 1),
  ('Large', '2023-07-24 13:00:00', '2023-07-26 07:30:00', 1);
  INSERT INTO LOAI (Ten, NgayTao, NgaySua, TrangThai)
VALUES
  ('Category 1', '2023-07-26 08:00:00', '2023-07-26 08:30:00', 1),
  ('Category 2', '2023-07-25 10:00:00', '2023-07-26 09:30:00', 1),
  ('Category 3', '2023-07-24 13:00:00', '2023-07-26 07:30:00', 1);


INSERT INTO SANPHAM (IdLoai, Ten, HinhAnh, MoTa, NgayTao, NgaySua, TrangThai)
VALUES 
    (1, N'Sản phẩm 1', N'hinh_anh_1.jpg', N'Mô tả sản phẩm 1', '2023-08-02 12:00:00', '2023-08-02 12:30:00', 1),
    (2, N'Sản phẩm 2', N'hinh_anh_2.jpg', N'Mô tả sản phẩm 2', '2023-08-02 13:00:00', '2023-08-02 13:15:00', 1),
    (1, N'Sản phẩm 3', N'hinh_anh_3.jpg', N'Mô tả sản phẩm 3', '2023-08-02 14:30:00', '2023-08-02 14:45:00', 0)
    -- Add more rows here as needed--

 INSERT INTO MAUSAC (Ten, NgayTao, NgaySua, TrangThai)
VALUES
  ('Red', '2023-07-26 08:00:00', '2023-07-26 08:30:00', 1),
  ('Blue', '2023-07-25 10:00:00', '2023-07-26 09:30:00', 1),
  ('Green', '2023-07-24 13:00:00', '2023-07-26 07:30:00', 1);


INSERT INTO CHITIETSANPHAM (IdSP, IdMS, IdKT, HinhAnh, SoLuongTon, SoLuongBan, GiaNhap, GiaBan, NgayTao, NgaySua, TrangThai)
VALUES 
    (1, 1, 1, N'hinh_anh_1.jpg', 50, 25, 1000.50, 1500.75, '2023-08-02 12:00:00', '2023-08-02 12:30:00', 1),
    (2, 2, 2, N'hinh_anh_2.jpg', 75, 50, 800.25, 1200.50, '2023-08-02 13:00:00', '2023-08-02 13:15:00', 1),
    (3, 3, 1, N'hinh_anh_3.jpg', 100, 70, 1200.00, 1800.25, '2023-08-02 14:30:00', '2023-08-02 14:45:00', 0)
    -- Add more rows here as needed--
GO

INSERT INTO HOADON (IdND, IdKH, TenNguoiNhan, Sdt, DiaChi, NgayShip, NgayNhan, NgayThanhToan, NgayTao, NgaySua, TrangThai)
VALUES
  (1, 1, 'John Doe', '123456789', 'Address 1', '2023-07-26 08:00:00', '2023-07-26 10:00:00', '2023-07-26 12:00:00', '2023-07-26 08:00:00', '2023-07-26 08:30:00', 1),
  (2, 2, 'Jane Smith', '987654321', 'Address 2', '2023-07-25 10:00:00', '2023-07-25 12:00:00', '2023-07-25 14:00:00', '2023-07-25 10:00:00', '2023-07-26 09:30:00', 1),
  (3, 3, 'Michael Johnson', '555555555', 'Address 3', '2023-07-24 13:00:00', '2023-07-24 15:00:00', '2023-07-24 17:00:00', '2023-07-24 13:00:00', '2023-07-26 07:30:00', 1);

INSERT INTO HOADONCHITIET (IdHD, IdCTSP, SoLuong, DonGia, NgayTao, NgaySua, TrangThai)
VALUES
  (1, 1, 2, 50.0, '2023-07-26 08:00:00', '2023-07-26 08:30:00', 1),
  (1, 2, 3, 75.0, '2023-07-26 08:00:00', '2023-07-26 08:30:00', 1), 
  (2, 3, 1, 80.0, '2023-07-25 10:00:00', '2023-07-26 09:30:00', 1)
