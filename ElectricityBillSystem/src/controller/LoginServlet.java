package controller;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import beans.UserBean;
import dao.UserDAO;
/**
 * This implements the login functionality of users
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

String userId = req.getParameter("userId");
String password = req.getParameter("password");

/**
 * get userId,password and store it in particular variables.
 */

try {
    UserBean user = UserDAO.getUserById(userId);//getUserById method is called
    
    if (user == null) {
        req.setAttribute("errorMsg", "User ID does not exist");
        res.sendRedirect("jsp/login.jsp");
    } else if (!user.getPassword().equals(password)) {
        req.setAttribute("errorMsg", "Incorrect password");
        res.sendRedirect("jsp/login.jsp");
    } else {
        HttpSession session = req.getSession();
        session.setAttribute("user", user.getUserId());
        res.sendRedirect("jsp/home.jsp");
    }
    /**
     * if everything is successful,it will redirect to home.jsp else 
     * it will re-direct to same login page.
     */

} catch (Exception e) {
    e.printStackTrace();
    req.setAttribute("errorMsg", "Internal server error. Please try again.");
    RequestDispatcher rd = req.getRequestDispatcher("jsp/login.jsp");
    rd.forward(req, res);
}
}
}