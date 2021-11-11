# How Spring Boot Works

Spring boot provides many abstraction layers to ease the development, underneath there are vital libraries which work for us. 

Below is the key function performing internally.

- Using @EnableAutoConfigure annotation the spring boot application configures the spring boot application automatically. 
E.g. If you need MySQL DB in your project, but you haven’t configured any database connection, in that case, Spring boot auto configures as in memory database.
- The entry point of spring boot application is a class which contains @SpringBootApplication annotation and has the main method.
- Spring boot scan all the components included in the project by using @ComponentScan annotation.
- Let’s say we need the Spring and JPA for database connection, then we no need to add the individual dependency we can simply add the spring-boot-starter-data-jpa in the project.
- Spring boot follows the naming convention for dependency like spring-boot-starter. 
- Considering above there are other internal functions which play a significant role in spring boot.
