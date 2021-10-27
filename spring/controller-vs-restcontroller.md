# Controller vs Rest Controller

Spring’s annotation-based mvc framework simplifies the process of creating restful web services. the key difference
between a traditional spring mvc controller and the restful web service controller is the way the http response body is
created. While `the traditional mvc controller relies on the view technology`,
the `restful web service controller simply returns the object and the object data is written directly to the http response as json/xml`
.

## Spring MVC Rest Workflow

1. The client sends a request to a web service in uri form.
2. The request is intercepted by the `DispatcherServlet` which looks for handler mappings and its type.
3. Requests are processed by the controller and the response is returned to the `DispatcherServlet` which then
   dispatches to the view.

### @ResponseBody Annotation

Spring converts the return value and writes it to the http response automatically. Each method in the controller class
must be annotated with `@ResponseBody`

### Behind the Scenes

Spring has a list of `HttpMessageConverter` registered in the background. the responsibility of
the `HttpMessageConverter` is to convert the request body to a specific class and back to the response body again,
depending on a predefined mime type. Every time an issued request hits `@responsebody`, spring loops through all
registered `HttpMessageConverter` seeking the first that fits the given mime type and class, and then uses it for the
actual conversion.

```java
@controller
@RequestMapping("employees")
public class EmployeeController {
    Employee employee = new Employee();

    @requestmapping(value = "/{name}", method = requestmethod.get, produces = "application/json")
    public @responsebody
    employee getEmployeeInJSON(@pathvariable string name) {
        employee.setname(name);
        employee.setemail("employee1@genuitec.com");
        return employee;
    }
}
```

## @RestController Annotation

Spring 4.0 introduced `@RestController`, a specialized version of the controller which is a convenience annotation that
does nothing more than **add the @controller and @ResponseBody annotations**. By annotating the controller class with
@RestController annotation, you no longer need to add @ResponseBody to all the request mapping methods. the
@ResponseBody annotation is active by default.

> To use @RestController in our example, all we need to do is modify the `@Controller` to `@RestController` and remove the `@ResponseBody` from each method.

The resultant class should look like the following:

```java
@RestController
@RequestMapping("employees")
public class EmployeeController {
}
```

#### Reference [DZone](https://dzone.com/articles/spring-framework-restcontroller-vs-controller)