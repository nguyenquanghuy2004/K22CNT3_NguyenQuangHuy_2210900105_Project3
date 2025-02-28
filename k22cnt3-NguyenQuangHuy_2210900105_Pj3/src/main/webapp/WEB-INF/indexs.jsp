<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang chủ - Quản lý Doanh nghiệp</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin: 50px;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        li {
            display: inline;
            margin: 0 15px;
        }
        a {
            text-decoration: none;
            color: blue;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <h1>Hệ thống Quản lý Doanh nghiệp</h1>
    <p>Chào mừng bạn đến với hệ thống quản lý doanh nghiệp vừa và nhỏ.</p>
    <p>Vui lòng chọn một chức năng để bắt đầu:</p>
    <ul>
        <li><a href="employee.jsp">Quản lý Nhân sự</a></li>
        <li><a href="finance.jsp">Quản lý Tài chính</a></li>
        <li><a href="inventory.jsp">Quản lý Kho hàng</a></li>
        <li><a href="customers.jsp">Quản lý Khách hàng</a></li>
    </ul>
    <footer>
        <p>&copy; 2025 Hệ thống Quản lý Doanh nghiệp | Liên hệ: support@company.com</p>
    </footer>
</body>
</html>
