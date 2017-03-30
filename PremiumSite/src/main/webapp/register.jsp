<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
<center>
		<form action=register method=post>
		Username: <input type=text id=username name=username size=3>
		<br>Password: <input type=text id=password name=password size=3>
		<br>Confirm Password: <input type=text id=cpassword name=cpassword size=3>
		<br>Email: <input type=text id=email name=email size=3>
		<br><input type=submit name=register value=Register><br>
		</form>
</center>
</body>
</html>