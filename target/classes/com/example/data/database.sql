
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
    AnhGV TEXT NULL
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
    AnhSV TEXT NULL
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
CREATE TABLE IF NOT EXISTS tblTaiKhoan (
    IDTaiKhoan INTEGER PRIMARY KEY AUTOINCREMENT,
    MaNguoiDung TEXT NULL,
    MatKhau TEXT NULL,
    ChucVu TEXT NULL
);



-- Dữ liệu mẫu cho tblVien
INSERT INTO tblVien (MaVien, TenVien, TenTruongVien, SoDienThoaiVien, EmailVien, NgayThanhLapVien) VALUES
('V001', 'Viện Công Nghệ Thông Tin', 'Nguyễn Văn A', '0123456789', 'vien1@truong.edu.vn', '2001-01-01'),
('V002', 'Viện Khoa Học Ứng Dụng', 'Trần Thị B', '0987654321', 'vien2@truong.edu.vn', '2005-05-05');

-- Dữ liệu mẫu cho tblKhoa
INSERT INTO tblKhoa (MaKhoa, TenKhoa, MaVien, TenTruongKhoa, SoDienThoaiKhoa, EmailKhoa, NgayThanhLapKhoa, MoTaKhoa) VALUES
('K001', 'Khoa Công Nghệ Thông Tin', 'V001', 'Lê Văn C', '0111222333', 'khoa1@truong.edu.vn', '2002-02-02', 'Khoa chuyên về CNTT'),
('K002', 'Khoa Điện Tử', 'V002', 'Phạm Thị D', '0444555666', 'khoa2@truong.edu.vn', '2006-06-06', 'Khoa chuyên về điện tử');

-- Dữ liệu mẫu cho tblNganh
INSERT INTO tblNganh (MaNganh, TenNganh, MaKhoa, MoTaNganh) VALUES
('N001', 'Công Nghệ Phần Mềm', 'K001', 'Ngành về phát triển phần mềm'),
('N002', 'Khoa Học Máy Tính', 'K001', 'Ngành về khoa học máy tính'),
('N003', 'Điện Tử Viễn Thông', 'K002', 'Ngành về điện tử viễn thông');

-- Dữ liệu mẫu cho tblLop
INSERT INTO tblLop (MaLop, KhoaHoc, TenLop, MaNganh) VALUES
('L001', 2020, 'CTPMK42', 'N001'),
('L002', 2020, 'KHMTK42', 'N002'),
('L003', 2020, 'ĐTVTK42', 'N003');

-- Dữ liệu mẫu cho tblGiangVien
INSERT INTO tblGiangVien (MSGV, HoTenGV, NgaySinhGV, GioiTinhGV, QueQuanGV, EmailGV, MaNganh, SoDienThoaiGV, AnhGV) VALUES 
('GV001', 'Nguyễn Văn A', '1980-01-01', 'Nam', 'Hà Nội', 'gv001@example.com', 'N001', '0123456789', 'anh_gv001.jpg'),
('GV002', 'Trần Thị B', '1985-05-15', 'Nữ', 'Hồ Chí Minh', 'gv002@example.com', 'N002', '0987654321', 'anh_gv002.jpg'),
('GV003', 'Lê Văn C', '1978-09-20', 'Nam', 'Đà Nẵng', 'gv003@example.com', 'N003', '0123456789', 'anh_gv003.jpg');

-- Dữ liệu mẫu cho tblSinhVien
INSERT INTO tblSinhVien (MSSV, HoTenSV, NgaySinhSV, GioiTinhSV, QueQuanSV, EmailSV, MaLop, SoDienThoaiSV, AnhSV) VALUES 
('SV001', 'Phạm Thị X', '2000-02-02', 'Nữ', 'Hà Nội', 'sv001@example.com', 'L001', '0123456789', 'anh_sv001.jpg'),
('SV002', 'Đỗ Văn Y', '1999-03-03', 'Nam', 'Hồ Chí Minh', 'sv002@example.com', 'L002', '0987654321', 'anh_sv002.jpg'),
('SV003', 'Vũ Thị Z', '2001-04-04', 'Nữ', 'Đà Nẵng', 'sv003@example.com', 'L003', '0123456789', 'anh_sv003.jpg');

-- Dữ liệu mẫu cho tblLopHocPhan
INSERT INTO tblLopHocPhan (MaLopHocPhan, TenLopHocPhan, SoTinChi, MSGV, ThoiGian, SoBuoi, PhongHoc) VALUES 
('LH001', 'Lập Trình Java', 3, 'GV001', 'Thứ 2, 4, 6 - 10:00-12:00', 15, 'P101'),
('LH002', 'Cấu Trúc Dữ Liệu', 4, 'GV002', 'Thứ 3, 5 - 14:00-16:00', 15, 'P202'),
('LH003', 'Mạch Điện Tử', 3, 'GV003', 'Thứ 2, 4 - 08:00-10:00', 15, 'P303');

-- Dữ liệu mẫu cho tblDangKyHocPhan
INSERT INTO tblDangKyHocPhan (MSSV, MaLopHocPhan) VALUES 
('SV001', 'LH001'),
('SV002', 'LH002'),
('SV003', 'LH003');

-- Dữ liệu mẫu cho tblTaiKhoan
INSERT INTO tblTaiKhoan (MaNguoiDung, MatKhau, ChucVu) VALUES 
('admin', '123', 'Admin'),
('GV001', '123', 'Giảng Viên'),
('SV001', '123', 'Sinh Viên');

