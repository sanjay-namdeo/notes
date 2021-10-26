## Spring Annotations

### Required
Indicates that the annotated *bean must be populated at configuration time with the required property*, else it throws BeanInitializationException.

```java
@Required
public void setName(String name) {
    this.name = name;
}
```

### Autowired
Spring provides annotation-based auto-wiring by providing @Autowired annotation. Autowiring a bean is done by matching data-type.

```java
@Autowired
private Customer customer;
```

### Configuration
It is a class-level annotation. Classes annotated with @Configuration are used by Spring containers as a *source of bean definitions*. It indicates that the class has @Bean definition methods. So Spring container can process the class and generate Spring Beans to be used in the application.

```java
@Configuration
public class Vehicle {
    @Bean
    Vehicle engine() {
         return new Vehicle();
    }
}
```

### ComponentScan
**To scan a packge for beans** It is used with @Configuration annotation. We can specify the base package to scan for Spring components.

```java
@ComponentScan(basePackages = "com.mypackage")
@Configuration
public class ScanComponent {
```

### Bean
It is a method-level annotation. Alternative to XML <bean> tag. It tells the *method to produce a bean* to be managed by Spring container.

```java
@Bean
public BeanExample beanExample() {
    return new BeanExample();
}
```

### Steretype Annotations
*@Component* marks the class as Bean. Class is found in class path and then pick up by Spring which configure it in application context as Spring Bean.
*@Controller* marks the class as bean and used web request handler
*@Service* marks the class as bean and used for business logic
*@Repository* marks the class a repository of DAOs(Data Access Object) that access the database directory. The respository contains all the operations related to the database.

### Spring Boot Annotations
*@EnableAutoConfiguration* It auto-configures the bean that is present in classpath and configures it to run the methods.
*@SpringBootApplication* It is a combination of three annotations @EnableAutoConfiguration, @ComponentScan and @Configuration

> @SpringBootApplication is a combination of three annotations @EnableAutoConfiguration, @ComponentScan and @Configuration

### Spring MVC and REST Annotations
*@RequestMapping* used to map web requests. 
*@GetMapping* for HTTP GET
*@PostMapping* for HTTP POST
*@PutMapping* for HTTP PUT
*@DeleteMapping* for HTTP DELETE
*@PatchMapping* for HTTP PATCH
*@RequestBody* to bind HTTP request with an object in a method parameter. Binds the incoming HTTP request body to that parameter.
*@ResponseBody* binds the method return value to the response body. It tells Spring to serialize an object into JSON or XML format.

*@RequestParam* to extract the query parameters from the URL.
*@PathVariable* to extact the values from the URI

*@RequestHeader* to get the details of HTTP request headers.
*@RestController* it is a combination of @Controller and @ResponseBody
