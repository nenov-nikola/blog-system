<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="menu.jsp" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Администрaторски панел</title>
</head>
<body>
	<p>Можете да изберете стaтия като кликнете на името и !</p>
	<table border="1px">
		<thead>
			<tr class="text-center">
				<th>ID</th>
				<th>Име на статия</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty articles}">
				<c:forEach var="a" items="${articles}" varStatus="i">
					<tr>
						<td>${a.article_id}</td>
						<td><a href="<c:url value="/edit?id="/>${a.article_id}">${a.article_name}</a>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
</body>
</html>