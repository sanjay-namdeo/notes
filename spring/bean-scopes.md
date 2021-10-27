# Spring Bean Scopes

## singleton (default scope)
Container creates a single instance of that bean and all the requests for that bean name will return the same object, which is cached.
Any modifications to the object will be reflected in all references to the bean. 

```java
@Bean
@Scope("singleton")
public Person personSingleton() {
    return new Person();
}
```

## prototype
Returns a different instance every time it is requested from the container.

```java
@Bean
@Scope("prototype")
public Person personPrototype() {
    return new Person();
}
```

## request
Creates a bean instance for each HTTP request.

```java
@Bean
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public HelloMessageGenerator requestMessage() {
    return new HelloMessageGenerator();
}
```
proxyMode attribute is necessary because at the moment of the instantiation of the web application context, there is no active request. Spring will create a proxy to be injected as a dependency, and instantiate the target bean when it is needed in a request.

## session
Creates a bean instance for an HTTP session.

```java
@Bean
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public HelloMessageGenerator requestMessage() {
    return new HelloMessageGenerator();
}
```

### globalSession
Creates a bean for a global HTTP session. This type of scope is used in appliations with a portlet container, each portlet having its own session. The bean with this scope will be available over all sessions.
