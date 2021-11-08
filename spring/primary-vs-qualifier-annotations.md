# Different between @Primary and @Qualifier annotations

`@Primary` indicates that a bean should be given preference when multiple candidates are qualified to autowire a single-valued dependency.

`@Qualifier` indicates specific bean should be autowired when there are multiple candidates.

For example, we have two beans both implement the same interface.
```java
public interface BeanInterface {

    String getName();
}

@Component
public class Bean1 implements BeanInterface {
    @Override
    public String getName() {
        return "bean 1";
    }
}

@Component
public class Bean2 implements BeanInterface {
    @Override
    public String getName() {
        return "bean2";
    }
}
```
Here is our service.
```java
@Service
public class BeanService {

    @Autowired
    private BeanInterface bean;
}
```
And our configuration.
```java
@Configuration
public class Config {

    @Bean("bean1")
    public BeanInterface bean1() {
        return new Bean1();
    }

    @Bean("bean2")
    public BeanInterface bean2() {
        return new Bean2();
    }
}
```
When Spring starts, it will find there are two beans("bean1" and "bean2") both can be autowired to BeanService since they implement the same interface BeanInterface. It reports an error in my Idea.
```bash
Could not autowire. There is more than one bean of 'BeanInterface' type.
Beans: bean1   (Config.java) 
bean2   (Config.java) 
```
And without a hint, Spring does not know which one to use.

So in our case, when we add @Primary to Config.bean1().
```java
@Bean("bean1")
@Primary
public BeanInterface bean1() {
    return new Bean1();
}
```
It tells Spring, "when you find more than one beans that both can be autowired, please use the primary one as your first choose." So, Spring will pick bean1 to autowire to BeanService.

Here is another way to autowire bean1 to BeanService by using @Qualifier in BeanService.class.
```java
@Service
public class BeanService {

    @Autowired
    @Qualifier("bean1")
    private BeanInterface bean;
}
```
@Qualifier will tell Spring, "no matter how many beans you've found, just use the one I tell you."

So you can find both @Qualifier and @Primary are telling Spring to use the specific bean when multiple candidates are qualified to autowire. But @Qualifier is more specific and has high priority. So when both @Qualifier and @Primary are found, @Primary will be ignored.

Here is the test.
```java
@Configuration
public class Config {

    @Bean("bean1")
    @Primary
    public BeanInterface bean1() {
        return new Bean1();
    }

    @Bean("bean2")
    public BeanInterface bean2() {
        return new Bean2();
    }
}

@Service
public class BeanService {

    @Autowired
    @Qualifier("bean2")
    private BeanInterface bean;

    @PostConstruct
    public void test() {
        String name = bean.getName();
        System.out.println(name);
    }
}
```
The output is "bean2".
