package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Admin;

public class AdminDAO {
    
    // Phương thức kiểm tra đăng nhập (có hay không)
    public static boolean login(String username, String password) {
        String query = "SELECT * FROM Admin WHERE Username = ? AND Password = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // Nếu có dữ liệu trả về => đăng nhập thành công
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Phương thức lấy Admin theo username & password
    public Admin getAdminByUsernameAndPassword(String username, String password) {
        String query = "SELECT * FROM Admin WHERE Username = ? AND Password = ?";
        Admin admin = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    admin = new Admin();
                    admin.setAdminID(rs.getInt("AdminID"));
                    admin.setUsername(rs.getString("Username"));
                    admin.setPassword(rs.getString("Password")); // Trong thực tế nên dùng Hash mật khẩu
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
