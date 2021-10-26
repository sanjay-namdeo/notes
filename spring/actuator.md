## Actuator

It helps you to **access the current state of an application that is running in a production environment**. Multiple metrics can be used to check the current state. They also provide endpoints for RESTful web services which can be simply used to check the different metrics.

1. Add **spring-boot-starter-actuator** dependency
2. *curl* localhost:8080/actuator/health
```json
{
  "status": "UP"
}
```

3. Set *management.endpoints.web.exposure.include* as * to activate all actuator endpoints in the application.properties file.
```properties
management.endpoints.web.exposure.include=*
```

4. HTTP trace is disabled by default after Spring Boot 2.2 as it captures HTTP requests and logs in the memory. To fix this, just create a bean of *HttpTraceRepository* which is an in-memory repository.
```java
@Configuration
public class Controller {
    @Bean
    public HttpTraceRepository httpTraceRepository() {
        return new InMemoryHttpTraceRepository();
    }
}
```

5. We can change the base path from /actuator to something else using
```properties
management.endpoints.web.base-path=/manage
```

6. Change actuator endpoint:
```properties
management.server.port=8085
```
