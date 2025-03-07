<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="model.Admin" %>
<%
    Admin admin = (Admin) session.getAttribute("admin");
    if (admin != null) {
        // Nếu đã đăng nhập, chuyển hướng về dashboard
        response.sendRedirect("../dashboard.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Đăng nhập Admin</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .login-container {
            margin-top: 100px;
        }
        .card {
            border-radius: 10px;
        }
        .alert {
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
    <div class="container login-container">
        <div class="row justify-content-center">
            <div class="col-md-4">
                <div class="card shadow">
                    <div class="card-header text-center bg-primary text-white">
                        <h4>Đăng nhập hệ thống</h4>
                    </div>
                    <div class="card-body">
                        <% String error = (String) request.getAttribute("error"); %>
                        <% if (error != null) { %>
                            <div class="alert alert-danger text-center"><%= error %></div>
                        <% } %>
                        <!-- Gửi form đến /LoginServlet -->
                        <form action="<%= request.getContextPath() %>/LoginServlet" method="post">
                            <div class="mb-3">
                                <label for="username" class="form-label">Tên đăng nhập</label>
                                <input type="text" class="form-control" id="username" name="username" required autofocus>
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">Mật khẩu</label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>
                            <button type="submit" class="btn btn-primary w-100">Đăng nhập</button>
                        </form>
                    </div>
                </div>
                <div class="text-center mt-3">
                    <a href="../index.jsp">Quay lại trang chủ</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>