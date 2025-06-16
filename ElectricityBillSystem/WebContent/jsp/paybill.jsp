<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<html>
<head>
<title>Pay Bill</title>
<link rel="stylesheet" href="css/payBill.css">
</head>
<body>
	<div class="navbar">
		<a href="jsp/home.jsp" class="navitems">Home</a> <a
			href="${pageContext.request.contextPath}/bill" class="navitems">Pay
			Bill</a> <a href="jsp/complaint.jsp" class="navitems">Register
			Complaint</a> <a href="jsp/complaintStatus.jsp" class="navitems">Complaint
			Status</a> <span class="navbar-right"> Welcome, <strong><%=username%></strong>
			<a href="jsp/logout.jsp" class="logout-button">Logout</a>
		</span>
	</div>
	<div class="container">
		<h2>Welcome to Pay Bill Page</h2>

		<h3>Pending Bills</h3>
		<c:if test="${not empty msg}">
			<p style="color: #ebce8a">${msg}</p>
		</c:if>
		<c:if test="${empty bills}">
			<p style="text-align: center">No pending bills.</p>
		</c:if>

		<c:forEach var="bill" items="${bills}">
			<div class="bill-card">
				<p>
					<strong>Bill No:</strong> ${bill.bill_no}
				</p>
				<p>
					<strong>Amount:</strong> ${bill.amount}
				</p>
				<form method="post" action="jsp/payment.jsp">
					<input type="hidden" name="bill_id" value="${bill.bill_id}">
					<input type="hidden" name="user_id" value="${bill.user_id}">
					<input type="hidden" name="amount" value="${bill.amount}">
					<button type="submit" class="pay">Pay Now</button>
				</form>
			</div>
			<hr>
		</c:forEach>
	</div>

</body>
</html>