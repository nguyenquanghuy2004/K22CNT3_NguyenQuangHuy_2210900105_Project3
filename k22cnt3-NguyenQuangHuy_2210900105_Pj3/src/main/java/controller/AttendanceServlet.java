package controller;

import dao.AttendanceDAO;
import dao.DatabaseConnection;
import model.Attendance;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AttendanceServlet")
public class AttendanceServlet extends HttpServlet {
    private AttendanceDAO attendanceDAO = new AttendanceDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Attendance> attendanceList = attendanceDAO.getAllAttendance();
    	request.setAttribute("attendanceList", attendanceList);
    	request.getRequestDispatcher("attendance.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employee_id"));
        LocalDate monthYear = LocalDate.parse(request.getParameter("month_year"));
        int workDays = Integer.parseInt(request.getParameter("work_days"));
        int lateDays = Integer.parseInt(request.getParameter("late_days"));

        Attendance attendance = new Attendance(employeeId, monthYear, workDays, lateDays);
        attendanceDAO.addAttendance(attendance);

        response.sendRedirect("AttendanceServlet");
    }
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
            System.out.println("Lấy dữ liệu chấm công: " + attendanceList.size() + " bản ghi"); // Debug
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attendanceList;
    }

}
