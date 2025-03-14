<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Quản Lý - Quản Lý Lương Doanh Nghiệp</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <style>
        body {
            display: flex;
            font-family: 'Roboto', sans-serif;
            background-color: #f4f4f4;
        }

        .sidebar {
            width: 200px;
            background-color: #343a40;
            color: white;
            padding: 20px;
            height: 100vh;
            box-shadow: 2px 0 5px rgba(0, 0, 0, 0.2);
        }

        .sidebar ul {
            list-style: none;
            padding: 0;
        }

        .sidebar li {
            margin-bottom: 10px;
        }

        .sidebar a {
            display: block;
            padding: 10px;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .sidebar a:hover, .sidebar a.active {
            background-color: #5a6268;
        }

        .main-content {
            flex: 1;
            padding: 20px;
        }

        .feature-title {
            font-size: 24px;
            margin-bottom: 20px;
        }

        .footer {
            background-color: #343a40;
            color: white;
            padding: 15px 0;
            text-align: center;
            width: 100%;
            position: fixed;
            bottom: 0;
        }
    </style>
</head>

<body>

    <div class="sidebar">
        <ul>
            <li><a href="Employee.jsp"><i class="fas fa-users"></i> Nhân viên</a></li>
            <li><a href="AttendanceServlet"><i class="fas fa-calendar-alt"></i> Chấm công</a></li>
            <li><a href="payroll.jsp"><i class="fas fa-file-invoice-dollar"></i> Bảng lương</a></li>
            
            <li><a href="LoginServlet?action=logout"><i class="fas fa-sign-out-alt"></i> Đăng xuất</a></li>
        </ul>
    </div>

    <div class="main-content">
        <h2 class="feature-title">Trang Quản Lý</h2>
        <p>Chào mừng đến với trang quản lý lương doanh nghiệp.</p>
        </div>

    <footer class="footer">
        <p>&copy; 2025 Quản Lý Lương | Designed by YourName</p>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>