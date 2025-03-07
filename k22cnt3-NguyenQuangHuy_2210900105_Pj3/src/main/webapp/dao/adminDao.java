package controller;

import dao.AdminDAO;
import model.Admin;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Nếu người dùng truy cập bằng phương thức GET, chuyển hướng về trang đăng nhập
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy thông tin đăng nhập từ form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Tạo đối tượng DAO để kiểm tra thông tin đăng nhập
        AdminDAO adminDAO = new AdminDAO();
        Admin admin = adminDAO.getAdminByUsernameAndPassword(username, password);

        if (admin != null) {
            // Đăng nhập thành công: lưu thông tin admin vào session
            HttpSession session = request.getSession();
            session.setAttribute("loggedInAdmin", admin);

            // Chuyển hướng đến trang quản lý lương
            response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
        } else {
            // Đăng nhập thất bại: chuyển hướng về trang đăng nhập với thông báo lỗi
            String errorMsg = "Tên đăng nhập hoặc mật khẩu không chính xác!";
            String encodedMsg = URLEncoder.encode(errorMsg, StandardCharsets.UTF_8.toString());
            response.sendRedirect(request.getContextPath() + "/login.jsp?error=" + encodedMsg);
        }
    }
}