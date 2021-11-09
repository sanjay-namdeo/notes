## DependsOn Annotation

Spring, by default, manages beans' lifecycle and arranges their initialization order. But we can still customize it based on our needs. 

**We can choose SmartLifeCycle interface or the `@DependsOn` annotation for managing initialization order.**

### Steps
1. Add spring-context dependency.
```xml
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-context</artifactId>
  <version>5.2.8.RELEASE</version>
</dependency>
```
2. @DependsOn
> Spring guarantees that the defined beans will be initialized before attempting an initialization of the current bean.
Let's say we have FileProcessor which  depends on  FileReader and FileWriter. In this case, FileReader and FileWriter should be initialized before the FileProcessor.

3. Configuration
The configuration file is a pure Java class with @Configuration annotation
```java
@Configuration
@ComponentScan("com.my.package")
public class Config {
  @Bean
  @DependsOn({"fileReader", "fileWriter"})
  public FileProcessor fileProcessor() {
    return new FileProcessor();
  }

  @Bean("fileReader")
  public FileReader fileReader() {
    return new FileReader();
  }

  @Bean("fileWriter") 
  public FileWriter fileWriter() {
    return new FileWriter();
  }
}
```

**FileProcessor specifies its dependencies with @DependsOn**

We can also annotate a component with @DependsOn

```java
@Component
@DependsOn({"fileReader", "fileWriter"})
public class FileProcessor {}
```

In case of **Missing Dependency**, Spring throws a `BeanCreationException` with a base exception of `NoSuchBeanDefinitionException`


> Circular Dependency can happen if a bean has an eventual dependency on itself, creating a circle

```
Bean 1 -> Bean 4 -> Bean 6 -> Bean 1
```
