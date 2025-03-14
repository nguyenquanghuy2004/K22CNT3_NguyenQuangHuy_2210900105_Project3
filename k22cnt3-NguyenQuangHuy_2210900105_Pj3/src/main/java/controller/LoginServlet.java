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
        // Kiểm tra nếu có yêu cầu đăng xuất
        String action = request.getParameter("action");
        if ("logout".equals(action)) {
            HttpSession session = request.getSession(false); // Lấy session nếu tồn tại
            if (session != null) {
                session.invalidate(); // Hủy session
            }
            response.sendRedirect(request.getContextPath() + "/login.jsp?logout=true");
            return;
        }

        // Nếu không phải đăng xuất, chuyển hướng về trang đăng nhập
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AdminDAO adminDAO = new AdminDAO();
        Admin admin = adminDAO.getAdminByUsernameAndPassword(username, password);

        if (admin != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedInAdmin", admin);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            String errorMsg = "Thông tin đăng nhập không chính xác!";
            String encodedMsg = URLEncoder.encode(errorMsg, StandardCharsets.UTF_8.toString());
            response.sendRedirect(request.getContextPath() + "/login.jsp?error=" + encodedMsg);
        }
    }
}
