<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%
	HttpSession session1 = request.getSession(false);
	String username = (session1 != null) ? (String) session1.getAttribute("user") : null;
	if (username == null) {
		System.out.println(username);
		response.sendRedirect("login.jsp");
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome - Home</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<div class="navbar">
		<a href="home.jsp" class="navitems">Home</a> <a href="../bill"
			class="navitems">Pay Bill</a> <a href="complaint.jsp"
			class="navitems">Register Complaint</a> <a href="complaintStatus.jsp"
			class="navitems">Complaint Status</a> <span class="navbar-right">Welcome,
			<strong><%=username%></strong> <a href="logout.jsp"
			class="logout-button">Logout</a>
		</span>
	</div>
	<div class="content">
		<h3>Please click the above navbar options</h3>
		<%
			String complaintId = (String) session.getAttribute("newComplainId");
			if (complaintId != null) {
		%>
		<p class="cmpIdText">
			Your Complaint Id :
			<%=complaintId%>
		</p>
		<%
			session.removeAttribute("newComplainId");
			}
		%>
	</div>
</body>
</html>