package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Payroll;

import java.math.BigDecimal;

public class PayrollDAO {
    public List<Payroll> getAllPayrollRecords() throws SQLException {
        List<Payroll> payrollList = new ArrayList<>();
        String sql = "SELECT * FROM payroll";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Payroll payroll = new Payroll(
                        resultSet.getInt("payroll_id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getDate("month_year").toLocalDate(),
                        resultSet.getInt("work_days"),
                        resultSet.getBigDecimal("net_salary"),
                        resultSet.getTimestamp("created_at")
                );
                payrollList.add(payroll);
            }
        }
        return payrollList;
    }
}