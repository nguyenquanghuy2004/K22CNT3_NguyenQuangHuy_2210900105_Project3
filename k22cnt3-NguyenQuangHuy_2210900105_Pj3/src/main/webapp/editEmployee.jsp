<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Employee" %>
<%@ page import="dao.EmployeeDAO" %>

<%
    int employeeId = Integer.parseInt(request.getParameter("id"));
    EmployeeDAO employeeDAO = new EmployeeDAO();
    Employee employee = employeeDAO.getEmployeeById(employeeId);

    if (employee == null) {
        out.println("Không tìm thấy nhân viên!");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Chỉnh sửa nhân viên</title>
</head>
<body>
    <h1>Chỉnh sửa nhân viên</h1>
    <form action="UpdateEmployeeServlet" method="post">
        <input type="hidden" name="id" value="<%= employee.getId() %>">
        <label>Tên:</label>
        <input type="text" name="fullname" value="<%= employee.getFullname() %>"><br>
        <%-- Thêm các trường khác tương tự --%>
        <input type="submit" value="Lưu">
    </form>
</body>
</html>