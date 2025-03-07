<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Ký - Quản lý Lương</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body { display: flex; justify-content: center; align-items: center; height: 100vh; background: #f8f9fa; }
        .register-container { width: 400px; padding: 30px; background: white; border-radius: 10px; box-shadow: 0px 0px 10px rgba(0,0,0,0.1); }
    </style>
</head>
<body>
<div class="register-container">
    <h2 class="text-center">Đăng Ký</h2>

    <% String error = request.getParameter("error"); if (error != null) { %>
        <div class="alert alert-danger">Tên đăng nhập đã tồn tại!</div>
    <% } %>

    <form action="RegisterServlet" method="post">
        <div class="mb-3">
            <label class="form-label">Tên đăng nhập</label>
            <input type="text" name="username" class="form-control" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Mật khẩu</label>
            <input type="password" name="password" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-success w-100">Đăng Ký</button>
    </form>

    <p class="mt-3 text-center">Đã có tài khoản? <a href="login.jsp">Đăng nhập</a></p>
</div>
</body>
</html>
