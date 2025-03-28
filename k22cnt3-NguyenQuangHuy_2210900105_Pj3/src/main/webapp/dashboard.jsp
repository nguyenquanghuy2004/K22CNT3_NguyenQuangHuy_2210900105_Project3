<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Employee" %>
<%@ page import="dao.EmployeeDAO" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    // Kiểm tra đăng nhập
    HttpSession sessionUser = request.getSession();
    model.Admin admin = (model.Admin) sessionUser.getAttribute("loggedInAdmin");

    if (admin == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String username = admin.getUsername();

    // Lấy danh sách nhân viên từ database
    EmployeeDAO employeeDAO = new EmployeeDAO();
    List<Employee> employees = employeeDAO.getAllEmployees();
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Nhân Viên</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        h2, h4 {
            text-align: center;
            color: #007bff;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <h2>Quản Lý Nhân Viên</h2>
    <p class="text-center">Chào mừng, <b><%= username %></b>!</p>
    
    <div class="text-center mb-3">
        <a href="<%= contextPath %>/LoginServlet?action=logout" class="btn btn-danger">Đăng xuất</a>
    </div>
    <div class="text-center mb-3">
        <a href="<%= contextPath %>/payroll.jsp" class="btn btn-success">trả lương</a>
    </div>
    

    <h4>Danh Sách Nhân Viên</h4>
    <div class="text-end mb-3">
        <a href="add_employee.jsp" class="btn btn-success">Thêm Nhân Viên</a>
    </div>

    <% if (employees.isEmpty()) { %>
        <p class="text-center text-danger">Không có nhân viên nào!</p>
    <% } else { %>
        <table class="table table-bordered text-center">
            <thead class="table-primary">
                <tr>
                    <th>ID</th>
                    <th>Họ và Tên</th>
                    <th>Chức vụ</th>
                    <th>Phòng ban</th>
                    <th>Email</th>
                    <th>Điện thoại</th>
                    <th>Ngày vào làm</th>
                    <th>Lương cơ bản</th>
                    <th>Thưởng</th>
                    <th>Hành động</th>
                </tr>
            </thead>
            <tbody>
                <% for (Employee emp : employees) { %>
                    <tr>
                        <td><%= emp.getId() %></td>
                        <td><%= emp.getFullname() %></td>
                        <td><%= emp.getPosition() %></td>
                        <td><%= emp.getDepartment() %></td>
                        <td><%= emp.getEmail() %></td>
                        <td><%= emp.getPhone() %></td>
                        <td><%= emp.getHireDate() %></td>
                        <td><%= emp.getBasicSalary().toPlainString() %> VND</td>
                        <td><%= emp.getBonus().toPlainString() %> VND</td>
                        <td>
                            <a href="editEmployee.jsp?id=<%= emp.getId() %>" class="btn btn-warning btn-sm">Sửa</a>
                           <a href="<%= contextPath %>/DeleteEmployeeServlet?id=<%= emp.getId() %>" class="btn btn-danger btn-sm"
                              onclick="return confirm('Bạn có chắc chắn muốn sa thải nhân viên này?');">Sa thải</a>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    <% } %>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
