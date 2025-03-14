package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/QuanLyLuongDNVuaVaNho";
    private static final String USER = "root";
    private static final String PASSWORD = "Huy123";

    private static Connection connection; // Duy trì kết nối

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // Kiểm tra Driver
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                System.err.println("JDBC Driver không được tìm thấy!");
                e.printStackTrace();
                throw new SQLException("JDBC Driver không được tìm thấy.", e);
            } catch (SQLException e) {
                System.err.println("Lỗi kết nối MySQL: " + e.getMessage());
                e.printStackTrace();
                throw e;
            }
        }
        return connection;
    }
}
