package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.RegisterConsumerbean;
import dao.registerConsumerDAO;

/**
 * Servlet implementation class registerConsumer
 */
@WebServlet("/registerConsumer")
public class registerConsumer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerConsumer() {
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
		 * register consumer functionality implemented,if successful,it will re-direct to the home page  
		 */
		
		long cid = Long.parseLong(request.getParameter("consumerId"));
		RegisterConsumerbean registerConsumerbean=new RegisterConsumerbean();
		registerConsumerbean.setConsumerId(cid);
		try{
			boolean status=registerConsumerDAO.registerConsumer(registerConsumerbean);
			if (status)
				response.sendRedirect("jsp/adminHome.jsp");
			else
				response.getWriter().println("Register consumer  Failed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
