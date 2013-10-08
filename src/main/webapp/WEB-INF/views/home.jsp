<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

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
                        <li class="dropdown-header">People</li>
                        <li><a href="person/list">People List</a></li>
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

<div class="page"></div>

<div class="container">
    <hr>
    <footer>
        <p>&copy; Parallel Brains 2013</p>
    </footer>
</div> <!-- /container -->



<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="../../resources/assets/js/libs/jquery.js"></script>
<script src="../../resources/assets/js/libs/bootstrap.min.js"></script>
<script src="../../resources/assets/js/libs/json2.js"></script>
<script src="../../resources/assets/js/libs/underscore.js"></script>
<script src="../../resources/assets/js/libs/backbone.js"></script>


<!-- TEMPLATES -->
<script type="text/template" id="homepage">

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
        <div class="container">
            <h1>Parallel Brains Base Project</h1>
            <p>This is a template for a simple website. It has a secure area which requires logging in.</p>
            <p>Please login with username "<strong>guest</strong>", and password "<strong>pass</strong>".</p>
            <p>See the <a href="https://github.com/ParallelBrains/Spring-Hibernate-PostgreSQL-Maven-Jetty" target="_blank">GitHub repository</a> for more information.</p>
            <p><a href="login" class="btn btn-primary btn-lg">Login or Register &raquo;</a></p>
        </div>
    </div>

    <div class="container">
        <!-- Example row of columns -->
        <div class="row">
            <div class="col-lg-4">
                <h2>Heading</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                <p><a class="btn btn-default" href="#">View details &raquo;</a></p>
            </div>
            <div class="col-lg-4">
                <h2>Heading</h2>
                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                <p><a class="btn btn-default" href="#">View details &raquo;</a></p>
            </div>
            <div class="col-lg-4">
                <h2>Heading</h2>
                <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                <p><a class="btn btn-default" href="#">View details &raquo;</a></p>
            </div>
        </div>

    </div> <!-- /container -->
</script>

<script type="text/template" id="about">

    <div class="container">

        <h1>About Parallel Brains</h1>

        <p>We love kittens.</p>

        <div class="bs-example bs-example-images">
            <img data-src="holder.js/140x140" src="http://placekitten.com/140/140" class="img-circle" alt="140x140" style="width: 140px; height: 140px;"></p>
        </div>

    </div>

</script>

<script type="text/template" id="contact">

    <link href="../../resources/assets/css/dist/flexible-iframe.css" rel="stylesheet">

    <div class="container">

        <h1>Contact Us</h1>

        <p>Let's have a beer.</p>

    </div>

</script>


<!-- HELPERS -->

<script>
    function htmlEncode(value){
        return $('<div/>').text(value).html();
    }
    $.fn.serializeObject = function() {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function() {
            if (o[this.name] !== undefined) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };
</script>

<!-- BACKBONE -->

<script>

    /**
     * Views
     */

    var HomepageView = Backbone.View.extend({
        el: '.page',
        render: function () {
            var that = this;
            var template = _.template($('#homepage').html(), {});
            that.$el.html(template);
        }
    });

    var homepageView = new HomepageView();


    var AboutView = Backbone.View.extend({
        el: '.page',
        render: function () {
            var that = this;
            var template = _.template($('#about').html(), {});
            that.$el.html(template);
        }
    });

    var aboutView = new AboutView();


    var ContactView = Backbone.View.extend({
        el: '.page',
        render: function () {
            var that = this;
            var template = _.template($('#contact').html(), {});
            that.$el.html(template);
        }
    });

    var contactView = new ContactView();


    /**
     * Router
     */

    var Router = Backbone.Router.extend({
        routes: {
            "": "home",
            "about": "about",
            "contact": "contact"
        }
    });

    var router = new Router;

    router.on('route:home', function() {
        homepageView.render();
    })
    router.on('route:about', function() {
        aboutView.render();
    })
    router.on('route:contact', function() {
        contactView.render();
    })

    Backbone.history.start();
</script>

</body>
</html>
