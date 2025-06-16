<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Successful</title>
<link rel="stylesheet" href="../css/style.css">
<script src="../js/script.js"></script>
</head>
<body>
	<%
		String UsrId = request.getParameter("userId");
		String TXN = request.getParameter("TXN");
		String billId = request.getParameter("billId");
		String amount = request.getParameter("amount");
	%>

	<div class="success-container" id="payment-container">
		<h2 style="color: green;">Payment Successful..!</h2>
		<p style="text-align: center;">Thank you for your payment.</p>
		<p>
			<strong>Your User ID is:</strong>
			<%=UsrId%></p>
		<p>
			<strong>Transaction Id:</strong>
			<%=TXN%></p>
		<p>
			<strong>Your Bill Id:</strong>
			<%=billId%></p>
		<p>
			<strong>Amount Paid:</strong>
			<%=amount%></p>

	</div>
	<button class="cnfPAY" style="width: 5rem; margin-top: 1rem" onclick="printDiv()">Print</button>
	<a href="home.jsp" class="home-btn">Back to home</a>



</body>
</html>