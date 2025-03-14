<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*, dao.EmployeeDAO, model.Employee" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<%
    String idParam = request.getParameter("id");
    Employee employee = null;
    String errorMessage = null;

// Kiểm tra nếu ID hợp lệ
    if (idParam != null) {
        try {
            int id = Integer.parseInt(idParam);
            employee = new EmployeeDAO().getEmployeeById(id);
        } catch (Exception e) {
            errorMessage = "Lỗi khi tải thông tin nhân viên!";
        }
    } else {
        errorMessage = "Không tìm thấy nhân viên!";
    }

// Định dạng ngày để hiển thị trong input date
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
%>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Nhân Viên</title>
</head>
<body>

<% if (errorMessage != null) { %>
    <p style="color: red;"><%= errorMessage %></p>
<% } else if (employee != null) { %>

    <h2>Cập Nhật Thông Tin Nhân Viên</h2>
    <form action="UpdateEmployeeServlet" method="post">
        <input type="hidden" name="id" value="<%= employee.getId() %>">

        <label>Họ và Tên:</label>
        <input type="text" name="fullname" value="<%= employee.getFullname() %>" required><br>

        <label>Chức Vụ:</label>
        <input type="text" name="position" value="<%= employee.getPosition() %>" required><br>

        <label>Phòng Ban:</label>
        <input type="text" name="department" value="<%= employee.getDepartment() %>" required><br>

        <label>Email:</label>
        <input type="email" name="email" value="<%= employee.getEmail() %>" required><br>

        <label>Số Điện Thoại:</label>
        <input type="text" name="phone" value="<%= employee.getPhone() %>" required><br>

        <label>Ngày Vào Làm:</label>
        <input type="date" name="hire_date" value="<%= employee.getHireDate().format(dateFormatter) %>" required><br>

        <label>Lương Cơ Bản:</label>
        <input type="number" step="0.01" name="basic_salary" value="<%= employee.getBasicSalary() %>" required><br>

        <label>Thưởng:</label>
        <input type="number" step="0.01" name="bonus" value="<%= employee.getBonus() %>"><br>

        <label>Trạng Thái:</label>
        <select name="status">
            <option value="active" <%= employee.getStatus().equals("active") ? "selected" : "" %>>Đang làm việc</option>
            <option value="inactive" <%= employee.getStatus().equals("inactive") ? "selected" : "" %>>Nghỉ việc</option>
        </select><br>

        <input type="submit" value="Cập Nhật">
    </form>

<% } else { %>
    <p style="color: red;">Không tìm thấy nhân viên!</p>
<% } %>

</body>
</html>
