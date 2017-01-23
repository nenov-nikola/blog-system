<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="menu.jsp" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Добави статия</title>
</head>
<body>

	<c:if test="${not empty msg}">
		<div>
			<strong>${msg}</strong>
		</div>
	</c:if>

	<form action="<c:url value="/add-article"/>" method="POST">
		Издател<br> <input type="text" name="author"><br>
		Име на статия:<br> <input type="text" name="name"><br>
		Статия:<br> <input type="text" name="article"><br> <br>
		<input type="submit" value="Добави статията">
	</form>

</body>
</html>