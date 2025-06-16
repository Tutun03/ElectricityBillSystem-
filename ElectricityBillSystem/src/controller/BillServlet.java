package controller;

import beans.BillBean;
import dao.BillDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 *  Bill servlet is implemented
 * This handles the bill fetching and bill addtion for each customer
 */
@WebServlet("/bill")
public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	  * To add the bills for user by the admin
	  */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 HttpSession session = request.getSession(false);
		 if (session == null || session.getAttribute("user") == null) {
		 response.sendRedirect("login.jsp");
		 return;
		 }

		 String user_id = (String) session.getAttribute("user");
		String action = request.getParameter("action");
		BillDAO dao = new BillDAO();

		if ("add".equals(action)) {
			String bill_no = request.getParameter("bill_no");
			double amount = Double.parseDouble(request.getParameter("amount"));

			BillBean bill = new BillBean();
			bill.setuser_id(user_id);
			bill.setbill_no(bill_no);
			bill.setAmount(amount);
			bill.setStatus("pending");

			boolean added = dao.addBill(bill);
			request.setAttribute("msg", added ? "Bill added successfully." : "Failed to add bill.");

		} else if ("pay".equals(action)) {
			String bill_id = request.getParameter("bill_id");
			boolean paid = dao.payBill(bill_id);
			request.setAttribute("msg", paid ? "Payment successful." : "Payment failed.");
		}

		List<BillBean> bills = dao.getPendingBills(user_id);
		request.setAttribute("bills", bills);
		RequestDispatcher rd = request.getRequestDispatcher("jsp/paybill.jsp");
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 *  Only used when user clicks "Pay Bill" from navbar
		 */
		 HttpSession session = request.getSession(false);
		 if (session == null || session.getAttribute("user") == null) {
		 response.sendRedirect("login.jsp");
		 return;
		 }

		 String user_id = (String) session.getAttribute("user");
		 /**
		  * For fetching the updated bill for each user
		  */
		BillDAO dao = new BillDAO();
		List<BillBean> bills = dao.getPendingBills(user_id);

		request.setAttribute("bills", bills);
		RequestDispatcher rd = request.getRequestDispatcher("jsp/paybill.jsp");
		rd.forward(request, response);
	}

}