<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
    Connection connection = null;
    PreparedStatement statement = null;
    try {
        String url = "jdbc:mysql://localhost:3306/QuanLyLuongDNVuaVaNho";
        String username = "root";
        String password = "Huy123";

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, password);

        int payrollId = Integer.parseInt(request.getParameter("payrollId"));

        String sql = "UPDATE payroll SET paid_date = NOW() WHERE payroll_id = ?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, payrollId);
        statement.executeUpdate();

        response.sendRedirect("payroll.jsp");

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try { if (statement != null) statement.close(); } catch (SQLException e) {}
        try { if (connection != null) connection.close(); } catch (SQLException e) {}
    }
%>