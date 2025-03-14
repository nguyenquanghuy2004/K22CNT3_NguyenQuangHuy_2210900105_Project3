<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
    int payrollId = Integer.parseInt(request.getParameter("id"));

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
        String url = "jdbc:mysql://localhost:3306/QuanLyLuongDNVuaVaNho";
        String username = "root";
        String password = "Huy123";

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, password);

        String sql = "SELECT * FROM payroll WHERE payroll_id = ?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, payrollId);
        resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int employeeId = resultSet.getInt("employee_id");
            java.sql.Date monthYear = resultSet.getDate("month_year");
            int workDays = resultSet.getInt("work_days");
            double netSalary = resultSet.getDouble("net_salary");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Sửa Bảng Lương</title>
</head>
<body>
    <h1>Sửa Bảng Lương</h1>
    <form method="post" action="update_payroll.jsp">
        <input type="hidden" name="id" value="<%= payrollId %>">
        <label>Employee ID:</label>
        <input type="number" name="employeeId" value="<%= employeeId %>"><br>
        <label>Tháng/Năm:</label>
        <input type="date" name="monthYear" value="<%= monthYear %>"><br>
        <label>Số ngày làm:</label>
        <input type="number" name="workDays" value="<%= workDays %>"><br>
        <label>Lương thực nhận:</label>
        <input type="number" name="netSalary" value="<%= netSalary %>"><br>
        <input type="submit" value="Cập nhật">
    </form>
</body>
</html>
<%
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {}
        try { if (statement != null) statement.close(); } catch (SQLException e) {}
        try { if (connection != null) connection.close(); } catch (SQLException e) {}
    }
%>