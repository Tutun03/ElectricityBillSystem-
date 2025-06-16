package controller;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import beans.ComplaintBean;
import dao.ComplaintDAO;

/**
 * register complaint is implemented here.
 * by providing details and submit it woill create a random complaint id,and redirect to home page
 */
@WebServlet("/complaint")
public class ComplaintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

HttpSession session = req.getSession(false);
if (session == null || session.getAttribute("user") == null) {
res.sendRedirect("jsp/login.jsp");
return;
}

String userId =  (String) session.getAttribute("user");
String type = req.getParameter("complaintType");
String description = req.getParameter("description");
String mobile = req.getParameter("mobileNo");
String contact = req.getParameter("contactPerson");
String address = req.getParameter("address");
String confirmAddress = req.getParameter("confirmAddress");

if (!address.equals(confirmAddress)) {
    req.setAttribute("msg", "Address confirmation mismatch.");
    req.getRequestDispatcher("jsp/complaint.jsp").forward(req, res);
    return;
}

String complaintId = "CMP" + UUID.randomUUID().toString().substring(0, 5);

ComplaintBean cb = new ComplaintBean();
cb.setComplaintId(complaintId);
cb.setUserId(userId);
cb.setComplaintType(type);
cb.setDescription(description);
cb.setMobileNo(mobile);
cb.setContactPerson(contact);
cb.setAddress(address);

try {
    boolean status = ComplaintDAO.registerComplaint(cb);
    if (status) {

        session.setAttribute("newComplainId", complaintId);
        PrintWriter out = res.getWriter();
        res.sendRedirect("jsp/home.jsp");
        
    } else {
        req.setAttribute("msg", "Failed to register complaint.");

        res.sendRedirect("jsp/complaint.jsp");
    }
} catch (Exception e) {
    e.printStackTrace();
    req.setAttribute("msg", "Error occurred during complaint registration.");
}



}
}