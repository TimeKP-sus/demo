package com.example.controller.admin.quanlysinhvien;

import java.io.IOException;
import java.util.Map;

import com.example.data.ChucNangSQL;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
@WebServlet({ "/admin/danhsachsinhvien/sua" })
public class Sua extends HttpServlet {
    ChucNangSQL sql = new ChucNangSQL();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String mssv = req.getParameter("MSSV");
        Map<String, Object> sv = sql.hienThi_DieuKien("tblSinhVien", "MSSV='" + mssv + "'").get(0);
        req.setAttribute("danhSachLop", sql.hienThi("tblLop"));
        req.setAttribute("sv", sv);
        req.getRequestDispatcher("/admin/danhsachsinhvien/sua.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String mssv = req.getParameter("MSSV");
        String hoTenSV = req.getParameter("HoTenSV");
        String ngaySinhSV = req.getParameter("NgaySinhSV");
        String gioiTinhSV = req.getParameter("GioiTinhSV");
        String queQuanSV = req.getParameter("QueQuanSV");
        String emailSV = req.getParameter("EmailSV");
        String maLop = req.getParameter("MaLop");
        String soDienThoaiSV = req.getParameter("SoDienThoaiSV");
        Part fileAnh = req.getPart("AnhSV");
        sql.themFile(fileAnh, req.getServletContext());

        sql.suaSinhVien(mssv, hoTenSV, ngaySinhSV, gioiTinhSV, queQuanSV, emailSV, maLop, soDienThoaiSV,
                fileAnh.getSubmittedFileName());
        req.getSession().setAttribute("thongBao", "Sửa sinh viên thành công");
        resp.sendRedirect(req.getContextPath() + "/admin/danhsachsinhvien/index");
    }
}
