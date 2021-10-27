# What Spring Boot Starters Are Available out There?

Each starter plays a role as a one-stop-shop for all the Spring technologies we need. Other required dependencies are then transitively pulled in and managed in a consistent way.

All starters are under the `org.springframework.boot` group and their names start with `spring-boot-starter-`. This naming pattern makes it easy to find starters, especially when working with IDEs that support searching dependencies by name.

At the time of this writing, there are more than 50 starters at our disposal. The most commonly used are:

1. `spring-boot-starter`: core starter, including auto-configuration support, logging, and YAML
2. `spring-boot-starter-web`: starter for building web, including REST-ful, applications using Spring MVC
3. `spring-boot-starter-data-jpa`: starter for using Spring Data JPA with Hibernate
4. `spring-boot-starter-security`: starter for using Spring Security
5. `spring-boot-starter-test`: starter for testing Spring Boot applications
6. `spring-boot-starter-aop`: starter for aspect-oriented programming with Spring AOP and AspectJ