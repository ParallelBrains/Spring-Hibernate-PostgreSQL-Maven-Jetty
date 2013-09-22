<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
<h1>Listing People</h1>
<c:forEach items="${people}" var="v_person">
	<a href="edit?id=${v_person.id}">${v_person.id} -
	${v_person.firstName} ${v_person.lastName}</a>
	<br />
</c:forEach>
<br/>
<a href="edit"> Add Person</a>
<br/>

<!-- todo we should get app running on localhost:8080 only instead of localhost:8080/baselayout for these links to work -->
<a href="/">Go to homepage</a>
<br/>
<a href="/j_spring_security_logout">Logout</a>
</body>
</html>
