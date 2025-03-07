package controller;

import model.nhanvien;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/nhanvien")
public class nhanvienServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<nhanvien> listNhanVien = new ArrayList<>();
        listNhanVien.add(new nhanvien(1, "Nguyễn Văn A", "Giám đốc", "Quản lý", 30000000));
        listNhanVien.add(new nhanvien(2, "Trần Thị B", "Kế toán", "Tài chính", 15000000));

        request.setAttribute("listNhanVien", listNhanVien);
        request.getRequestDispatcher("nhanvien.jsp").forward(request, response);
    }
}
