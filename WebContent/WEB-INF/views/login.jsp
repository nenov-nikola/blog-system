<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Вход</title>
</head>
<body>
	<form action="<c:url value="/auth"/>" method="POST">
		Email<br> <input type="text" name="email"><br>
		Парола<br> <input type="password" name="password"><br>
		<br> <input type="submit" value="Влез"> <a
			href="<c:url value="/register"/>">Регистрация</a>
	</form>

</body>
</html>