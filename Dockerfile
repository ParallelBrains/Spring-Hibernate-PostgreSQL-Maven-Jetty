FROM tomcat:8.0-jre8-alpine
WORKDIR /usr/local/tomcat
COPY target/app.war /usr/local/tomcat/webapps/app.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
