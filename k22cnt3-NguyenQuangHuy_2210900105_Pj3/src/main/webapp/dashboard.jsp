<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession sessionUser = request.getSession();
model.Admin admin = (model.Admin) sessionUser.getAttribute("loggedInAdmin");
String username = (admin != null) ? admin.getUsername() : null;
    if (username == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý Lương Doanh Nghiệp</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center">Hệ Thống Quản Lý Lương</h2>
    <p class="text-center">Chào mừng, <b><%= username %></b>!</p>
    <a href="LogoutServlet" class="btn btn-danger">Đăng xuất</a>

    <div class="mt-4">
        <h4>Bảng Lương Nhân Viên</h4>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Họ và Tên</th>
                    <th>Chức vụ</th>
                    <th>Phòng ban</th>
                    <th>Lương cơ bản</th>
                    <th>Phụ cấp</th>
                    <th>Thưởng</th>
                    <th>Tổng lương</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>Nguyễn Văn A</td>
                    <td>Giám đốc</td>
                    <td>Quản lý</td>
                    <td>50,000,000</td>
                    <td>5,000,000</td>
                    <td>10,000,000</td>
                    <td><b>65,000,000</b></td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Trần Thị B</td>
                    <td>Kế toán</td>
                    <td>Tài chính</td>
                    <td>15,000,000</td>
                    <td>2,000,000</td>
                    <td>3,000,000</td>
                    <td><b>20,000,000</b></td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
