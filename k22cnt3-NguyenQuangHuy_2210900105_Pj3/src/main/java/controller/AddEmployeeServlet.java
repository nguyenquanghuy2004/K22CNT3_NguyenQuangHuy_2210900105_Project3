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

@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullname = request.getParameter("fullname");
        String position = request.getParameter("position");
        String department = request.getParameter("department");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        LocalDate hireDate = LocalDate.parse(request.getParameter("hire_date"));
        BigDecimal basicSalary = new BigDecimal(request.getParameter("basic_salary"));
        BigDecimal bonus = new BigDecimal(request.getParameter("bonus"));

        // Lấy giá trị status từ request
        String status = request.getParameter("status");

        // Kiểm tra nếu status rỗng hoặc null, thì gán giá trị mặc định
        if (status == null || status.trim().isEmpty()) {
            status = "Đang làm việc"; // Giá trị mặc định
        }

        Employee employee = new Employee(fullname, position, department, email, phone, hireDate, basicSalary, bonus, status);
        EmployeeDAO employeeDAO = new EmployeeDAO();

        if (employeeDAO.addEmployee(employee)) {
            request.setAttribute("message", "Thêm nhân viên thành công!");
            request.getRequestDispatcher("Employee.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Thêm nhân viên thất bại!");
            request.getRequestDispatcher("Employee.jsp").forward(request, response);
        }
    }
}