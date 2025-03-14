<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
    int payrollId = Integer.parseInt(request.getParameter("id"));

    Connection connection = null;
    PreparedStatement statement = null;
    try {
        String url = "jdbc:mysql://localhost:3306/QuanLyLuongDNVuaVaNho";
        String username = "root";
        String password = "Huy123";

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, password);

        String sql = "DELETE FROM payroll WHERE payroll_id = ?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1, payrollId);

        int rowsDeleted = statement.executeUpdate();

        if (rowsDeleted > 0) {
            out.println("<p>Bảng lương đã được xóa thành công!</p>");
        } else {
            out.println("<p>Có lỗi xảy ra khi xóa bảng lương.</p>");
        }

        // Chuyển hướng về trang danh sách bảng lương
        response.sendRedirect("payroll.jsp");

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (statement != null)
                statement.close();
        } catch (SQLException e) {
        }
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
        }
    }
%>