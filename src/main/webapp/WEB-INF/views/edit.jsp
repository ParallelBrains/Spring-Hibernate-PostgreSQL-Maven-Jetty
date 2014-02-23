<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../resources/assets/img/favicon.ico">

    <title>ParallelBrains baselayout</title>

    <!-- Bootstrap core CSS -->
    <link href="../../resources/assets/css/dist/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../../resources/assets/css/dist/jumbotron.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="../../resources/assets/js/libs/html5shiv.js"></script>
    <script src="../../resources/assets/js/libs/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Baselayout</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Secure Area <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li class="dropdown-header">Users</li>
                        <li><a href="user/list">Users List</a></li>
                    </ul>
                </li>
            </ul>
            <!-- todo Disabled the login form until we decide on how to show/hide it -->
            <%--<form name="f" action="process-login" method="POST"  class="navbar-form navbar-right">--%>
            <%--<div class="form-group">--%>
            <%--<input name="username" type="text" placeholder="Username" class="form-control">--%>
            <%--</div>--%>
            <%--<div class="form-group">--%>
            <%--<input name="password" type="password" placeholder="Password" class="form-control">--%>
            <%--</div>--%>
            <%--<button type="submit" class="btn btn-success">Sign in</button>--%>
            <%--</form>--%>
        </div><!--/.navbar-collapse -->
    </div>
</div>

<div class="container">

    <h1>
        Person ${person.id} ${person.firstName} ${person.lastName}
    </h1>

    <form:form commandName="user" style="padding:8px">

        <div class="form-group">
            <label for="username"> Username</label>
            <form:input path="username" cssClass="form-control" id="username"/>
        </div>
        <div class="form-group">
            <label for="firstname">First Name</label>
            <form:input path="firstName" cssClass="form-control" id="firstname"/>
        </div>
        <div class="form-group">
            <label for="lastname">Last Name</label>
            <form:input path="lastName" cssClass="form-control" id="lastname"/>
        </div>

        <button type="submit" class="btn btn-primary">Save</button>

    </form:form>

    <form:form commandName="user" action="/user/delete" style="padding:8px">
        <form:hidden path="id"/>
        <button type="submit" class="btn btn-danger delete">Delete</button>
    </form:form>

    <br/>
    <br/>

    <div class=" text-right">
        <%--<p class="text-muted">You are logged in as ${loggedInUserName}</p>--%>

        <form action="/j_spring_security_logout">
            <button type="submit" class="btn btn-warning">Logout</button>
        </form>
    </div>


</div>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="../../resources/assets/js/libs/jquery.js"></script>
<script src="../../resources/assets/js/libs/bootstrap.min.js"></script>

</body>
</html>



