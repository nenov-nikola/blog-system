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
<title>Корекция статия</title>
</head>
<body>

	<c:if test="${not empty am}">
		<form action="<c:url value="/edit-article"/>" method="POST">
			Издател<br> <input type="text" name="author"
				value="${am.article_author}"><br> Име на статия:<br>
			<input type="text" name="name" value="${am.article_name}"><br>
			Статия:<br> <input style="width: 600px; height: 150px;" type="text" name="article"
				value="${am.article_body}">
				<input type="hidden" name="id" value="${am.article_id}">
				<br> <br> <input
				type="submit" value="Запиши промени">
		</form>
	</c:if>
</body>
</html>










