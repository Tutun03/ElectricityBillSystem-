package controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.PaymentBean;
import dao.paymentDAO;

/**
 * Payment servlet implements the logic for handling payments by the user
 */
@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	  * This routes handles the paid status of the user.
	  */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		/**
		 *  fetching the payment details from the payment.jsp file:
		 */

		String userId = request.getParameter("userId");
		String billId = request.getParameter("billId");
		String amount = request.getParameter("amount");
		String transactionId = "TXN" + System.currentTimeMillis();

		/**
		 *  loading the from data onto the payment Bean:
		 */
		PaymentBean payUser = new PaymentBean();

		payUser.setUser_Id(userId);
		payUser.setBill_Id(billId);

		try {
			boolean payStatus = paymentDAO.payNow(payUser);
			if (payStatus) {
				response.sendRedirect("jsp/paySuccess.jsp?userId=" + userId + "&amount=" + amount + "&billId="
						+ billId + "&TXN=" + transactionId);
			} else {
				response.sendRedirect("jsp/payFail.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
