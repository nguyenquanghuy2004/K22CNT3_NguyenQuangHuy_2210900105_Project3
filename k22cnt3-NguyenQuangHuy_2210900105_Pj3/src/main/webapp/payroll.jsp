<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
<head>
    <title>Danh sách Bảng Lương</title>
    <style>
        body {
            font-family: sans-serif;
            margin: 20px;
        }
        h1 {
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }

        .pay-button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 5px 10px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 5px;
        }

        .pay-button:hover {
            background-color: #3e8e41;
        }

        .edit-link {
            background-color: #008CBA;
            border: none;
            color: white;
            padding: 5px 10px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 5px;
        }

        .edit-link:hover {
            background-color: #005f6b;
        }

        .delete-link {
            background-color: #f44336;
            border: none;
            color: white;
            padding: 5px 10px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 5px;
        }

        .delete-link:hover {
            background-color: #d32f2f;
        }

        .add-form {
            width: 300px;
            margin: 20px auto;
            border: 1px solid #ddd;
            padding: 20px;
            border-radius: 5px;
        }

        .add-form label {
            display: block;
            margin-bottom: 5px;
        }

        .add-form input[type="number"],
        .add-form input[type="date"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .add-form input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }

        .add-form input[type="submit"]:hover {
            background-color: #45a049;
        }

        .add-link {
            display: block;
            text-align: center;
            margin-top: 10px;
        }

    </style>
</head>
<body>
    <h1>Danh sách Bảng Lương</h1>

    <div class="add-form">
        <h2>Thêm bảng lương mới</h2>
        <form method="post" action="AddPayrollServlet">
            <label> ID:</label>
            <input type="number" name="Id" required><br>
            <label>Tháng/Năm:</label>
            <input type="date" name="monthYear" required><br>
            <label>Số ngày làm:</label>
            <input type="number" name="workDays" required><br>
            <label>Lương thực nhận:</label>
            <input type="number" name="netSalary" required><br>
            <input type="submit" value="Thêm">
        </form>
    </div>

    <table>
        <thead>
            <tr>
                <th>id Bảng Lương</th>
                <th>Employee id</th>
                <th>Tháng/Năm</th>
                <th>Số ngày làm</th>
                <th>Lương thực nhận</th>
                <th>Ngày tạo</th>
                <th>Trạng thái</th>
                <th>Hành động</th>
               
            </tr>
        </thead>
        <tbody>
            <%
                Connection connection = null;
                PreparedStatement statement = null;
                ResultSet resultSet = null;
                try {
                    String url = "jdbc:mysql://localhost:3306/QuanLyLuongDNVuaVaNho";
                    String username = "root";
                    String password = "Huy123";

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(url, username, password);

                    String sql = "SELECT * FROM payroll";
                    statement = connection.prepareStatement(sql);
                    resultSet = statement.executeQuery();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                    while (resultSet.next()) {
                        int payrollId = resultSet.getInt("payroll_id");
                        int employeeId = resultSet.getInt("employee_id");
                        java.sql.Date monthYear = resultSet.getDate("month_year");
                        int workDays = resultSet.getInt("work_days");
                        double netSalary = resultSet.getDouble("net_salary");
                        Timestamp createdAt = resultSet.getTimestamp("created_at");
                        Timestamp paidDate = resultSet.getTimestamp("paid_date");

            %>
            <tr>
                <td><%= payrollId %></td>
                <td><%= employeeId %></td>
                <td><%= monthYear %></td>
                <td><%= workDays %></td>
                <td><%= netSalary %></td>
                <td><%= dateFormat.format(createdAt) %></td>
                <td>
                    <%
                        if (paidDate == null) {
                            out.println("Chưa trả");
                        } else {
                            out.println("Đã trả");
                        }
                    %>
                </td>
                <td>
                   
                    <a href="edit_payroll.jsp?id=<%= payrollId %>" class="edit-link">Sửa</a>               
                    <a href="delete_payroll.jsp?id=<%= payrollId %>" class="delete-link" onclick="return confirm('Bạn có chắc chắn muốn xóa?');">Xóa</a>
                    
                </td>
            </tr>
            <%
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try { if (resultSet != null) resultSet.close(); } catch (SQLException e) {}
                    try { if (statement != null) statement.close(); } catch (SQLException e) {}
                    try { if (connection != null) connection.close(); } catch (SQLException e) {}
                }
            %>
        </tbody>
    </table>
</body>
</html>
