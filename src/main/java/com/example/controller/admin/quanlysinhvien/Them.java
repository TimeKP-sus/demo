package com.example.controller.admin.quanlysinhvien;

import java.io.IOException;

import com.example.data.ChucNangSQL;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
@WebServlet({ "/admin/danhsachsinhvien/them" })
public class Them extends HttpServlet {
    ChucNangSQL sql = new ChucNangSQL();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("danhSachLop", sql.hienThi("tblLop"));
        req.getRequestDispatcher("/admin/danhsachsinhvien/them.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        final String mssv = req.getParameter("MSSV").trim();
        final String hoTenSV = req.getParameter("HoTenSV").trim();
        final String ngaySinhSV = req.getParameter("NgaySinhSV").trim();
        final String gioiTinhSV = req.getParameter("GioiTinhSV").trim();
        final String queQuanSV = req.getParameter("QueQuanSV").trim();
        final String emailSV = req.getParameter("EmailSV").trim();
        final String maLop = req.getParameter("MaLop").trim();
        final String soDienThoaiSV = req.getParameter("SoDienThoaiSV").trim();

        Part fileAnh = req.getPart("AnhSV");
        boolean loi = false;
        if (sql.kiemTraKhoaChinh("tblSinhVien", "MSSV", mssv)) {
            req.setAttribute("loiMSSV", "Mã sinh viên đã tồn tại");
            loi = true;
        }
        if (mssv == null || mssv.isEmpty()) {
            req.setAttribute("loiMSSV", "Mã sinh viên không được để trống");
            loi = true;
        }
        if (hoTenSV == null || hoTenSV.isEmpty()) {
            req.setAttribute("loiHoTenSV", "Họ tên không được để trống");
            loi = true;
        }
        if (ngaySinhSV == null || ngaySinhSV.isEmpty()) {
            req.setAttribute("loiNgaySinhSV", "Ngày sinh không được để trống");
            loi = true;
        }
        if (gioiTinhSV == null || gioiTinhSV.isEmpty()) {
            req.setAttribute("loiGioiTinhSV", "Giới tính không được để trống");
            loi = true;
        }
        if (maLop == null || maLop.isEmpty()) {
            req.setAttribute("loiMaLop", "Lớp không được để trống");
            loi = true;
        }
        if (fileAnh == null || fileAnh.getSize() == 0) {
            req.setAttribute("loiAnhSV", "Ảnh sinh viên không được để trống");
            loi = true;
        }
        if (loi) {
            req.setAttribute("MSSV", mssv);
            req.setAttribute("HoTenSV", hoTenSV);
            req.setAttribute("NgaySinhSV", ngaySinhSV);
            req.setAttribute("GioiTinhSV", gioiTinhSV);
            req.setAttribute("QueQuanSV", queQuanSV);
            req.setAttribute("EmailSV", emailSV);
            req.setAttribute("MaLop", maLop);
            req.setAttribute("SoDienThoaiSV", soDienThoaiSV);
            req.setAttribute("AnhSV", fileAnh);

            req.setAttribute("danhSachLop", sql.hienThi("tblLop"));

            req.getRequestDispatcher("/admin/danhsachsinhvien/them.jsp").forward(req, resp);
            return;
        }
        sql.themFile(fileAnh, req.getServletContext());
        if (fileAnh != null) {
            sql.themSinhVien(mssv, hoTenSV, ngaySinhSV, gioiTinhSV, queQuanSV, emailSV, maLop, soDienThoaiSV,
                    fileAnh.getSubmittedFileName());
        }
        req.getSession().setAttribute("thongBao", "Thêm sinh viên thành công");
        resp.sendRedirect(req.getContextPath() + "/admin/danhsachsinhvien/index");
    }
}
