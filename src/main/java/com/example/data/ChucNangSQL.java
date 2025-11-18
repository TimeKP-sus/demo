package com.example.data;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Part;

public class ChucNangSQL {
    QuanLySQL ql = new QuanLySQL();

    public boolean kiemTraKhoaChinh(String tenBang, String tenCotKhoaChinh, String giaTriKhoaChinh) {
        List<Map<String, Object>> kq = ql
                .LayTruyVan("SELECT * FROM " + tenBang + " WHERE " + tenCotKhoaChinh + "='" + giaTriKhoaChinh + "';");
        return !kq.isEmpty();
    }

    /**
     * Tìm kiếm và trả về giá trị từ một cột trong bảng theo điều kiện.
     * SQL: SELECT [cotCanLay] FROM [tenBang] WHERE [dieuKien]
     */
    public String timKiem(String cotCanLay, String tenBang, String dieuKien) {
        List<Map<String, Object>> kq = ql.LayTruyVan("SELECT " + cotCanLay + " FROM " + tenBang + " WHERE " + dieuKien);
        if (!kq.isEmpty()) {
            Object value = kq.get(0).get(cotCanLay);
            return value != null ? value.toString() : "";
        }
        return "";
    }

    /**
     * Tìm kiếm và trả về giá trị từ một cột trong bảng lấy từ lệnh sql.
     * SQL: [lenhSQL]
     */
    public String timKiem_SQL(String cotCanLay, String lenhSQL) {
        List<Map<String, Object>> kq = ql.LayTruyVan(lenhSQL);
        if (!kq.isEmpty()) {
            Object value = kq.get(0).get(cotCanLay);
            return value != null ? value.toString() : "";
        }
        return "";
    }

    /**
     * Tìm kiếm bằng truy vấn lồng và trả về giá trị từ một cột trong bảng theo điều
     * kiện.
     * SQL: SELECT [cotCanLay] FROM [tenBang] WHERE cotDieuKien = ( [dieuKien])
     ***
     * Ví dụ:
     * SELECT TenVien
     * FROM tblVien
     * WHERE MaVien = (
     * SELECT MaVien FROM tblKhoa WHERE MaKhoa = '...'
     * );
     */
    public String timKiem_TruyVanLong(String cotCanLay, String tenBang, String cotDieuKien, String dieuKien) {
        List<Map<String, Object>> kq = ql.LayTruyVan(
                "SELECT " + cotCanLay + " FROM " + tenBang + " WHERE " + cotDieuKien + " = (" + dieuKien + ")");
        if (!kq.isEmpty()) {
            Object value = kq.get(0).get(cotCanLay);
            return value != null ? value.toString() : "";
        }
        System.out.println("Không tìm thấy giá trị phù hợp.");
        return "";
    }

    /**
     * Hiển thị tất cả dữ liệu từ một bảng.
     * SQL: SELECT * FROM [tenBang]
     */
    public List<Map<String, Object>> hienThi(String tenBang) {
        return ql.LayTruyVan("SELECT * FROM " + tenBang);
    }

    /**
     * Hiển thị dữ liệu từ một bảng theo điều kiện.
     * SQL: SELECT * FROM [tenBang] WHERE [dieuKien]
     */
    public List<Map<String, Object>> hienThi_DieuKien(String tenBang, String dieuKien) {
        return ql.LayTruyVan("SELECT * FROM " + tenBang + " WHERE " + dieuKien);
    }

    // =========================
    // Chức năng Viện
    // =========================

    /**
     * Thêm viện mới vào hệ thống.
     * SQL: INSERT INTO tblVien (...)
     */
    public void themVien(String maVien, String tenVien, String tenTruongVien, String soDienThoaiVien, String emailVien,
            String ngayThanhLapVien) {
        ql.ChayLenhSQL(
                "INSERT INTO tblVien (MaVien, TenVien, TenTruongVien, SoDienThoaiVien, EmailVien, NgayThanhLapVien) VALUES ('"
                        + maVien + "', '" + tenVien + "', '" + tenTruongVien + "', '" + soDienThoaiVien + "', '"
                        + emailVien + "', '" + ngayThanhLapVien + "');");
    }

    /**
     * Sửa thông tin viện.
     * SQL: UPDATE tblVien SET ... WHERE MaVien='...'
     */
    public void suaVien(String maVienCanSua, String tenVien, String tenTruongVien, String soDienThoaiVien,
            String emailVien, String ngayThanhLapVien) {
        ql.ChayLenhSQL("UPDATE tblVien SET TenVien='" + tenVien + "', TenTruongVien='" + tenTruongVien
                + "', SoDienThoaiVien='" + soDienThoaiVien + "', EmailVien='" + emailVien + "', NgayThanhLapVien='"
                + ngayThanhLapVien + "' WHERE MaVien='" + maVienCanSua + "';");
    }

    // =========================
    // Chức năng Khoa
    // =========================

    /**
     * Thêm khoa mới vào hệ thống.
     * SQL: INSERT INTO tblKhoa (...)
     */
    public void themKhoa(String maKhoa, String tenKhoa, String maVien, String tenTruongKhoa, String soDienThoaiKhoa,
            String emailKhoa, String ngayThanhLapKhoa, String moTaKhoa) {
        ql.ChayLenhSQL(
                "INSERT INTO tblKhoa (MaKhoa, TenKhoa, MaVien, TenTruongKhoa, SoDienThoaiKhoa, EmailKhoa, NgayThanhLapKhoa, MoTaKhoa) VALUES ('"
                        + maKhoa + "', '" + tenKhoa + "', '" + maVien + "', '" + tenTruongKhoa + "', '"
                        + soDienThoaiKhoa + "', '" + emailKhoa + "', '" + ngayThanhLapKhoa + "', '" + moTaKhoa + "');");
    }

    /**
     * Sửa thông tin khoa.
     * SQL: UPDATE tblKhoa SET ... WHERE MaKhoa='...'
     */
    public void suaKhoa(String maKhoaCanSua, String tenKhoa, String maVien, String tenTruongKhoa,
            String soDienThoaiKhoa, String emailKhoa, String ngayThanhLapKhoa, String moTaKhoa) {
        ql.ChayLenhSQL("UPDATE tblKhoa SET TenKhoa='" + tenKhoa + "', MaVien='" + maVien + "', TenTruongKhoa='"
                + tenTruongKhoa + "', SoDienThoaiKhoa='" + soDienThoaiKhoa + "', EmailKhoa='" + emailKhoa
                + "', NgayThanhLapKhoa='" + ngayThanhLapKhoa + "', MoTaKhoa='" + moTaKhoa + "' WHERE MaKhoa='"
                + maKhoaCanSua + "';");
    }

    // =========================
    // Chức năng Ngành
    // =========================

    /**
     * Thêm ngành mới vào hệ thống.
     * SQL: INSERT INTO tblNganh (...)
     */
    public void themNganh(String maNganh, String tenNganh, String maKhoa, String moTaNganh) {
        ql.ChayLenhSQL("INSERT INTO tblNganh (MaNganh, TenNganh, MaKhoa, MoTaNganh) VALUES ('" + maNganh + "', '"
                + tenNganh + "', '" + maKhoa + "', '" + moTaNganh + "');");
    }

    /**
     * Sửa thông tin ngành.
     * SQL: UPDATE tblNganh SET ... WHERE MaNganh='...'
     */
    public void suaNganh(String maNganhCanSua, String tenNganh, String maKhoa, String moTaNganh) {
        ql.ChayLenhSQL("UPDATE tblNganh SET TenNganh='" + tenNganh + "', MaKhoa='" + maKhoa + "', MoTaNganh='"
                + moTaNganh + "' WHERE MaNganh='" + maNganhCanSua + "';");
    }

    // =========================
    // Chức năng Lớp
    // =========================

    /**
     * Thêm lớp mới vào hệ thống.
     * SQL: INSERT INTO tblLop (...)
     */
    public void themLop(String maLop, Integer khoaHoc, String tenLop, String maNganh) {
        ql.ChayLenhSQL("INSERT INTO tblLop (MaLop, KhoaHoc, TenLop, MaNganh) VALUES ('" + maLop + "', "
                + (khoaHoc == null ? "NULL" : khoaHoc) + ", '" + tenLop + "', '" + maNganh + "');");
    }

    /**
     * Sửa thông tin lớp.
     * SQL: UPDATE tblLop SET ... WHERE MaLop='...'
     */
    public void suaLop(String maLopCanSua, Integer khoaHoc, String tenLop, String maNganh) {
        ql.ChayLenhSQL("UPDATE tblLop SET KhoaHoc=" + (khoaHoc == null ? "NULL" : khoaHoc) + ", TenLop='" + tenLop
                + "', MaNganh='" + maNganh + "' WHERE MaLop='" + maLopCanSua + "';");
    }

    // =========================
    // Chức năng Lớp học phần
    // =========================

    /**
     * Thêm lớp học phần mới vào hệ thống.
     * SQL: INSERT INTO tblLopHocPhan (...)
     */
    public void themLopHocPhan(String maLopHocPhan, String tenLopHocPhan, Integer soTinChi, String msgv,
            String thoiGian, Integer soBuoi, String phongHoc) {
        ql.ChayLenhSQL(
                "INSERT INTO tblLopHocPhan (MaLopHocPhan, TenLopHocPhan, SoTinChi, MSGV, ThoiGian, SoBuoi, PhongHoc) VALUES ('"
                        + maLopHocPhan + "', '" + tenLopHocPhan + "', " + (soTinChi == null ? "NULL" : soTinChi) + ", '"
                        + msgv + "', '" + thoiGian + "', " + (soBuoi == null ? "NULL" : soBuoi) + ", '" + phongHoc
                        + "');");
    }

    /**
     * Sửa thông tin lớp học phần.
     * SQL: UPDATE tblLopHocPhan SET ... WHERE MaLopHocPhan='...'
     */
    public void suaLopHocPhan(String maLopHocPhan, String tenLopHocPhan, Integer soTinChi, String msgv, String thoiGian,
            Integer soBuoi, String phongHoc) {
        ql.ChayLenhSQL("UPDATE tblLopHocPhan SET TenLopHocPhan='" + tenLopHocPhan + "', SoTinChi="
                + (soTinChi == null ? "NULL" : soTinChi) + ", MSGV='" + msgv + "', ThoiGian='" + thoiGian + "', SoBuoi="
                + (soBuoi == null ? "NULL" : soBuoi) + ", PhongHoc='" + phongHoc + "' WHERE MaLopHocPhan='"
                + maLopHocPhan + "';");
    }

    // =========================
    // Chức năng Giảng viên
    // =========================

    /**
     * Thêm giảng viên mới vào hệ thống.
     * SQL: INSERT INTO tblGiangVien (...)
     */
    public void themGiangVien(String msgv, String hoTen, String ngaySinh, String gioiTinh, String queQuan, String email,
            String maNganh, String soDienThoai, String anhGV) {
        ql.ChayLenhSQL(
                "INSERT INTO tblGiangVien (MSGV, HoTenGV, NgaySinhGV, GioiTinhGV, QueQuanGV, EmailGV, MaNganh, SoDienThoaiGV, AnhGV) VALUES ('"
                        + msgv + "', '" + hoTen + "', '" + ngaySinh + "', '" + gioiTinh + "', '" + queQuan + "', '"
                        + email + "', '" + maNganh + "', '" + soDienThoai + "', '" + anhGV + "');");
    }

    /**
     * Sửa thông tin giảng viên.
     * SQL: UPDATE tblGiangVien SET ... WHERE MSGV='...'
     */
    public void suaGiangVien(String msgvCanSua, String hoTen, String ngaySinh, String gioiTinh, String queQuan,
            String email, String maNganh, String soDienThoai, String anhGV) {
        ql.ChayLenhSQL("UPDATE tblGiangVien SET HoTenGV='" + hoTen + "', NgaySinhGV='" + ngaySinh + "', GioiTinhGV='"
                + gioiTinh + "', QueQuanGV='" + queQuan + "', EmailGV='" + email + "', MaNganh='" + maNganh
                + "', SoDienThoaiGV='" + soDienThoai + "', AnhGV='" + anhGV + "' WHERE MSGV='" + msgvCanSua + "';");
    }

    // =========================
    // Chức năng Sinh viên
    // =========================

    /**
     * Thêm sinh viên mới vào hệ thống.
     * SQL: INSERT INTO tblSinhVien (...)
     */
    public void themSinhVien(String mssv, String hoTen, String ngaySinh, String gioiTinh, String queQuan, String email,
            String maLop, String soDienThoai, String anhSV) {
        ql.ChayLenhSQL(
                "INSERT INTO tblSinhVien (MSSV, HoTenSV, NgaySinhSV, GioiTinhSV, QueQuanSV, EmailSV, MaLop, SoDienThoaiSV, AnhSV) VALUES ('"
                        + mssv + "', '" + hoTen + "', '" + ngaySinh + "', '" + gioiTinh + "', '" + queQuan + "', '"
                        + email + "', '" + maLop + "', '" + soDienThoai + "', '" + anhSV + "');");
    }

    /**
     * Sửa thông tin sinh viên.
     * SQL: UPDATE tblSinhVien SET ... WHERE MSSV='...'
     */
    public void suaSinhVien(String mssvCanSua, String hoTen, String ngaySinh, String gioiTinh, String queQuan,
            String email, String maLop, String soDienThoai, String anhSV) {
        ql.ChayLenhSQL("UPDATE tblSinhVien SET HoTenSV='" + hoTen + "', NgaySinhSV='" + ngaySinh + "', GioiTinhSV='"
                + gioiTinh + "', QueQuanSV='" + queQuan + "', EmailSV='" + email + "', MaLop='" + maLop
                + "', SoDienThoaiSV='" + soDienThoai + "', AnhSV='" + anhSV + "' WHERE MSSV='" + mssvCanSua + "';");
    }

    // =========================
    // Xóa bản ghi
    // =========================

    /**
     * Xóa bản ghi từ bảng theo điều kiện.
     * SQL: DELETE FROM [tenBang] WHERE [dieuKien]
     */
    public void xoaBanGhi(String tenBang, String dieuKien) {
        ql.ChayLenhSQL("DELETE FROM " + tenBang + " WHERE " + dieuKien + ";");
    }

    // =========================
    // * Upload file
    // =========================

    /**
     * Thêm file vào thư mục uploads của ứng dụng.
     * Lưu file vào: /src/main/webapp/uploads/
     */
    public void themFile(Part filePart, ServletContext context) throws IOException {
        if (filePart != null && filePart.getSize() > 0) {
            String fileName = filePart.getSubmittedFileName();
            String uploadDir = context.getRealPath("/static/uploads");
            System.err.println("Địa chỉ upload: " + uploadDir);
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String filePath = uploadDir + File.separator + fileName; // Sửa ở đây
            filePart.write(filePath);
        } else {
            // loi
            throw new IOException("File rỗng hoặc không tồn tại");
        }
    }

    // =========================
    // * Upload file với mã số
    // =========================

    /**
     * Upload một file vào thư mục /static/uploads của ứng dụng.
     * - Đặt tên file theo mã số (maSo) và giữ nguyên phần mở rộng của file gốc.
     * - Nếu file có cùng mã số đã tồn tại, sẽ xóa file cũ trước khi ghi đè.
     *
     * @param filePart Đối tượng Part chứa dữ liệu file upload từ form.
     * @param context  ServletContext để lấy đường dẫn thực tế của thư mục uploads.
     * @param maSo     Mã số dùng để đặt tên file.
     */

    public void themFile_Ma(Part filePart, ServletContext context, String maSo) throws IOException {
        if (filePart != null && filePart.getSize() > 0) {
            String fileName = filePart.getSubmittedFileName();
            String extension = "";

            // Lấy phần mở rộng nếu có
            int dotIndex = fileName.lastIndexOf('.');
            if (dotIndex > 0) {
                extension = fileName.substring(dotIndex); // ví dụ: ".jpg"
            }

            String uploadDir = context.getRealPath("/static/uploads");
            System.err.println("Địa chỉ upload: " + uploadDir);

            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // Đặt tên file theo maSo + extension
            String filePath = uploadDir + File.separator + maSo + extension;
            File oldFile = new File(filePath);

            // Nếu file cũ tồn tại thì xóa
            if (oldFile.exists()) {
                System.out.println("File cũ tồn tại, đang xóa...");
                oldFile.delete();
            }

            // Ghi file mới
            filePart.write(filePath);
            System.out.println("Upload thành công: " + filePath);
        } else {
            throw new IOException("File rỗng hoặc không tồn tại");
        }
    }

    // =========================
    // * Bổ sung dữ liệu cho danh sách theo mã số (Chưa bao quát)
    // =========================

    /**
     * Bổ sung dữ liệu cho danh sách theo mã số.
     * Ví dụ: bổ sung thông tin vào cho danh sách dựa vào mã số.
     ***
     * SQL: SELECT [cotChoVao] FROM [bangCuaCot] WHERE [tenCotMaSo] = '[giá trị dựa
     * theo
     * tenCotMaSo trong danh sách]'
     */
    public void boSungDS(List<Map<String, Object>> danhSachCanBoSung, String cotChoVao, String bangCuaCot,
            String tenCotMaSo) {
        for (Map<String, Object> i : danhSachCanBoSung) {
            i.put(cotChoVao, timKiem(cotChoVao, bangCuaCot, tenCotMaSo + " = '" + i.get(tenCotMaSo) + "'"));
        }
    }

    // =========================
    // * Bổ sung dữ liệu cho danh sách theo truy vấn lồng (Chưa ổn định)
    // =========================
    /**
     * Bổ sung dữ liệu cho danh sách theo truy vấn lồng (chưa ổn định).
     *
     * Mục đích: với mỗi bản ghi trong danh sách, lấy giá trị từ bảng khác
     * bằng cách dùng truy vấn.
     *
     * Cấu trúc SQL mong muốn:
     * SELECT [cotChoVao] FROM [bangCuaCot]
     * WHERE [cotDieuKien] = (
     * SELECT [cotDieuKien] FROM [bangCuaCotDieuKien] WHERE [tenCotDaCo] = '[giá trị
     * từ danh sách]'
     * );
     *
     * Ví dụ:
     * SELECT TenVien FROM tblVien
     * WHERE MaVien = (
     * SELECT MaVien FROM tblKhoa WHERE MaKhoa = 'K001'
     * );
     */
    public void boSungDS_TruyVanLong(List<Map<String, Object>> danhSachCanBoSung,
            String cotChoVao, String bangCuaCot,
            String cotDieuKien, String bangCuaCotDieuKien, String cotDaCo) {
        for (Map<String, Object> i : danhSachCanBoSung) {
            String sqlString = "SELECT " + cotDieuKien + " FROM " + bangCuaCotDieuKien +
                    " WHERE " + cotDaCo + " = '" + i.get(cotDaCo) + "'";
            i.put(cotChoVao, timKiem_TruyVanLong(cotChoVao, bangCuaCot, cotDieuKien, sqlString));
        }
        // System.out.println("Đã bổ sung " + cotChoVao + " dựa theo " + cotDaCo);
    }
    // public void boSungDS_TruyVanLong(List<Map<String, Object>> danhSachCanBoSung,
    // String cotChoVao, String bangCuaCot,
    // String cotDieuKien, String bangCuaCotDieuKien, String cotDaCo) {
    // for (Map<String, Object> i : danhSachCanBoSung) {
    // i.put(cotChoVao, timKiem_TruyVanLong(cotChoVao,
    // bangCuaCot,
    // cotDieuKien,
    // timKiem(cotDieuKien, bangCuaCotDieuKien, cotDaCo + " = '" +
    // i.get(cotDaCo) + "'")));
    // }
    // System.out.println("Đã bổ sung " + cotChoVao + " dựa theo " + cotDaCo);
    // }

    // =========================
    // * Bổ sung dữ liệu cho danh sách theo lệnh sql
    // =========================
    /**
     * Bổ sung dữ liệu cho danh sách theo điều kiện
     * Ví dụ: bổ sung thông tin vào cho danh sách dựa vào truy vấn theo lệnh SQL.
     ***
     * SQL: [lenhSQL]
     */
    public void boSungDS_VoiLenhSQL(List<Map<String, Object>> danhSachCanBoSung, String cotChoVao, String lenhSQL) {
        for (Map<String, Object> i : danhSachCanBoSung) {
            i.put(cotChoVao, timKiem_SQL(cotChoVao, lenhSQL));
        }
    }

    // =========================
    // * Đổi định dạng hiển thị ngày tháng năm dễ nhìn hơn
    // =========================
    public String doiDinhDangNgay(String ngayThangNamSQL) {
        String[] parts = ngayThangNamSQL.split("-");
        if (parts.length > 2) {
            return parts[2] + "/" + parts[1] + "/" + parts[0];
        }
        return ngayThangNamSQL;
    }
}
