<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
    int payrollId = Integer.parseInt(request.getParameter("id"));
    int employeeId = Integer.parseInt(request.getParameter("employeeId"));
    String monthYear = request.getParameter("monthYear");
    int workDays = Integer.parseInt(request.getParameter("workDays"));
    double netSalary = Double.parseDouble(request.getParameter("netSalary"));

    Connection connection = null;
    PreparedStatement statement = null;
    try {
        String url = "jdbc:mysql://localhost:3306/QuanLyLuongDNVuaVaNho";
        String username = "root";
        String password = "Huy123";

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, password);

        String sql = "UPDATE payroll SET employee_id = ?, month_year = ?, work_days = ?, net_salary = ? WHERE payroll_id = ?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, employeeId);
        statement.setString(2, monthYear);
        statement.setInt(3, workDays);
        statement.setDouble(4, netSalary);
        statement.setInt(5, payrollId);

        int rowsUpdated = statement.executeUpdate();

        if (rowsUpdated > 0) {
            out.println("<p>Bảng lương đã được cập nhật thành công!</p>");
        } else {
            out.println("<p>Có lỗi xảy ra khi cập nhật bảng lương.</p>");
        }

        // Chuyển hướng về trang danh sách bảng lương
        response.sendRedirect("payroll.jsp");

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In lỗi ra console để debug (nên dùng logger trong ứng dụng thực tế)
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In lỗi ra console để debug
        }
    }
%>