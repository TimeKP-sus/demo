package com.example.model;

import com.example.data.ChucNangSQL;

import jakarta.servlet.http.HttpServletRequest;

public class tblVien {
    ChucNangSQL sql = new ChucNangSQL();

    public String maVien;
    public String tenVien;
    public String tenTruongVien;
    public String soDienThoaiVien;
    public String emailVien;
    public String ngayThanhLapVien;
    public HttpServletRequest request;

    public tblVien() {
    }

    public tblVien(String maVien, String tenVien, String tenTruongVien, String soDienThoaiVien,
            String emailVien, String ngayThanhLapVien) {
        this.maVien = maVien;
        this.tenVien = tenVien;
        this.tenTruongVien = tenTruongVien;
        this.soDienThoaiVien = soDienThoaiVien;
        this.emailVien = emailVien;
        this.ngayThanhLapVien = ngayThanhLapVien;
    }

    public void them(tblVien vien) {
        sql.themVien(maVien, tenVien, tenTruongVien, soDienThoaiVien, emailVien, ngayThanhLapVien);
    }

    public void them() {
        sql.themVien(this.maVien, this.tenVien, this.tenTruongVien, this.soDienThoaiVien, this.emailVien,
                this.ngayThanhLapVien);
    }

    public void sua(tblVien vien) {
        sql.suaVien(vien.maVien, vien.tenVien, vien.tenTruongVien, vien.soDienThoaiVien, vien.emailVien,
                vien.ngayThanhLapVien);
    }

    public void sua() {
        sql.suaVien(this.maVien, this.tenVien, this.tenTruongVien, this.soDienThoaiVien, this.emailVien,
                this.ngayThanhLapVien);
    }

    public void xoa(String maVienString) {
        sql.xoaBanGhi("tblVien", "MaVien = '" + maVienString + "'");
    }

    public void xoa() {
        sql.xoaBanGhi("tblVien", "MaVien = '" + this.maVien + "'");
    }

    public String truyVanTheoMa_1C(String tenCotCanLay) {
        return sql.timKiem(tenCotCanLay, "tblVien", "MaVien ='" + this.maVien + "'");
    }

    public String truyVanTheoMa_1C(String maVienString, String tenCotCanLay) {
        return sql.timKiem(tenCotCanLay, "tblVien", "MaVien ='" + maVienString + "'");
    }

    public void truyVanTheoMa(String maVienString) {
        this.maVien = maVienString;
        this.tenVien = truyVanTheoMa_1C(this.maVien, "TenVien");
        this.tenTruongVien = truyVanTheoMa_1C(this.maVien, "TenTruongVien");
        this.soDienThoaiVien = truyVanTheoMa_1C(this.maVien, "SoDienThoaiVien");
        this.emailVien = truyVanTheoMa_1C(this.maVien, "EmailVien");
        this.ngayThanhLapVien = truyVanTheoMa_1C(this.maVien, "NgayThanhLapVien");
    }

    public void setMaVien(String maVien) {
        System.err.println("vao set ma vien");
        if (sql.kiemTraKhoaChinh("tblVien", "MaVien", maVien)) {
            request.setAttribute("loiMaVien", "Mã viện đã tồn tại");
        } else if (maVien == null || maVien.trim().isEmpty()) {
            request.setAttribute("loiMaVien", "Mã viện cac không được để trống");

        } else {
            request.setAttribute("loiMaVien", "cac");
        }

    }

    // ! lay va sua cac thuoc tinh
    public String getMaVien() {
        return maVien;
    }

    public String getTenVien() {
        return tenVien;
    }

    public void setTenVien(String tenVien) {
        this.tenVien = tenVien;
    }

    public String getTenTruongVien() {
        return tenTruongVien;
    }

    public void setTenTruongVien(String tenTruongVien) {
        this.tenTruongVien = tenTruongVien;
    }

    public String getSoDienThoaiVien() {
        return soDienThoaiVien;
    }

    public void setSoDienThoaiVien(String soDienThoaiVien) {
        this.soDienThoaiVien = soDienThoaiVien;
    }

    public String getEmailVien() {
        return emailVien;
    }

    public void setEmailVien(String emailVien) {
        this.emailVien = emailVien;
    }

    public String getNgayThanhLapVien() {
        return ngayThanhLapVien;
    }

    public void setNgayThanhLapVien(String ngayThanhLapVien) {
        this.ngayThanhLapVien = ngayThanhLapVien;
    }
}