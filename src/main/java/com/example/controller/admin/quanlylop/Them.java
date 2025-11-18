package com.example.controller.admin.quanlylop;

import java.io.IOException;

import com.example.data.ChucNangSQL;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/admin/danhsachlop/them" })
public class Them extends HttpServlet {
    ChucNangSQL sql = new ChucNangSQL();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("danhSachNganh", sql.hienThi("tblNganh"));
        req.getRequestDispatcher("/admin/danhsachlop/them.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        final String maLop = req.getParameter("MaLop").trim();
        final String tenLop = req.getParameter("TenLop").trim();
        final int khoaHoc = Integer.parseInt(req.getParameter("KhoaHoc"));
        final String maNganh = req.getParameter("MaNganh").trim();
        boolean loi = false;
        if (sql.kiemTraKhoaChinh("tblLop", "MaLop", maLop)) {
            req.setAttribute("loiMaLop", "Mã lớp đã tồn tại");
            loi = true;
        }
        if (maLop == null || maLop.isEmpty()) {
            req.setAttribute("loiMaLop", "Mã lớp không được để trống");
            loi = true;
        }
        if (tenLop == null || tenLop.isEmpty()) {
            req.setAttribute("loiTenLop", "Tên lớp không được để trống");
            loi = true;
        }
        if (maNganh == null || maNganh.isEmpty()) {
            req.setAttribute("loiMaNganh", "Ngành không được để trống");
            loi = true;
        }
        if (loi) {
            req.setAttribute("MaLop", maLop);
            req.setAttribute("TenLop", tenLop);
            req.setAttribute("KhoaHoc", khoaHoc);
            req.setAttribute("MaNganh", maNganh);

            req.setAttribute("danhSachNganh", sql.hienThi("tblNganh"));

            req.getRequestDispatcher("/admin/danhsachlop/them.jsp").forward(req, resp);
            return;
        }
        sql.themLop(maLop, khoaHoc, tenLop, maNganh);
        req.getSession().setAttribute("thongBao", "Thêm lớp thành công");
        resp.sendRedirect(req.getContextPath() + "/admin/danhsachlop/index");
    }
}
