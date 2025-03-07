package dao;

import model.nhanvien;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class nhanvienDao {

    // Lấy danh sách tất cả nhân viên
    public static List<nhanvien> getAllNhanVien() {
        List<nhanvien> list = new ArrayList<>();
        String sql = "SELECT * FROM nhan_vien";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {  

            while (rs.next()) {
                list.add(new nhanvien(
                    rs.getInt("id"),
                    rs.getString("ho_ten"),
                    rs.getString("chuc_vu"),
                    rs.getString("phong_ban"),
                    rs.getDouble("luong_co_ban")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy thông tin nhân viên theo ID
    public static nhanvien getNhanVienById(int id) {
        String sql = "SELECT * FROM nhan_vien WHERE id = ?";
        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new nhanvien(
                    rs.getInt("id"),
                    rs.getString("ho_ten"),
                    rs.getString("chuc_vu"),
                    rs.getString("phong_ban"),
                    rs.getDouble("luong_co_ban")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Thêm nhân viên mới
    public static boolean addNhanVien(nhanvien nv) {
        String sql = "INSERT INTO nhan_vien (ho_ten, chuc_vu, phong_ban, luong_co_ban) VALUES (?, ?, ?, ?)";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nv.getHoTen());
            stmt.setString(2, nv.getChucVu());
            stmt.setString(3, nv.getPhongBan());
            stmt.setDouble(4, nv.getLuong());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Cập nhật thông tin nhân viên
    public static boolean updateNhanVien(nhanvien nv) {
        String sql = "UPDATE nhan_vien SET ho_ten = ?, chuc_vu = ?, phong_ban = ?, luong_co_ban = ? WHERE id = ?";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nv.getHoTen());
            stmt.setString(2, nv.getChucVu());
            stmt.setString(3, nv.getPhongBan());
            stmt.setDouble(4, nv.getLuong());
            stmt.setInt(5, nv.getId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa nhân viên theo ID
    public static boolean deleteNhanVien(int id) {
        String sql = "DELETE FROM nhan_vien WHERE id = ?";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
