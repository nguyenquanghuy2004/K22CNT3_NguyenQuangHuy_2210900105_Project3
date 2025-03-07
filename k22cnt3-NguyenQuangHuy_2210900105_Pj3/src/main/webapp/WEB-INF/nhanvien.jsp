<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.nhanvien" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh Sách Nhân Viên</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .container {
            margin-top: 50px;
        }
        .table {
            background: white;
        }
        .table th {
            background: #007bff;
            color: white;
        }
        .header-title {
            text-align: center;
            margin-bottom: 30px;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2 class="header-title">Danh Sách Nhân Viên</h2>

        <table class="table table-bordered text-center">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Họ và Tên</th>
                    <th>Chức Vụ</th>
                    <th>Phòng Ban</th>
                    <th>Mức Lương</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<nhanvien> listNhanVien = (List<nhanvien>) request.getAttribute("listNhanVien");
                    if (listNhanVien != null && !listNhanVien.isEmpty()) {
                        for (nhanvien nv : listNhanVien) {
                %>
                <tr>
                    <td><%= nv.getId() %></td>
                    <td><%= nv.getHoTen() %></td>
                    <td><%= nv.getChucVu() %></td>
                    <td><%= nv.getPhongBan() %></td>
                    <td><%= nv.getLuong() %> VND</td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="5">Không có dữ liệu</td>
                </tr>
                <% } %>
            </tbody>
        </table>

        <a href="index.jsp" class="btn btn-secondary">Quay Lại</a>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
