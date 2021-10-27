# Spring Bean Life Cycle

When container starts, Spring beans are instantiated, based on Java or XML bean definition. It may also be required to
perform some post-initialization steps to get into a usable state.

When a bean is no longer required, it will be removed from the IoC container.

> Spring bean factory is responsible for managing the life cycle of beans created through spring container.

## Bean Post Processor

It contains two methods

1. `postProcessBeforeInitialization` Spring calls this method after calling the method of the aware interfaces and
   before any bean initialization call back such as `InitializingBean`, `afterPropertiesSet` or a custom `init` method.
2. `postProcessAfterInitialization` Spring calls this method after any bean initialization callback.

```java
public class BookBeanProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("Post Process Before Initialization");
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("Post Process After Initialization");
    }
}
```

## InitializingBean and DisposableBean Callback Interfaces

There are two callbacks

1. `InitializingBean` Declares the `afterPropertiesSet()` method which can be used to write initializing logic. The
   container calls the method after properties are set.
2. `DisposableBean` Declares the `destroy()` method which can be used to write any clean up code. The container calls
   this method during bean destruction in shutdown.

```java
public class Book implements InitializingBean, DisposableBean {
    @Override
    public void afterPropertiesSet() {
        System.out.println("Destroy method of Book bean called !");
    }

    @Override
    public void destroy() {
        System.out.println("afterPropertiesSet method of Book bean is called!");
    }
}
```