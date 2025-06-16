package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Adminbean;
import dao.AdminDAO;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/**
	 * admin login functionality implemented here,
	 * by using request.getParameter we get the values and store it in string here.
	 * if everything is successful ,it will go to the adminhome.jsp page.
	 */
	String adminId=request.getParameter("adminId");
	String password=request.getParameter("password");
	
	try{
		Adminbean admin=AdminDAO.loginAdmin(adminId, password);
		
			if(admin!=null)
			{
				HttpSession session=request.getSession();
				session.setAttribute("admin", admin.getAdminId());
				response.sendRedirect("jsp/adminHome.jsp");
			}
			else
			{
				response.getWriter().println("Invalid adminid or password");
			}
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	}

}
