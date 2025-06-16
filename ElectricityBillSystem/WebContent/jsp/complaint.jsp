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
	String complaintIdMsg = (String) request.getAttribute("complaintIdMsg");
%>

<!DOCTYPE html>
<html>
<head>
<title>Register Complaint</title>
<link rel="stylesheet" href="../css/style.css">
<script>
function validateComplaintForm() {
const addr = document.getElementById("address").value;
const confirmAddr = document.getElementById("confirmAddress").value;
if (addr !== confirmAddr) {
alert("Address and Confirm Address must match.");
return false;
}
return true;
}
</script>
</head>
<body>
	<div class="navbar">
		<a href="home.jsp" class="navitems">Home</a> <a href="${pageContext.request.contextPath}/bill"
			class="navitems">Pay Bill</a> <a href="complaint.jsp"
			class="navitems">Register Complaint</a> <a href="complaintStatus.jsp"
			class="navitems">Complaint Status</a> <span class="navbar-right">
			Welcome, <strong><%=username%></strong> <a href="logout.jsp"
			class="logout-button">Logout</a>
		</span>
	</div>
	<div class="content">
		<h3>Register Complaint</h3>
		<form action="../complaint" method="post"
			onsubmit="return confirmComplaintSubmission()">
			<label for="complaintType">Complaint Type:</label> <select
				name="complaintType" id="complaintType" required>
				<option value="">--Select--</option>
				<option value="Power Outage">Power Outage</option>
				<option value="Billing Issue">Billing Issue</option>
				<option value="Meter Fault">Meter Fault</option>
				<option value="Other">Other</option>
			</select> <br> <br> <label for="description">Problem
				Description:</label>
			<textarea name="description" id="description" required></textarea>

			<label for="mobileNo">Mobile No:</label> <input type="text"
				name="mobileNo" id="mobileNo" required> <label
				for="contactPerson">Contact Person:</label> <input type="text"
				name="contactPerson" id="contactPerson" required> <label
				for="address">Address:</label>
			<textarea name="address" id="address" required></textarea>

			<label for="confirmAddress">Confirm Address:</label>
			<textarea name="confirmAddress" id="confirmAddress" required></textarea>

			<input type="submit" value="Register Complaint">
		</form>

		<%
			if (complaintIdMsg != null) {
		%>
		<script>alert("<%=complaintIdMsg%>
			");
		</script>
		<%
		
			}
		%>

	</div>
</body>
</html>