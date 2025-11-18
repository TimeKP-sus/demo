package com.example.controller.admin.quanlykhoa;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.example.data.ChucNangSQL;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/admin/danhsachkhoa", "/admin/danhsachkhoa/index" })
public class Index extends HttpServlet {
    ChucNangSQL sql = new ChucNangSQL();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Map<String, Object>> danhsach = sql.hienThi("tblKhoa");
        sql.boSungDS(danhsach, "TenVien", "tblVien", "MaVien");
        req.setAttribute("danhSachKhoa", danhsach);
        req.getRequestDispatcher("/admin/danhsachkhoa/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String[] maKhoa = req.getParameterValues("MaKhoa");
        if (maKhoa != null) {
            for (String ma : maKhoa) {
                sql.xoaBanGhi("tblKhoa", "MaKhoa = '" + ma + "'");
            }
        }
        req.getSession().setAttribute("thongBao", "Xóa các khoa đã chọn thành công");
        resp.sendRedirect(req.getContextPath() + "/admin/danhsachkhoa");
    }
}
