package controller;
import model.luong;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/luong")
public class luongServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public luongServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy danh sách lương từ DAO
        List<luong> listLuong = luongServlet.getAllLuong();

        // Gửi dữ liệu sang JSP
        request.setAttribute("listLuong", listLuong);
        
        // Chuyển hướng đến trang bangluong.jsp
        request.getRequestDispatcher("bangluong.jsp").forward(request, response);
    }

	private static List<luong> getAllLuong() {
		// TODO Auto-generated method stub
		return null;
	}
}
