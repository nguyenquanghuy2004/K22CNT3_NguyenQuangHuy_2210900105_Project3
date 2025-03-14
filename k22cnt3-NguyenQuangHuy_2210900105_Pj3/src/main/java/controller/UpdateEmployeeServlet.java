package controller;

import dao.EmployeeDAO;
import model.Employee;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Lấy dữ liệu từ form
            int id = Integer.parseInt(request.getParameter("id"));
            String fullname = request.getParameter("fullname");
            String position = request.getParameter("position");
            String department = request.getParameter("department");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            LocalDate hireDate = LocalDate.parse(request.getParameter("hire_date"));
            BigDecimal basicSalary = new BigDecimal(request.getParameter("basic_salary"));
            BigDecimal bonus = new BigDecimal(request.getParameter("bonus"));
            String status = request.getParameter("status");

            // Tạo đối tượng Employee
            Employee employee = new Employee(id, fullname, position, department, email, phone, hireDate, basicSalary, bonus, status);

            // Cập nhật thông tin nhân viên
            EmployeeDAO employeeDAO = new EmployeeDAO();
            boolean isUpdated = employeeDAO.updateEmployee(employee);

            if (isUpdated) {
                response.sendRedirect("employee_list.jsp?success=1");
            } else {
                response.sendRedirect("update_employee.jsp?id=" + id + "&error=1");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("update_employee.jsp?id=" + request.getParameter("id") + "&error=1");
        }
    }
}
