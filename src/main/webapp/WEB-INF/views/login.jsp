<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../resources/assets/img/favicon.ico">

    <title>Login to Baselayout</title>

    <!-- Bootstrap core CSS -->
    <link href="../../resources/assets/css/dist/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../../resources/assets/css/dist/signin.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="../../resources/assets/js/libs/html5shiv.js"></script>
    <script src="../../resources/assets/js/libs/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">

    <form name="login" action="process-login" method="POST" class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <c:if test="${fn:length(loginErrorMessage) > 0}">
            <div class="alert alert-danger"><strong>Oh snap!</strong> ${loginErrorMessage}</div>
        </c:if>
        <input type="text" name="username" value="" class="form-control" placeholder="Username" autofocus>
        <input type="password" name="password" class="form-control" placeholder="Password">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>

    <form name="register" action="process-register" method="POST" class="form-signin">
        <h2 class="form-signin-heading">New to Baselayout?</h2>
        <c:if test="${fn:length(registerErrorMessage) > 0}">
            <div class="alert alert-danger"><strong>Oh snap!</strong> ${registerErrorMessage}</div>
        </c:if>
        <input type="text" name="firstName" value="" class="form-control" placeholder="First name" autofocus>
        <input type="text" name="lastName" value="" class="form-control" placeholder="Last name" autofocus>
        <input type="text" name="username" value="" class="form-control" placeholder="Username" autofocus>
        <input type="email" name="email" value="" class="form-control" placeholder="Email address" autofocus>
        <input type="password" name="password" class="form-control" placeholder="New password">
        <button class="btn btn-lg btn-success btn-block" type="submit">Sign up!</button>
    </form>

</div> <!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
</body>
</html>
