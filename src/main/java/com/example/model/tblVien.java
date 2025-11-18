package com.example.model;

import com.example.data.ChucNangSQL;

public class tblVien {
    ChucNangSQL sql = new ChucNangSQL();

    public String maVien;
    public String tenVien;
    public String tenTruongVien;
    public String soDienThoaiVien;
    public String emailVien;
    public String ngayThanhLapVien;

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

    public void sua(tblVien vien) {
        sql.suaVien(maVien, tenVien, tenTruongVien, soDienThoaiVien, emailVien, ngayThanhLapVien);
    }

    public void xoa(String maVien) {
        sql.xoaBanGhi("tblVien", "MaVien = '" + maVien + "'");
    }

    public void truyVanTheoMa_1C(String maVien, String tenCotCanLay) {
        sql.timKiem(tenCotCanLay, "tblVien", "MaVien ='" + maVien + "'");
    }

    public void truyVanTheoMa(String maVien) {
        sql.timKiem("*", "tblVien", "MaVien ='" + maVien + "'");
    }

    // ! lay va sua cac thuoc tinh

    public String getMaVien() {
        return maVien;
    }

    public void setMaVien(String maVien) {
        this.maVien = maVien;
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