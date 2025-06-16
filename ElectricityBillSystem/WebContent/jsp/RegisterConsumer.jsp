<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%

response.setHeader("Cache-Control","no-cacahe,no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expiries", 0);
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
    href="<%=request.getContextPath()%>/css/style.css">
    <script src="../js/script.js"></script>
</head>
<body>
<div class="navbar">
        <a href="adminHome.jsp" class="navitems">Home</a> <a href="addBillAdmin.jsp"
            class="navitems">Add Bill</a> <a href="RegisterConsumer.jsp"
            class="navitems">Register Consumer</a> <span class="navbar-right">Welcome,
            <strong><%=username%></strong> <a href="adminlogout.jsp"
            class="logout-button">Logout</a>
        </span>
    </div>
<form class="admin-con" action="../registerConsumer" method="post" id="registerFormConsumer" onsubmit="return validateForm('registerFormConsumer')" onreset="return resetfunction('registerFormConsumer')">
<label for="consumerId">Consumer ID:</label>
<input type="text" name="consumerId" id="consumerId" maxlength="13" pattern="^\d{13}$" required>
<div class="btn">
<input type="submit" value="Register">
<input type="reset" value="Reset">

</div>
</form>
</body>
</html>