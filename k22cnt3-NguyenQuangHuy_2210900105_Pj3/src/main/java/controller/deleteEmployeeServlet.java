package controller;

import dao.EmployeeDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteEmployeeServlet")
public class deleteEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        EmployeeDAO employeeDAO = new EmployeeDAO();
        if (employeeDAO.deleteEmployee(id)) {
            response.sendRedirect("Employee.jsp"); // Chuyển hướng về trang danh sách nhân viên
        } else {
            request.setAttribute("errorMessage", "Xóa nhân viên thất bại!");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}