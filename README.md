# JavaIntelliJInitializr
Simple project from zero to something.

Phase one:

- Install intelliJ Ultimate/community;
- Install some basic plugins for intelliJ (if you like) 
- Create a new project for Spring Boot using IntelliJ initializr;
- After that we create this "packages" under main "DemoApplication" com.example.demo."packages"
  
  Conceito MVC (Model, View and Controller):

  - model       // Aquificaram seus modelos de negócios (objetos) BACKEND
  - controller  // Fará a comunicação da View com o Model MIDDLEWARE
  - view        // FRONTEND 

  - repository  // Persistencia no Banco de dados
  
  - After that we are going to create the files we will needed:
  
    -inside model > new class file "Website.java"
    -inside controller > leave it for now!
    -inside view > leave it for now!
    -inside repository > new interface file WebsiteRepository.java
  
  - insert inside the model>Website.java:
  
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

insert inside the model>Website.java:

package com.example.demo.repository;

import com.example.demo.model.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebsiteRepository extends JpaRepository<Website, Long>{

```

insert inside the DemoApplication.java:

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

```

Now if you save all the files and start the application you will be able to access 

http://localhost/h2 //without password

and se the model you've created in de H2 database in memory.
