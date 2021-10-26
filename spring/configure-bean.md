## Different ways to configure a class as Spring Bean

1. *XML Configuration* we can use bean element in context file to configure a Spring Bean.
```xml
<bean name="myBean" class="com.test.MyBean "></Bean>
```
2. *Java Based Configuration* In Configuration class annotated with @Configuration, you can configure a Spring bean using @Bean annotation.
```java
@Configuration
@ComponentScan(value = "com.test.MyBean")
public class MyConfiguration {
  @Bean
   public MyBean getBean() {
      return new MyBean();
   }
}
``` 
3. *Annotation Based Configuration* We can also use `@Component`, `@Service`, `@Repository` and `@Controller` annotations with classes to configure them to be as Spring bean.
