package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Admin;

public class AdminDAO {
    // Câu lệnh SQL để truy vấn admin theo username và password
    private static final String SELECT_ADMIN = 
        "SELECT AdminID, Username, Password, FullName, Email FROM Admin WHERE Username = ? AND Password = ?";

    public Admin getAdminByUsernameAndPassword(String username, String password) {
        Admin admin = null;
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ADMIN)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("AdminID");
                String uname = rs.getString("Username");
                String pwd = rs.getString("Password");
                String fullName = rs.getString("FullName");
                String email = rs.getString("Email");
                admin = new Admin(id, uname, pwd, fullName, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
