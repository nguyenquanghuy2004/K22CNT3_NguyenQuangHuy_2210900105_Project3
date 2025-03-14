package model;
import java.time.LocalDate;
import java.sql.Timestamp;

public class Attendance {
    public int getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public LocalDate getMonthYear() {
		return monthYear;
	}

	public void setMonthYear(LocalDate monthYear) {
		this.monthYear = monthYear;
	}

	public int getWorkDays() {
		return workDays;
	}

	public void setWorkDays(int workDays) {
		this.workDays = workDays;
	}

	public int getLateDays() {
		return lateDays;
	}

	public void setLateDays(int lateDays) {
		this.lateDays = lateDays;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	private int attendanceId;
    private int employeeId;
    private LocalDate monthYear;
    private int workDays;
    private int lateDays;
    private Timestamp createdAt;

    public Attendance(int attendanceId, int employeeId, LocalDate monthYear, int workDays, int lateDays, Timestamp createdAt) {
        this.attendanceId = attendanceId;
        this.employeeId = employeeId;
        this.monthYear = monthYear;
        this.workDays = workDays;
        this.lateDays = lateDays;
        this.createdAt = createdAt;
    }

    public Attendance(int employeeId, LocalDate monthYear, int workDays, int lateDays) {
        this.employeeId = employeeId;
        this.monthYear = monthYear;
        this.workDays = workDays;
        this.lateDays = lateDays;
    }

    // Getters và Setters
}
