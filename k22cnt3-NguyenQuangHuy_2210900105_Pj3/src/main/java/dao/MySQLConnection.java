package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/QuanLyLuongDNVuaVaNho";
    private static final String USER = "root";
    private static final String PASSWORD = "Huy123";
    private static Connection connection = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Kết nối cơ sở dữ liệu thành công!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi kết nối cơ sở dữ liệu");
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
