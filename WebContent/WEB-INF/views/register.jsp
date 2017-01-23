<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Регистрация</title>
</head>
<body>
	<form action="<c:url value="/reg"/>" method="POST">
		Име<br> <input type="text" name="firstname"><br>
		Фамилия<br> <input type="text" name="lastname"><br>
		Потребителско име<br> <input type="text" name="username"><br>
		Email<br> <input type="text" name="email"><br>
		Парола<br> <input type="password" name="pass"><br> <br>
		<input type="submit" value="Регистрация">
	</form>

</body>
</html>