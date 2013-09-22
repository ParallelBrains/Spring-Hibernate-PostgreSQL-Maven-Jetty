# A Java/Spring template project ready to be deployed to Heroku

Built on frameworks including:
* Spring MVC 
* Hibernate 
* PostgreSQL
* Maven
* Jetty

and

(FE frameworks here)

To-Do list:
* Improve Spring security
* Find the best profile/properties solution and apply
* Add FE templates/frameworks
* Exception handling (Spring) on controller level
* Divide controllers to view and data packages
* Enforce checkstyle

## Setting up locally

* Clone the project
```sh
git clone https://github.com/denizozger/Spring-Hibernate-PostgreSQL-Maven-Jetty.git
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
