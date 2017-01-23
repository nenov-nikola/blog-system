<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: gray;
}

li {
	float: left;
}

li a {
	display: inline-block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
}
</style>

<ul>
	<li><a href="<c:url value="/home"/>">Home</a></li>
	<li><a href="<c:url value="/article"/>">Add article</a></li>
	<li><a href="<c:url value="/admin"/>">A-panel</a></li>
</ul>


