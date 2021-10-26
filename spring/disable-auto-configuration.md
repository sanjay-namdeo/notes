## How to Disable a Specific Auto-Configuration?
If we want to disable a specific auto-configuration, we can indicate it using the exclude attribute of the `@EnableAutoConfiguration` annotation. For instance, this code snippet neutralizes DataSourceAutoConfiguration:
```java
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class MyConfiguration { }
```
If we enabled auto-configuration with the `@SpringBootApplication` annotation — which has `@EnableAutoConfiguration` as a meta-annotation — we could disable auto-configuration with an attribute of the same name:
```java
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MyConfiguration { }
```
We can also disable an auto-configuration with the `spring.autoconfigure.exclude` environment property. This setting in the application.properties file does the same thing as before:
```properties
spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
```
