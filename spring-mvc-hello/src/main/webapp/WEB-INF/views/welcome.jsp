<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		Enter Username : <input type="text" name="username"><br><br>
		Enter Password :<input type="password" name="password"><br><br>
		<input type="submit" value="Login"> 
	</form>
	
</body>
</html>