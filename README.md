# JavaIntelliJInitializr
Simple project from zero to something.

<h3>Phase one:</h3>

- Install intelliJ Ultimate/community;
- Install some basic plugins for intelliJ (if you like) 
- Create a new project for Spring Boot using IntelliJ initializr;
![](https://github.com/magnoweege/JavaIntelliJInitializr/blob/master/001.JPG)

# After that we create this "packages" under main "DemoApplication" com.example.demo."packages"
  
  - Concept MVC (Model, View and Controller):
  - model       // Here we put our model bussines cases (objects) BACKEND
  - controller  // Will be responsible for de communication between View and Model MIDDLEWARE
  - view        // The front website itself (html,jsp,jsf) FRONTEND 
  - repository  // Where the magic happens for data to be persisted!
  
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

![](https://github.com/magnoweege/JavaIntelliJInitializr/blob/master/002.JPG)

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

![](https://github.com/magnoweege/JavaIntelliJInitializr/blob/master/003.JPG)

and se the model you've created in de H2 database in memory.

![](https://github.com/magnoweege/JavaIntelliJInitializr/blob/master/004.JPG)

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

![](https://github.com/magnoweege/JavaIntelliJInitializr/blob/master/005.JPG)
