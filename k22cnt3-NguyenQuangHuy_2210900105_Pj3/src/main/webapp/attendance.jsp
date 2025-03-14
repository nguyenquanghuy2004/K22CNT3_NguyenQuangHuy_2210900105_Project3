<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, model.Attendance" %>
<%
    List<Attendance> attendanceList = (List<Attendance>) request.getAttribute("attendanceList");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Chấm Công</title>
</head>
<body>
    <h2>Danh Sách Chấm Công</h2>
    <a href="add_attendance.jsp">Thêm Chấm Công</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>ID Nhân Viên</th>
            <th>Tháng/Năm</th>
            <th>Số Ngày Làm Việc</th>
            <th>Số Ngày Đi Muộn</th>
            <th>Ngày Tạo</th>
        </tr>
        <% for (Attendance att : attendanceList) { %>
            <tr>
                <td><%= att.getAttendanceId() %></td>
                <td><%= att.getEmployeeId() %></td>
                <td><%= att.getMonthYear() %></td>
                <td><%= att.getWorkDays() %></td>
                <td><%= att.getLateDays() %></td>
                <td><%= att.getCreatedAt() %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>
