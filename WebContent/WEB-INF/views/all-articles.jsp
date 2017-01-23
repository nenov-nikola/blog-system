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
<title>Статии</title>
</head>
<body>
	<c:forEach var="a" items="${articles}">
		<p>
			<b>${a.article_name}</b>
		</p>
		<p>${a.article_body}</p>
		<p>
			<i>Публикувал:</i>${a.article_author}
		</p>
		<hr>
	</c:forEach>

</body>
</html>