<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="beans.ComplaintBean"%>
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
<title>Complaint Status</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<div class="navbar">
		<a href="${pageContext.request.contextPath}/jsp/home.jsp"
			class="navitems">Home</a> <a
			href="${pageContext.request.contextPath}/bill" class="navitems">Pay
			Bill</a> <a href="${pageContext.request.contextPath}/jsp/complaint.jsp"
			class="navitems">Register Complaint</a> <a
			href="${pageContext.request.contextPath}/jsp/complaintStatus.jsp"
			class="navitems">Complaint Status</a> <span class="navbar-right">
			Welcome, <strong><%=username%></strong> <a
			href="${pageContext.request.contextPath}/jsp/logout.jsp"
			class="logout-button">Logout</a>
		</span>
	</div>
	<div class="content">
		<h3>Check Complaint Status</h3>
		<form action="${pageContext.request.contextPath}/complaintStatus" method="post">
			<label for="complaintId">Enter Complaint ID:</label> <input
				type="text" name="complaintId" id="complaintId" required> <input
				type="submit" value="Check Status">
		</form>

		<br>
		<c:if test="${not empty complaint}">
			<h3>Complaint Details</h3>
			<table class="minimalistBlack">
				<thead>
					<tr>
						<th>Complaint ID</th>
						<th>User ID</th>
						<th>Type</th>
						<th>Description</th>
						<th>Mobile No</th>
						<th>Contact Person</th>
						<th>Address</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${complaint.getComplaintId()}</td>
						<td>${complaint.userId}</td>
						<td>${complaint.getComplaintType()}</td>
						<td>${complaint.getDescription()}</td>
						<td>${complaint.getMobileNo()}</td>
						<td>${complaint.getContactPerson()}</td>
						<td>${complaint.getAddress()}</td>
						<td>${complaint.getStatus()}</td>
					</tr>
				</tbody>
			</table>
		</c:if>
		<c:if test="${complaint == null && param.complaintId != null}">
			<p class="cmpError">No complaint found with that ID.</p>
		</c:if>

	</div>
</body>
</html>