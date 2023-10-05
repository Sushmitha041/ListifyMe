<h1 align="center">
    <br>
    ListifyMe 
    <br>
</h1>

<p align="center">
  <a href="https://spring.io/projects/spring-boot/">
    <img src="https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot" alt="Spring Boot">
  </a>
  <a href="https://www.mysql.com/">
     <img src="https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL">
  </a>
  <a href="https://hibernate.org/">
     <img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white" alt="Hibernate">
  </a>
  <a href="https://maven.apache.org/">
     <img src="https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven">
  </a>
  <a href="https://getbootstrap.com/">
     <img src="https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white" alt="Bootstrap">
  </a>
  <a href="https://spring.io/projects/spring-security">
     <img src="https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Spring-Security&logoColor=white" alt="Spring Security">
  </a>
   <a href="https://docs.docker.com/">
     <img src="https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white" alt="Docker">
  </a>
  <a href="https://developer.mozilla.org/en-US/docs/Glossary/HTML5">
     <img src="https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white" alt="HTML5">
  </a>
  <a href="https://developer.mozilla.org/en-US/docs/Web/CSS">
     <img src="https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white" alt="CSS3">
  </a>
</p>

<p align="center">
  <a href="#overview">Introduction</a>
  •
  <a href="#entities">Entities</a>
  •
  <a href="#apis">APIs</a>
  •
  <a href="#application-properties">Application Properties</a>
  •
  <a href="#development">Development</a>
  •
  <a href="#build">Build</a>
  •
  <a href="#Docker for SQL container"> Docker for SQL container</a.

</p>

# Introduction

**Introducing ListifyMe: Your Smart Todo Companion**

ListifyMe is a user-friendly to-do application designed to simplify task management and boost productivity. Whether you're managing work projects, school assignments, or daily chores, ListifyMe makes it easy to stay organized and focused.n
This application uses HTML CSS Bootstrap for the front end using JSP files which talks with Spring Boot API in the backend. Docker is used to create SQL container where database is stored.

* Backend - Spring Boot
* Database - MySQL
* Frontend - Html CSS JavaScript
* Build System - Maven

<br>

# Entities
## todo
* Id (primary key)
* username
* description
* targetDate
* done

<br>

# APIs

## Authenticate
* /login - Users Spring security to provide login.
```
{
    username: "user",
    password: "password"
}
```

## Todo
* /welcome   - Home page.
* /list-todo - Get Mapping to find all todo's added by the user in the database.
* /add-todo  - To add new todo's.
* /logout    - To sign out user from application.

<br>

# Application Properties
```
server.port = yourPreferredPortNumber
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
spring.mvc.format.date=yyyy-MM-dd

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url = jdbc:mysql://localhost:3306/yourSchemaName
spring.datasource.username = yourUsername
spring.datasource.password = yourPassword
```

<br>

# Development
```
mvn install
```

<br>

# Build
```
mvn spring-boot:run
```
<br>

# Docker for SQL container 

```
docker run --detach
--env MYSQL_ROOT_PASSWORD=dummypassword
--env MYSQL_USER=todos-user
--env MYSQL_PASSWORD=dummytodos
--env MYSQL_DATABASE=todos
--name mysql
--publish 3306:3306 mysql:8-oracle
```
