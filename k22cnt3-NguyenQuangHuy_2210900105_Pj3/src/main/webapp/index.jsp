<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Chủ - Quản Lý Lương Doanh Nghiệp</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: #eef1f5;
            font-family: 'Roboto', sans-serif;
        }
        .navbar {
            background: #1e3a8a;
        }
        .navbar-brand, .nav-link {
            color: #ffffff !important;
        }
        .hero {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 350px;
            background: linear-gradient(135deg, #1e3a8a 40%, #4f46e5 100%);
            color: white;
            text-align: center;
        }
        .hero h1 {
            font-size: 32px;
            font-weight: bold;
        }
        .content {
            display: flex;
            justify-content: space-between;
            max-width: 1100px;
            margin: 50px auto;
            padding: 20px;
            background: white;
            box-shadow: 0px 4px 15px rgba(0,0,0,0.1);
            border-radius: 10px;
        }
        .content-text {
            max-width: 50%;
        }
        .btn-primary {
            background: #1e3a8a;
            border: none;
            padding: 12px 24px;
            font-size: 16px;
            font-weight: bold;
            border-radius: 5px;
        }
        .btn-primary:hover {
            background: #152a68;
        }
        .footer {
            background: #1e3a8a;
            color: white;
            padding: 15px 0;
            text-align: center;
            margin-top: 50px;
        }
    </style>
</head>
<body>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">Quản Lý Lương</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="index.jsp">Trang chủ</a></li>
                    <li class="nav-item"><a class="nav-link" href="login.jsp">Đăng nhập</a></li>
                    <li class="nav-item"><a class="nav-link" href="register.jsp">Đăng ký</a></li>
                    <li class="nav-item"><a class="nav-link" href="dashboard.jsp">Bảng lương</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Hero Section -->
    <div class="hero">
        <h1>Quản lý lương doanh nghiệp dễ dàng và hiệu quả</h1>
    </div>

    <!-- Nội dung chính -->
    <div class="content">
        <div class="content-text">
            <h2>Hệ thống quản lý lương chuyên nghiệp</h2>
            <p>Theo dõi bảng lương, chấm công và quản lý nhân sự với giao diện đơn giản, dễ sử dụng.</p>
            <a href="register.jsp" class="btn btn-primary">Bắt đầu ngay</a>
        </div>
        <div>
            <img src="images/salary-dashboard.png" alt="Dashboard Preview" width="400">
        </div>
    </div>

    <!-- Footer -->
    <footer class="footer">
        <p>&copy; 2025 Quản Lý Lương | Designed by YourName</p>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>