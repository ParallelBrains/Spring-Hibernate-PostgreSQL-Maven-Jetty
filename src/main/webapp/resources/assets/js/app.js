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