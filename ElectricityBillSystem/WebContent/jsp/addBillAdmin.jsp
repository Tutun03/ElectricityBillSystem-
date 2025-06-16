<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="javax.servlet.http.HttpSession"%>

<%
	HttpSession session1 = request.getSession(false);
	String username = (session1 != null) ? (String) session1.getAttribute("admin") : null;
	if (username == null) {
		System.out.println(username);
		response.sendRedirect("adminlogin.jsp");
		return;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
    href="<%=request.getContextPath()%>/css/payBill.css">
</head>
<body>
<div class="navbar">
        <a href="${pageContext.request.contextPath}/jsp/adminHome.jsp" class="navitems">Home</a> <a href="${pageContext.request.contextPath}/jsp/addBillAdmin.jsp"
            class="navitems">Add Bill</a> <a href="${pageContext.request.contextPath}/jsp/RegisterConsumer.jsp"
            class="navitems">Register Consumer</a> <span class="navbar-right">Welcome,
            <strong><%=username%></strong> <a href="adminlogout.jsp"
            class="logout-button">Logout</a>
        </span>
    </div>
	<div class="container">
		<h2>Add Customer Bills</h2>
		<form method="post" action="../Paybilladminservlet">
			<label> User ID: </label> <input type="text" name="user_id" required>
			<label>Bill Number:</label> <input type="text" name="bill_no"
				maxlength="5" pattern="^\d{5}$" required><br> <label>Amount:</label>
			<input type="number" step="any" name="amount" required><br>
			<button type="submit" class="addbill">Add Bill</button>
		</form>

		<c:if test="${not empty msg}">
			<p style="color: #ebce8a">${msg}</p>
		</c:if>


	</div>
</body>
</html>