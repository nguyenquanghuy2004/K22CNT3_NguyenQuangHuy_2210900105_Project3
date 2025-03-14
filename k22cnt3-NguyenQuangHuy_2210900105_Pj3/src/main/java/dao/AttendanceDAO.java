package dao;
import model.Attendance;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dao.DatabaseConnection;
import java.time.LocalDate;

public class AttendanceDAO {

    // Thêm chấm công mới
    public boolean addAttendance(Attendance attendance) {
        String sql = "INSERT INTO attendance (employee_id, month_year, work_days, late_days) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, attendance.getEmployeeId());
            stmt.setDate(2, Date.valueOf(attendance.getMonthYear()));
            stmt.setInt(3, attendance.getWorkDays());
            stmt.setInt(4, attendance.getLateDays());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Lấy danh sách tất cả chấm công
    public List<Attendance> getAllAttendance() {
        List<Attendance> attendanceList = new ArrayList<>();
        String sql = "SELECT * FROM attendance";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Attendance attendance = new Attendance(
                    rs.getInt("attendance_id"),
                    rs.getInt("employee_id"),
                    rs.getDate("month_year").toLocalDate(),
                    rs.getInt("work_days"),
                    rs.getInt("late_days"),
                    rs.getTimestamp("created_at")
                );
                attendanceList.add(attendance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendanceList;
    }

    // Lấy thông tin chấm công theo ID
    public Attendance getAttendanceById(int id) {
        String sql = "SELECT * FROM attendance WHERE attendance_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Attendance(
                    rs.getInt("attendance_id"),
                    rs.getInt("employee_id"),
                    rs.getDate("month_year").toLocalDate(),
                    rs.getInt("work_days"),
                    rs.getInt("late_days"),
                    rs.getTimestamp("created_at")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Cập nhật thông tin chấm công
    public boolean updateAttendance(Attendance attendance) {
        String sql = "UPDATE attendance SET employee_id = ?, month_year = ?, work_days = ?, late_days = ? WHERE attendance_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, attendance.getEmployeeId());
            stmt.setDate(2, Date.valueOf(attendance.getMonthYear()));
            stmt.setInt(3, attendance.getWorkDays());
            stmt.setInt(4, attendance.getLateDays());
            stmt.setInt(5, attendance.getAttendanceId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa chấm công theo ID
    public boolean deleteAttendance(int id) {
        String sql = "DELETE FROM attendance WHERE attendance_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
