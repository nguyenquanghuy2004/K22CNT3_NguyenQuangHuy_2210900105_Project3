package controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/AddPayrollServlet")
public class AddPayrollServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String employeeIdStr = request.getParameter("employeeId"); // Lấy employeeId từ request
        String monthYear = request.getParameter("monthYear");
        String workDaysStr = request.getParameter("workDays");
        String netSalaryStr = request.getParameter("netSalary");

        if (employeeIdStr == null || employeeIdStr.isEmpty() ||
            monthYear == null || monthYear.isEmpty() ||
            workDaysStr == null || workDaysStr.isEmpty() ||
            netSalaryStr == null || netSalaryStr.isEmpty()) {
            out.println("<p>Vui lòng nhập đầy đủ thông tin bảng lương.</p>");
            return;
        }

        try {
            int employeeId = Integer.parseInt(employeeIdStr);

            // Kiểm tra employeeId trong bảng employees
            if (!employeeExists(employeeId, out)) {
                return;
            }

            // Chuyển đổi và thêm dữ liệu vào bảng payroll
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedMonthYear = dateFormat.parse(monthYear);
            java.sql.Date sqlMonthYear = new java.sql.Date(parsedMonthYear.getTime());

            int workDays = Integer.parseInt(workDaysStr);
            double netSalary = Double.parseDouble(netSalaryStr);

            if (insertPayroll(employeeId, sqlMonthYear, workDays, netSalary, out)) {
                response.sendRedirect("payroll.jsp");
            }

        } catch (NumberFormatException e) {
            out.println("<p>Lỗi định dạng số: Vui lòng nhập số hợp lệ cho ID nhân viên, số ngày làm và lương thực nhận.</p>");
        } catch (ParseException e) {
            out.println("<p>Lỗi định dạng ngày: Vui lòng nhập ngày tháng năm hợp lệ (yyyy-MM-dd).</p>");
        }
    }

    private boolean employeeExists(int employeeId, PrintWriter out) {
        Connection checkConnection = null;
        PreparedStatement checkStatement = null;
        ResultSet checkResultSet = null;
        try {
            String checkUrl = "jdbc:mysql://localhost:3306/QuanLyLuongDNVuaVaNho";
            String checkUsername = "root";
            String checkPassword = "Huy123";

            Class.forName("com.mysql.cj.jdbc.Driver");
            checkConnection = DriverManager.getConnection(checkUrl, checkUsername, checkPassword);

            // Kiểm tra employeeId trong bảng employees bằng cách sử dụng cột id
            String checkSql = "SELECT id, basic_salary FROM employees WHERE id = ?";
            checkStatement = checkConnection.prepareStatement(checkSql);
            checkStatement.setInt(1, employeeId);
            checkResultSet = checkStatement.executeQuery();

            if (!checkResultSet.next()) {
                out.println("<p>Lỗi: ID nhân viên không tồn tại trong bảng employees.</p>");
                return false;
            }
            return true;

        } catch (SQLException | ClassNotFoundException checkE) {
            checkE.printStackTrace();
            out.println("<p>Lỗi kiểm tra ID nhân viên: " + checkE.getMessage() + "</p>");
            return false;
        } finally {
            closeResources(checkResultSet, checkStatement, checkConnection);
        }
    }

    private boolean insertPayroll(int employeeId, Date sqlMonthYear, int workDays, double netSalary, PrintWriter out) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            String url = "jdbc:mysql://localhost:3306/QuanLyLuongDNVuaVaNho";
            String username = "root";
            String password = "Huy123";

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO payroll (employee_id, month_year, work_days, net_salary) VALUES (?, ?, ?, ?)"; // Sử dụng employee_id
            statement = connection.prepareStatement(sql);
            statement.setInt(1, employeeId);
            statement.setDate(2, sqlMonthYear);
            statement.setInt(3, workDays);
            statement.setDouble(4, netSalary);

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                out.println("<p>Bảng lương đã được thêm thành công!</p>");
                return true;
            } else {
                out.println("<p>Có lỗi xảy ra khi thêm bảng lương.</p>");
                return false;
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            out.println("<p>Lỗi cơ sở dữ liệu: " + e.getMessage() + "</p>");
            return false;
        } finally {
            closeResources(null, statement, connection);
        }
    }

    private void closeResources(ResultSet rs, Statement stmt, Connection conn) {
        try { if (rs != null) rs.close(); } catch (SQLException e) {}
        try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
        try { if (conn != null) conn.close(); } catch (SQLException e) {}
    }
}