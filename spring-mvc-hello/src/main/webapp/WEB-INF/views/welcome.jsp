<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<font color="ORANGE"><b>${msg}</b></font>
	</h1>
	<form action="login" method="post">
		Enter Username : <input type="text" name="userName"><br>
		<br> Enter Password :<input type="password" name="password"><br>
		<br> <input type="submit" value="Login">
	</form>

	<c:forEach items="${names}" var="a">
		<c:out value="${a}" />
	</c:forEach>
	<a href="signup">Create Account</a>
</body>
</html>