<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.luong" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý Lương</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            margin-top: 30px;
        }
        .table {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="text-center">Quản lý lương nhân viên</h2>
        
        <table class="table table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Mã Nhân Viên</th>
                    <th>Lương Cơ Bản</th>
                    <th>Thưởng</th>
                    <th>Tổng Lương</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<luong> listLuong = (List<luong>) request.getAttribute("listLuong");

                    if (listLuong != null) {
                        for (luong l : listLuong) {
                %>
                <tr>
                    <td><%= l.getId() %></td>
                    <td><%= l.getLuongCoBan() %></td>
                    <td><%= l.getThuong() %></td>
                    <td><%= l.getTongLuong() %></td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="5" class="text-center">Không có dữ liệu lương</td>
                </tr>
                <% } %>
            </tbody>
        </table>

        <a href="index.jsp" class="btn btn-primary">Quay lại</a>
    </div>
</body>
</html>
