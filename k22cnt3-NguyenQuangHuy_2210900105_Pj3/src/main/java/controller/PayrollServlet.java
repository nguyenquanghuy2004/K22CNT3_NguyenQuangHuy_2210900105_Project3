package controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import dao.PayrollDAO;
import model.Payroll;

@WebServlet("/PayrollServlet") // Đường dẫn URL
public class PayrollServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html"); // Thiết lập kiểu nội dung
        PrintWriter out = response.getWriter();

        PayrollDAO payrollDAO = new PayrollDAO();
        try {
            List<Payroll> payrollList = payrollDAO.getAllPayrollRecords();
            out.println("<html><body>");
            out.println("<h1>Payroll Records</h1>");
            for (Payroll payroll : payrollList) {
                out.println("<p>Payroll ID: " + payroll.getPayrollId() + "</p>");
                out.println("<p>Employee ID: " + payroll.getEmployeeId() + "</p>");
                out.println("<p>Month/Year: " + payroll.getMonthYear() + "</p>");
                out.println("<p>Work Days: " + payroll.getWorkDays() + "</p>");
                out.println("<p>Net Salary: " + payroll.getNetSalary() + "</p>");
                out.println("<p>Created At: " + payroll.getCreatedAt() + "</p>");
                out.println("<hr>");
            }
            out.println("</body></html>");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<html><body>");
            out.println("<h1>Error</h1>");
            out.println("<p>An error occurred while retrieving payroll records.</p>");
            out.println("</body></html>");
        }
    }
}