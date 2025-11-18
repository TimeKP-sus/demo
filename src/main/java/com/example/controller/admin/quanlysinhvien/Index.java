package com.example.controller.admin.quanlysinhvien;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.example.data.ChucNangSQL;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/admin/danhsachsinhvien", "/admin/danhsachsinhvien/index" })
public class Index extends HttpServlet {
    ChucNangSQL sql = new ChucNangSQL();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Map<String, Object>> danhsach = sql.hienThi("tblSinhVien");
        sql.boSungDS(danhsach, "TenLop", "tblLop", "MaLop");
        req.setAttribute("danhSachSinhVien", danhsach);
        req.getRequestDispatcher("/admin/danhsachsinhvien/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String[] mssv = req.getParameterValues("MSSV");
        if (mssv != null) {
            for (String ma : mssv) {
                sql.xoaBanGhi("tblSinhVien", "MSSV = '" + ma + "'");
            }
        }
        req.getSession().setAttribute("thongBao", "Xóa các sinh viên đã chọn thành công");
        resp.sendRedirect(req.getContextPath() + "/admin/danhsachsinhvien");
    }
}
