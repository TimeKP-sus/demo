
-- Tạo bảng tblVien
CREATE TABLE IF NOT EXISTS tblVien (
    IDVien INTEGER PRIMARY KEY AUTOINCREMENT,
    MaVien TEXT NULL,
    TenVien TEXT NULL,
    TenTruongVien TEXT NULL,
    SoDienThoaiVien TEXT NULL,
    EmailVien TEXT NULL,
    NgayThanhLapVien TEXT NULL
);
--Tạo bảng tblKhoa
CREATE TABLE IF NOT EXISTS tblKhoa (
    IDKhoa INTEGER PRIMARY KEY AUTOINCREMENT,
    MaKhoa TEXT NULL,
    TenKhoa TEXT NULL,
    MaVien TEXT NULL,
    TenTruongKhoa TEXT NULL,
    SoDienThoaiKhoa TEXT NULL,
    EmailKhoa TEXT NULL,
    NgayThanhLapKhoa TEXT NULL,
    MoTaKhoa TEXT NULL
);
-- Tạo bảng tblNganh
CREATE TABLE IF NOT EXISTS tblNganh (
    IDNganh INTEGER PRIMARY KEY AUTOINCREMENT,
    MaNganh TEXT NULL,
    TenNganh TEXT NULL,
    MaKhoa TEXT NULL,
    MoTaNganh TEXT NULL
);

-- Tạo bảng tblLop
CREATE TABLE IF NOT EXISTS tblLop (
    IDLop INTEGER PRIMARY KEY AUTOINCREMENT,
    MaLop TEXT NULL,
    KhoaHoc INTEGER NULL,
    TenLop TEXT NULL,
    MaNganh TEXT NULL
);

-- Tạo bảng tblGiangVien
CREATE TABLE IF NOT EXISTS tblGiangVien (
    IDGiangVien INTEGER PRIMARY KEY AUTOINCREMENT,
    MSGV TEXT NULL,
    HoTenGV TEXT NULL,
    NgaySinhGV TEXT NULL,
    GioiTinhGV TEXT NULL,
    QueQuanGV TEXT NULL,
    EmailGV TEXT NULL,
    MaNganh TEXT NULL,
    SoDienThoaiGV TEXT NULL,
    AnhGV TEXT NULL,
    TrangThaiGV TEXT NULL
);
--tblSinhVien
CREATE TABLE IF NOT EXISTS tblSinhVien (
    IDSinhVien INTEGER PRIMARY KEY AUTOINCREMENT,
    MSSV TEXT NULL,
    HoTenSV TEXT NULL,
    NgaySinhSV TEXT NULL,
    GioiTinhSV TEXT NULL,
    QueQuanSV TEXT NULL,
    EmailSV TEXT NULL,
    MaLop TEXT NULL,
    SoDienThoaiSV TEXT NULL,
    AnhSV TEXT NULL,
    TrangThaiSV TEXT NULL
);
--tblLopHocPhan
CREATE TABLE IF NOT EXISTS tblLopHocPhan (
    IDLopHocPhan INTEGER PRIMARY KEY AUTOINCREMENT,
    MaLopHocPhan TEXT NULL,
    TenLopHocPhan TEXT NULL,
    SoTinChi INTEGER NULL,
    MSGV TEXT NULL,
    ThoiGian TEXT NULL,
    SoBuoi INTEGER NULL,
    PhongHoc TEXT NULL
);
--tblDiemLopHocPhan
CREATE TABLE IF NOT EXISTS tblDiemLopHocPhan (
    IDDiemLopHocPhan INTEGER PRIMARY KEY AUTOINCREMENT,
    MSSV TEXT NULL,
    MaLopHocPhan TEXT NULL,
    DiemQuaTrinh INTEGER NULL,
    DiemThi INTEGER NULL,
    DiemTongKet INTEGER NULL
);

--tblDangKyHocPhan
CREATE TABLE IF NOT EXISTS tblDangKyHocPhan (
    IDDangKyHocPhan INTEGER PRIMARY KEY AUTOINCREMENT,
    MSSV TEXT NULL,
    MaLopHocPhan TEXT NULL,
    TrangThai TEXT NULL
);
--tblDiemDanh 
CREATE TABLE IF NOT EXISTS tblDiemDanh (
    IDDiemDanh INTEGER PRIMARY KEY AUTOINCREMENT,
    MSSV TEXT NULL,
    IDLopHocPhan INTEGER NULL,
    ChuoiDiemDanh TEXT NULL,
    GhiChu TEXT NULL
);
--tblTaiKhoan
CREATE TABLE IF NOT EXISTS tblTaiKhoan (
    IDTaiKhoan INTEGER PRIMARY KEY AUTOINCREMENT,
    MaNguoiDung TEXT NULL,
    MatKhau TEXT NULL,
    ChucVu TEXT NULL
);


