package dao;

import model.luong; 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class luongDao { // Sửa tên class theo chuẩn Java (viết hoa chữ cái đầu)
    public static List<luong> getAllLuong() { // Viết hoa chữ L trong getAllLuong
        List<luong> list = new ArrayList<>();
        String sql = "SELECT * FROM bang_luong";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {  
            while (rs.next()) {
                list.add(new luong(
                    rs.getInt("id"),
                    rs.getString("ho_ten"),
                    rs.getString("chuc_vu"),
                    rs.getDouble("luong_co_ban"),
                    rs.getDouble("thuong"),
                    rs.getDouble("tong_luong")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
