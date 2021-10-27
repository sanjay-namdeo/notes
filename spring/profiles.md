# Spring Profiles
Profile annotation maps a bean to a particular profile

Consider a scenarion where we want a bean to be available for a for development environment. We can annotate that bean with a /dev profile/, and it will be present in container during development. It will be inactive in any other environment,

```java
@Component
@Profile("dev")
public class DataSourceConfig
```

> Profiles can be prefixed with NOT operator to exclude it from a profile

Consider below scenarion where we have deactivated a bean for /dev environment/

```java
@Component
@Profile("dev")
public class DataSourceConfig
```

## How to activate a profile
1. While *starting the application*
```bash
mvn spring-boot:run *-Dspring-boot.run.profiles=dev*
```

2. In Unix, using *environment variable*
```bash
export spring_profiles_active=dev
```

3. Using *ConfigurableEnvironment*
```java
@Autowired
private ConfigableEnvironment env;
...
env.setActiveProfile("dev");
```

4. Programmatically via *WebApplicationInitializer*
```java
@Configuration
public class MyWebApplicationInitializer implement WebApplicationInitializer {
  @Override
  public void onStartup(ServletContext) throws ServletException {
    servletContext.setInitParameter("spring.profile.active", "dev");
  }
}
```
