# Angular + Rest + Spring Boot - Example

This example demonstrates how **Spring Boot** and in the front-end **AngularJS** can be used together to write web applications easily.
In this code example I'm demonstrating how to get flights data and display it to on calendar time line.

## Frameworks

### Front-end

#### AngularJS
AngularJS is a MVC based framework for web applications, written in JavaScript. It makes it possible to use the Model-View-Controller pattern on the front-end. It also comes with several additional modules. In this example I'm also using **angular-resource**, which is a simple factory-pattern based module for creating REST clients.

#### Full Calendar io
A JavaScript event calendar. Customizable and open source.
Display a full-size drag-n-drop event calendar, leveraging jQuery.
https://fullcalendar.io/

### Back-end

#### Spring Boot
One of the hassles while creating web applications using the Spring Framework is that it involves a lot of configuration. Spring Boot makes it possible to write configuration-less web application because it does a lot for you out of the box.

If you add the spring-boot-starter-web dependency, then you can start writing controllers for creating a web application.

## Installation
You can run Maven to package the application:
```
mvn clean package
```

Now you can run the Java application quite easily:
```
cd target
java -jar ng-springboot-0.0.1.jar
```

API URI: http://localhost:8080/
