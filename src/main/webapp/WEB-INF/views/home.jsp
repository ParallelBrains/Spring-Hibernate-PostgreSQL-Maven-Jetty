<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	ParallelBrains base project
</h1>
${controllerMessage}<br/>
<br/>
You should not be able to see person list without logging in. Try to login with username: guest, password: pass
<br/>
<br/>
<a href="person/list">Go to the person list</a>
</body>
</html>
