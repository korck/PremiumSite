<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Premium Site</title>
</head>
<body>
<center>
	<h1>Site</h1><br>
	<form action="login" method="post">
		Username:<br>
		<input type="text" name="username"><br>
		Password:<br>
		<input type="text" name="password"><br>
		<input type="submit" name="login" value="Login">
		<br><br><br><br>
	</form>
	Don't have an account? Create one: 
	<form action="register" method="post">
		<input type="submit" name="" value="Register"><br>
	</form>
</center>
</body>
</html>