package controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import dao.ComplaintDAO;
import beans.ComplaintBean;
/**
 *  This implements the fetching of complaint status by their ID
 */
@WebServlet("/complaintStatus")
public class ComplaintStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/**
		 * if we provide correct complaintId ,it will fetch it and show it the page.
		 */
		HttpSession session = request.getSession(false);
		String complaintId = request.getParameter("complaintId");
		String user_id = (String) session.getAttribute("user");
		ComplaintBean complaint;
		try {
			complaint = ComplaintDAO.getComplaintById(complaintId, user_id);


			request.setAttribute("complaint", complaint);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/complaintStatus.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}