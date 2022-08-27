# JavaIntelliJInitializr
Simple project from zero to something.

<h3>Phase one:</h3>

- Install intelliJ Ultimate/community;
- Install some basic plugins for intelliJ (if you like) 
- Create a new project for Spring Boot using IntelliJ initializr;

![](https://github.com/magnoweege/JavaIntelliJInitializr/blob/master/images/001.JPG)

# After that we create this "packages" under main "DemoApplication" com.example.demo."packages"
  
  - Concept MVC (Model, View and Controller):
  - model       // Here we put our model bussines cases (objects) BACKEND
  - controller  // Will be responsible for de communication between View and Model MIDDLEWARE
  - view        // The front website itself (html,jsp,jsf) FRONTEND 
  - repository  // Where the magic happens for data to be persisted!
  
  - ## inside the com.example.demo create this 4 "packages", clicking with the right mouse button under new menu > package. ##
  
# After that we are going to create the files we will needed

  - inside model > new class file "Website.java"
  - inside controller > leave it for now!
  - inside view > leave it for now!
  - inside repository > new interface file WebsiteRepository.java
  
  # insert inside the model>Website.java:
  
```sh
    package com.example.demo.model;
    import javax.persistence.*;
    import java.io.Serializable;
    import java.util.Objects;
    
    @Entity
    public class Website implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //Identity for H2
    
    private long id;
    private String http;
    private String status;
    private String message;
    private String local;
    
    public Website() {
    }
    
    public Website(String http, long id, String status, String message, String local) {
    ...
    }
    
    getters and setters ...
    
    hashcodes and equals ...
    }

```

# insert inside the model>Website.java:

```sh

package com.example.demo.repository;

import com.example.demo.model.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebsiteRepository extends JpaRepository<Website, Long>{

```

# After the creation of structure will look like this:

![](https://github.com/magnoweege/JavaIntelliJInitializr/blob/master/images/002.JPG)

# insert inside the resources/application.properties:

```sh
spring.h2.console.settings.trace=false
spring.h2.console.settings.web-allow-others=false
spring.h2.console.enabled=true
spring.h2.console.path=/h2

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto=update

```

Now if you save all the files and start the application you will be able to access 

https://www.h2database.com/html/commands.html

http://localhost:8080/h2 
> without password

![](https://github.com/magnoweege/JavaIntelliJInitializr/blob/master/images/003.JPG)

and se the model you've created in de H2 database in memory.

![](https://github.com/magnoweege/JavaIntelliJInitializr/blob/master/images/004.JPG)

Then we finished the first part of the tutorial.

<h3>Phase two:</h3>

We are going to create our access to the backend by creating a RestController.
So, create a new file inside > controller/WebsiteController.java and put write this code:

```sh
package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/website")
public class WebsiteController {

    @RequestMapping(method = RequestMethod.GET)
    public String listarWebsite() {
        return "You are in!";
    }

}
```
type in your browser localhost:8080/website

and Voila!

![](https://github.com/magnoweege/JavaIntelliJInitializr/blob/master/images/005.JPG)

<h3>Phase four:</h3>

Now that we now how to create a REST template and make a link between Front and Back, we are going to do a diferent aproach.
We are going to create a couple solution using Thymeleaf, that means we are going to do a MVC using the java solution to create a frontview.

So what have to be clear in this topic is, when you create a REST template with Endpoints to be access, you are doing a non-couple solution and you can use whatever front framework to build a solution to acces the endpoint and interact with de back, for example, Angular, React, Vue.js and so on, however, if you use the thymeleaf solution it will be set inside your java project structure, you can use jsf, jsp, primefaces, and so on in this aproach.

Now lets make some changes do work with thymeleaf and after that we are going to use bootstrap to make things more pretty! ;)

The first thing to do is to add the dependency for thymeleaf in the pom.xml for maven download the library:

```html
<dependency>
 <groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

Hint: if have this error: ``` javax.servlet.ServletException: Circular view path [home]: would dispatch back to the current handler URL [/home] again. ```
Then take of the <scope> tag from tomcat as folow:

```html
<dependency>
 <groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-starter-tomcat</artifactId>
 ->    <scope>provided</scope>   --> DELETE THIS LINE AND SAVE!
</dependency>
```

We are going to change our controller a little bit to use thymeleaf, as follow:

```sh
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebsiteController {

    @Value("${spring.application.name}")
    String appName;

    @GetMapping(value = "/home")
   
    public String getWebsite( Model model) {

       model.addAttribute("appName", appName);
        return "home";

    }
}
```

Now you have to create a template for the Thymeleaf, then it will seek for the file you will return in the resources/templates/home.html

create a html file inside resources/templates/ and write this code there.

```html
<!DOCTYPE HTML>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8"/>
    <title>Demo with Thymeleaf</title>
</head>
<body>
<h1>Hello!!</h1>
<p>Welcome to <span th:utext="${appName}"/></p>
</body>
</html>
```
  
  To finish we are going to create a variable inside the application.properties like this:
  
```sh
  spring.application.name=Thymeleaf template simple setting!
```

  If you note, we access this variable inside de controller as follow: ``` @Value("${spring.application.name}") ```
  
  and now if you run the application using the endpoint we define http://localhost:8080/home you will see this:
  
  ![](https://github.com/magnoweege/JavaIntelliJInitializr/blob/master/images/006.JPG)
  
