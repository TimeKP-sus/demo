package com.example.controller.taikhoan;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/taikhoan/DangNhap", name = "DangNhap")
public class DangNhap extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, java.io.IOException {

        req.getRequestDispatcher("/taikhoan/dangnhap.jsp").forward(req, resp);
    }
}
