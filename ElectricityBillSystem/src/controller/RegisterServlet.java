package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserBean;
import dao.UserDAO;
/**
 * This implements the logic of user registration
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * - @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * 
	 * - @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 * response)
	 */

	/**
	 * 
	 * - @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		long cid = Long.parseLong(req.getParameter("consumerId"));
		int bill = Integer.parseInt(req.getParameter("billNumber"));
		String c_name = req.getParameter("customername");
		String email = req.getParameter("email");
		long mobile = Long.parseLong(req.getParameter("mobileNo"));
		String userId = "USR"+ System.currentTimeMillis();
		String pass = req.getParameter("password");
		String confirmpassword = req.getParameter("confirmPassword");
		
		/** 
		 * by using request.getparameter the attributes will be stored in its respective variables 
		 * 
		 */
		
        /**
         *   created the object of the userbean class 
         */
		UserBean user = new UserBean();
       

		/**
		 *  now we have set the values using setter.
		 */
		user.setConsumerId(cid);
		user.setBillNumber(bill);
		user.setCustomerName(c_name);
		user.setEmail(email);
		user.setMobileNo(mobile);
		user.setUserId(userId);
		user.setPassword(pass);
		user.setConfirmpassword(confirmpassword);
		
/**
 * performing validations for the consumer registration form.
 */
		try {
			boolean isValid=UserDAO.isValidConsumer(cid);
			
			if(!isValid)
			{
				System.out.println("not valid");
			}
			else{
				System.out.println("success");
			boolean status = UserDAO.registerUser(user);
			if (status)
				res.sendRedirect("jsp/acknowledgement.jsp?userId="+userId+"&email="+email+"&name="+c_name);
			else
				res.getWriter().println("Registration Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}