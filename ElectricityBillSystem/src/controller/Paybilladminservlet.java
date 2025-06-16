package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BillBean;
import dao.BillDAO;

/**
 * Servlet implementation class of Paybilladminservlet
 */
@WebServlet("/Paybilladminservlet")
public class Paybilladminservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Paybilladminservlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BillDAO dao = new BillDAO();
		String user_id = request.getParameter("user_id");;
		String bill_no = request.getParameter("bill_no");
		double amount = Double.parseDouble(request.getParameter("amount"));
		BillBean bill = new BillBean();
		bill.setuser_id(user_id);
		bill.setbill_no(bill_no);
		bill.setAmount(amount);
		bill.setStatus("pending");

		boolean added = dao.addBill(bill);
		request.setAttribute("msg", added ? "Bill added successfully." : "Failed to add bill.");
		RequestDispatcher rd = request.getRequestDispatcher("jsp/addBillAdmin.jsp");
		rd.forward(request, response);
	}

}
