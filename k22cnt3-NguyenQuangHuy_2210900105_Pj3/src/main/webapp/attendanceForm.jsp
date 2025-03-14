<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Attendance" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
    Attendance attendance = (Attendance) request.getAttribute("attendance");
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String title = (attendance == null) ? "Thêm Chấm Công" : "Sửa Chấm Công";
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%= title %></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2><%= title %></h2>
        <form action="AttendanceServlet" method="post">
            <input type="hidden" name="action" value="<%= (attendance == null) ? "insert" : "update" %>">
            <input type="hidden" name="attendanceId" value="<%= (attendance != null) ? attendance.getAttendanceId() : "" %>">

            <div class="mb-3">
                <label for="employeeId" class="form-label">ID Nhân Viên:</label>
                <input type="number" class="form-control" id="employeeId" name="employeeId" value="<%= (attendance != null) ? attendance.getEmployeeId() : "" %>" required>
            </div>

            <div class="mb-3">
                <label for="monthYear" class="form-label">Tháng/Năm:</label>
                <input type="date" class="form-control" id="monthYear" name="monthYear" value="<%= (attendance != null) ? dateFormat.format(attendance.getMonthYear()) : "" %>" required>
            </div>

            <div class="mb-3">
                <label for="workDays" class="form-label">Số Ngày Làm Việc:</label>
                <input type="number" class="form-control" id="workDays" name="workDays" value="<%= (attendance != null) ? attendance.getWorkDays() : "" %>" required>
            </div>

            <div class="mb-3">
                <label for="lateDays" class="form-label">Số Ngày Đi Muộn:</label>
                <input type="number" class="form-control" id="lateDays" name="lateDays" value="<%= (attendance != null) ? attendance.getLateDays() : "" %>" required>
            </div>

            <button type="submit" class="btn btn-primary">Lưu</button>
            <a href="AttendanceServlet" class="btn btn-secondary">Hủy</a>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>