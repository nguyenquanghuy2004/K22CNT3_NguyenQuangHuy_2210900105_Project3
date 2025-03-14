package model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

public class Payroll {
    private int payrollId;
    private int employeeId;
    private LocalDate monthYear;
    private int workDays;
    private BigDecimal netSalary;
    private Timestamp createdAt;

    public Payroll(int payrollId, int employeeId, LocalDate monthYear, int workDays, BigDecimal netSalary, Timestamp createdAt) {
        this.payrollId = payrollId;
        this.employeeId = employeeId;
        this.monthYear = monthYear;
        this.workDays = workDays;
        this.netSalary = netSalary;
        this.createdAt = createdAt;
    }

    // Getters
    public int getPayrollId() {
        return payrollId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public LocalDate getMonthYear() {
        return monthYear;
    }

    public int getWorkDays() {
        return workDays;
    }

    public BigDecimal getNetSalary() {
        return netSalary;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
}