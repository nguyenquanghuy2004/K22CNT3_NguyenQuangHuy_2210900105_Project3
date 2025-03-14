<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Nhân Viên</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 50px; }
        form { width: 400px; margin: auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; }
        label { display: block; margin-top: 10px; }
        input, select { width: 100%; padding: 8px; margin-top: 5px; }
        button { margin-top: 15px; padding: 10px; background-color: blue; color: white; border: none; cursor: pointer; }
        button:hover { background-color: darkblue; }
        .message { font-weight: bold; text-align: center; }
        .success { color: green; }
        .error { color: red; }
    </style>
</head>
<body>
    <h2>Thêm Nhân Viên Mới</h2>
    
    <form action="AddEmployeeServlet" method="post">
        <label for="fullname">Họ Tên:</label>
        <input type="text" id="fullname" name="fullname" required>

        <label for="position">Chức Vụ:</label>
        <input type="text" id="position" name="position" required>

        <label for="department">Phòng Ban:</label>
        <input type="text" id="department" name="department" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>

        <label for="phone">Số Điện Thoại:</label>
        <input type="text" id="phone" name="phone" required>

        <label for="hire_date">Ngày Tuyển Dụng:</label>
        <input type="date" id="hire_date" name="hire_date" required>

        <label for="basic_salary">Lương Cơ Bản:</label>
        <input type="number" id="basic_salary" name="basic_salary" step="0.01" required>

        <label for="bonus">Thưởng:</label>
        <input type="number" id="bonus" name="bonus" step="0.01">

        <button type="submit">Thêm Nhân Viên</button>
    </form>

    <% 
        String message = (String) request.getAttribute("message");
        if (message != null) { 
            String messageClass = message.contains("thành công") ? "success" : "error"; 
    %>
        <p class="message <%= messageClass %>"><%= message %></p>
    <% } %>

</body>
</html>
