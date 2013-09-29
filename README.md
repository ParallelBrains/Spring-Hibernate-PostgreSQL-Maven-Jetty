# A Java/Spring template project ready to be deployed to Heroku

Built on Back-end frameworks including:
* Spring MVC 
* Hibernate 
* PostgreSQL
* Maven
* Jetty

and Front-end frameworks including:

(FE frameworks here)

High priority To-Do list:
* Get the tests running
* User login based on database
* User registration
* Spring social
* Set default ordering of lists
* Find the best profile/properties solution and apply
* Add FE templates/frameworks
* Proper .gitignore
* Forgotten password

Less priorities:
* Document upload/download with Amazon S3
* Error page (with Spring)
* Enforce checkstyle
* Logging database
* Paging
* (Spring) validation
* Caching (EHCache?)

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
