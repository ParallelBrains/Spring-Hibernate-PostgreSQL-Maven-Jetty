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
                <li><a href="#people">People</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown">Secure Area <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li class="dropdown-header">Users</li>
                        <li><a href="#users">User list</a></li>
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

<!-- Change underscore's interperation symbols from \<\% to \<\@ http://stackoverflow.com/a/8467907/2498874 -->
<script>
    _.templateSettings = {
        interpolate: /\<\@\=(.+?)\@\>/gim,
        evaluate: /\<\@(.+?)\@\>/gim,
        escape: /\<\@\-(.+?)\@\>/gim
    };
</script>


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

    <div class="container">

        <h1>Contact Us</h1>

        <p>Let's have a beer.</p>

    </div>

</script>

<script type="text/template" id="person-list-template">

    <div class="container">

        <h1>People</h1>

        <div class="table-responsive">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                    <@ _.each(people, function(person) { @>
                        <tr>
                            <td><@= person.id @></td>
                            <td><@= htmlEncode(person.get('firstName')) @></td>
                            <td><@= htmlEncode(person.get('lastName')) @></td>
                            <td><a href="#people/edit/<@= person.id @>" class="btn btn-info btn-xs">Edit</a></td>
                        </tr>
                    <@ }); @>
                </tbody>
            </table>
        </div>

        <a href="#people/new" class="btn btn-primary">New person</a>

    </div>

</script>


<script type="text/template" id="edit-person-template">
    <div class="container">
        <form class="edit-person-form">

            <h1><@= person ? 'Edit' : 'New' @> Person</h1>

            <input name="id" id="personId" type="hidden" value="<@= person ? person.get('id') : '' @>">

            <div class="form-group">
                <label for="firstName">First Name</label>
                <input name="firstName" id="firstName" type="text" class="form-control" value="<@= person ? person.get('firstName') : '' @>">
            </div>

            <div class="form-group">
                <label for="lastName">Last Name</label>
                <input name="lastName" id="lastName" type="text" class="form-control" value="<@= person ? person.get('lastName') : '' @>">
            </div>

            <hr />

            <button type="submit" class="btn btn-primary"><@= person ? 'Update' : 'Create' @></button>

        </form>

        <@ if(person) { @>
            <br/>
            <input type="hidden" name="id" value="<@= person.id @>" />
            <button data-person-id="<@= person.id @>" class="btn btn-danger delete">Delete</button>
        <@ }; @>
    </div>
</script>

<script type="text/template" id="user-list-template">

    <div class="container">

        <h1>Users</h1>

        <div class="table-responsive">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <@ _.each(users, function(user) { @>
                <tr>
                    <td><@= user.id @></td>
                    <td><@= htmlEncode(user.get('username')) @></td>
                    <td><@= htmlEncode(user.get('firstName')) @></td>
                    <td><@= htmlEncode(user.get('lastName')) @></td>
                    <td><@= htmlEncode(user.get('email')) @></td>
                    <td><a href="#users/edit/<@= user.id @>" class="btn btn-info btn-xs">Edit</a></td>
                </tr>
                <@ }); @>
                </tbody>
            </table>
        </div>

        <a href="#users/new" class="btn btn-primary">New user</a>

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

<script type="text/template" id="edit-user-template">
    <div class="container">
        <form class="edit-user-form">

            <h1><@= user ? 'Edit' : 'New' @> User</h1>

            <input name="id" id="userId" type="hidden" value="<@= user ? user.get('id') : '' @>">

            <div class="form-group">
                <label for="username">Username</label>
                <input name="username" id="username" type="text" class="form-control" value="<@= user ? user.get('username') : '' @>">
            </div>

            <div class="form-group">
                <label for="userFirstName">First Name</label>
                <input name="firstName" id="userFirstName" type="text" class="form-control" value="<@= user ? user.get('firstName') : '' @>">
            </div>

            <div class="form-group">
                <label for="userLastName">Last Name</label>
                <input name="lastName" id="userLastName" type="text" class="form-control" value="<@= user ? user.get('lastName') : '' @>">
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <input name="email" id="email" type="text" class="form-control" value="<@= user ? user.get('email') : '' @>">
            </div>

            <div class="form-group">
                <label for="newPassword">New Password</label>
                <input name="newPassword" id="newPassword" type="password" class="form-control">
            </div>

            <hr />

            <button type="submit" class="btn btn-primary"><@= user ? 'Update' : 'Create' @></button>

        </form>

        <@ if(user) { @>
            <br/>
            <input type="hidden" name="id" value="<@= user.id @>" />
            <button data-user-id="<@= user.id @>" class="btn btn-danger deleteUser">Delete</button>
        <@ }; @>
    </div>
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


    var People = Backbone.Collection.extend({
        url: '/api/people'
    });

    var Person = Backbone.Model.extend({
        urlRoot: '/api/people'
    });

    var PersonListView = Backbone.View.extend({
        el: '.page',
        render: function () {
            var that = this;
            var people = new People();
            people.fetch({
                success: function (people) {
                    var template = _.template($('#person-list-template').html(), {people: people.models});
                    that.$el.html(template);
                }
            })
        }
    });

    var personListView = new PersonListView();


    var PersonEditView = Backbone.View.extend({
        el: '.page',
        events: {
            'submit .edit-person-form': 'savePerson',
            'click .delete': 'deletePerson'
        },
        savePerson: function (ev) {
            var personDetails = $(ev.currentTarget).serializeObject();
            var person = new Person();
            person.save(personDetails, {
                success: function (person) {
                    router.navigate('people', {trigger:true});
                }
            });
            return false;
        },
        deletePerson: function (ev) {
            this.person.destroy({
                success: function () {
                    router.navigate('people', {trigger:true});
                }
            })
        },
        render: function (options) {
            var that = this;
            if(options.id) {
                that.person = new Person({id: options.id});
                that.person.fetch({
                    success: function (person) {
                        var template = _.template($('#edit-person-template').html(), {person: person});
                        that.$el.html(template);
                    }
                })
            } else {
                var template = _.template($('#edit-person-template').html(), {person: null});
                that.$el.html(template);
            }
        }
    });

    var personEditView = new PersonEditView();


    var Users = Backbone.Collection.extend({
        url: '/api/users'
    });

    var UserListView = Backbone.View.extend({
        el: '.page',
        render: function () {
            var that = this;
            var users = new Users();
            users.fetch({
                success: function (users) {
                    var template = _.template($('#user-list-template').html(), {users: users.models});
                    that.$el.html(template);
                }
            })
        }
    });

    var userListView = new UserListView();

    var User = Backbone.Model.extend({
        urlRoot: '/api/users'
    });

    var UserEditView = Backbone.View.extend({
        el: '.page',
        events: {
            'submit .edit-user-form': 'saveUser',
            'click .deleteUser': 'deleteUser'
        },
        saveUser: function (ev) {
            var userDetails = $(ev.currentTarget).serializeObject();
            var user = new User();
            user.save(userDetails, {
                success: function (user) {
                    router.navigate('users', {trigger:true});
                }
            });
            return false;
        },
        deleteUser: function (ev) {
            this.user.destroy({
                success: function () {
                    router.navigate('users', {trigger:true});
                }
            })
        },
        render: function (options) {
            var that = this;
            if(options.id) {
                that.user = new User({id: options.id});
                that.user.fetch({
                    success: function (user) {
                        var template = _.template($('#edit-user-template').html(), {user: user});
                        that.$el.html(template);
                    }
                })
            } else {
                var template = _.template($('#edit-user-template').html(), {user: null});
                that.$el.html(template);
            }
        }
    });

    var userEditView = new UserEditView();

    /**
     * Router
     */

    var Router = Backbone.Router.extend({
        routes: {
            "": "home",
            "people": "people",
            "people/edit/:id": "editPerson",
            "people/new": "editPerson",
            "about": "about",
            "contact": "contact",
            "users": "users",
            "users/edit/:id": "editUser",
            "users/new": "editUser"
        }
    });

    var router = new Router;

    router.on('route:home', function() {
        homepageView.render();
    })
    router.on('route:people', function() {
        personListView.render();
    })
    router.on('route:editPerson', function(id) {
        personEditView.render({id: id});
    })
    router.on('route:about', function() {
        aboutView.render();
    })
    router.on('route:contact', function() {
        contactView.render();
    })
    router.on('route:users', function() {
        userListView.render();
    })
    router.on('route:editUser', function(id) {
        userEditView.render({id: id});
    })

    Backbone.history.start();
</script>

</body>
</html>
