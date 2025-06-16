<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	HttpSession session1 = request.getSession(false);
	String username = (session1 != null) ? (String) session1.getAttribute("user") : null;
	if (username == null) {
		response.sendRedirect("login.jsp");
		return;
	}
	String userId = request.getParameter("user_id");
	String billId = request.getParameter("bill_id");
	String amount = request.getParameter("amount");
%>
<html>
<head>
<title>Payment Page</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<div class="container">
		<h2>Payment Details</h2>
		<form action="" class="card-selection">
			<div>
				<input type="radio" id="debit" name="card_select" value="DEBIT">
				  <label for="debit">Debit Card</label>
			</div>
			<div>
				<input type="radio" id="credit" name="card_select" value="CREDIT">
				  <label for="credit">Credit Card</label>
			</div>
		</form>
		<form action="../payment" method="post">
			<input type="hidden" name="action" value="pay"> <input
				type="hidden" name="billId" value="<%=billId%>"> <input
				type="hidden" name="userId" value="<%=userId%>"> <label>Amount:</label>
			<input type="text" value="<%=amount%>" readonly name="amount"><br> <br>
			<label>Card Number:</label> <input type="text" name="cardNumber"
				maxlength="16" pattern="^\d{16}$" required><br> <br>
			<label>CVV:</label> <input type="password" name="cvv" maxlength="3"
				pattern="^\d{3}$" required><br> <br> <label>
				Expiry date </label> <input type="text" name="expiry" maxlength="5" style="width: 25%">
			<button type="submit" class="cnfPAY">Confirm Payment</button>
		</form>
	</div>

</body>
</html>