# A Java/Spring template project ready to be deployed to Heroku [ ![Codeship Status for ParallelBrains/Spring-Hibernate-PostgreSQL-Maven-Jetty](https://www.codeship.io/projects/f951ab10-09ea-0131-64c8-7eb8e86f2980/status?branch=master)](https://www.codeship.io/projects/7451)

Built on Back-end frameworks including:
* Spring MVC 
* Hibernate 
* PostgreSQL
* Maven
* Jetty

We will soon add some Front-end frameworks including:

* Backbone.js
* Require.js
* Mustache.js
* Core Twitter Bootstrap

Please see the current development status of the project here: https://trello.com/b/Mo2khGgC/baselayout

You can find the API documentation here: http://docs.parallelbrainsbaselayout.apiary.io/
A mock API operates at http://parallelbrainsbaselayout.apiary.io/ 

Contributions are much appreciated! If you want to implement a new feature, please create a new branch off master called
 feature/your-feature-name and submit a pull request to master when your implementation is done.

## Setting up locally

* Clone the project
```sh
git clone https://github.com/ParallelBrains/Spring-Hibernate-PostgreSQL-Maven-Jetty.git
```
* Download and install PostgreSQL

* Download a client to connect to your local PostgreSQL server. A good one is http://www.pgadmin.org/

* Create a database called "base"

* Add DATABASE_URL as an environment variable. (If for some reason it doesn't work, try hardcoding it on root-context.xml)
```sh
export DATABASE_URL=postgres://USERNAME:PASSWORD@localhost:5432/base
```

* Go to project directory, run
```sh
mvn jetty:run
```

* Go to http://localhost:8080/baselayout

## Deploying the build to Heroku

* Create a Heroku account and download toolbelt

*  Create an instance on Heroku
```sh
heroku create
```

* Push the code on Heroku
```sh
git push heroku master
```

* Open the app
```sh
heroku open
```

## Useful links

* https://devcenter.heroku.com/articles/getting-started-with-spring-mvc-hibernate
