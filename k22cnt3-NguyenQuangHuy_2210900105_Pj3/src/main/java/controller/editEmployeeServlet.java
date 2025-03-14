package controller;

import dao.EmployeeDAO;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

@WebServlet("/EditEmployeeServlet")
public class editEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Employee employee = employeeDAO.getEmployeeById(id);

        if (employee != null) {
            request.setAttribute("employee", employee);
            request.getRequestDispatcher("editEmployee.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Không tìm thấy thông tin nhân viên với ID: " + id);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String fullname = request.getParameter("fullname");
        String position = request.getParameter("position");
        String department = request.getParameter("department");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        LocalDate hireDate = LocalDate.parse(request.getParameter("hireDate"));
        BigDecimal basicSalary = new BigDecimal(request.getParameter("basicSalary"));
        BigDecimal bonus = new BigDecimal(request.getParameter("bonus"));
        String status = request.getParameter("status");

        Employee employee = new Employee(id, fullname, position, department, email, phone, hireDate, basicSalary, bonus, status);
        EmployeeDAO employeeDAO = new EmployeeDAO();

        if (employeeDAO.updateEmployee(employee)) {
            response.sendRedirect("Employee.jsp");
        } else {
            request.setAttribute("errorMessage", "Cập nhật nhân viên thất bại!");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}