package dao;

import model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // Thêm nhân viên vào CSDL
    public boolean addEmployee(Employee employee) {
        String sql = "INSERT INTO employees (fullname, position, department, email, phone, hire_date, basic_salary, bonus, status) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, employee.getFullname());
            stmt.setString(2, employee.getPosition());
            stmt.setString(3, employee.getDepartment());
            stmt.setString(4, employee.getEmail());
            stmt.setString(5, employee.getPhone());
            stmt.setDate(6, Date.valueOf(employee.getHireDate())); // Chuyển đổi LocalDate thành Date
            stmt.setBigDecimal(7, employee.getBasicSalary());
            stmt.setBigDecimal(8, employee.getBonus());
            stmt.setString(9, employee.getStatus()); // Thêm trạng thái

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Lỗi khi thêm nhân viên: " + e.getMessage());
            return false;
        }
    }

    // Lấy danh sách tất cả nhân viên từ CSDL
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                employees.add(mapResultSetToEmployee(rs));
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy danh sách nhân viên: " + e.getMessage());
        }
        return employees;
    }

    // Cập nhật thông tin nhân viên
    public boolean updateEmployee(Employee employee) {
        String sql = "UPDATE employees SET fullname = ?, position = ?, department = ?, email = ?, phone = ?, " +
                     "hire_date = ?, basic_salary = ?, bonus = ?, status = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, employee.getFullname());
            stmt.setString(2, employee.getPosition());
            stmt.setString(3, employee.getDepartment());
            stmt.setString(4, employee.getEmail());
            stmt.setString(5, employee.getPhone());
            stmt.setDate(6, Date.valueOf(employee.getHireDate()));
            stmt.setBigDecimal(7, employee.getBasicSalary());
            stmt.setBigDecimal(8, employee.getBonus());
            stmt.setString(9, employee.getStatus()); // Cập nhật trạng thái
            stmt.setInt(10, employee.getId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Lỗi khi cập nhật nhân viên: " + e.getMessage());
            return false;
        }
    }

    // Xóa nhân viên theo ID
    public boolean deleteEmployee(int employeeId) {
        String sql = "DELETE FROM employees WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, employeeId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Lỗi khi xóa nhân viên: " + e.getMessage());
            return false;
        }
    }

    // Lấy thông tin một nhân viên theo ID
    public Employee getEmployeeById(int employeeId) {
        String query = "SELECT * FROM employees WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToEmployee(rs);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy thông tin nhân viên: " + e.getMessage());
        }
        return null;
    }

    // Phương thức hỗ trợ để ánh xạ dữ liệu từ ResultSet sang Employee object
    private Employee mapResultSetToEmployee(ResultSet rs) throws SQLException {
        return new Employee(
            rs.getInt("id"),
            rs.getString("fullname"),
            rs.getString("position"),
            rs.getString("department"),
            rs.getString("email"),
            rs.getString("phone"),
            rs.getDate("hire_date").toLocalDate(), // Chuyển đổi Date sang LocalDate
            rs.getBigDecimal("basic_salary"),
            rs.getBigDecimal("bonus"),
            rs.getString("status") // Lấy trạng thái nhân viên
        );
    }
    public static String getEmployeeNameById(int employeeId) {
        String employeeName = "Không xác định";
        String sql = "SELECT fullname FROM employees WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                employeeName = rs.getString("fullname");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeName;
    }
}


