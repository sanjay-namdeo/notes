# Bean Injection

## Constructor Injection
It is the most straightforward and recommanded way of dependency injection.

> Constructor Injection helps in creating immutable objects because a contructor's signature is the only possible way to create objects

1. A depedent class has a contructor, where all dependencies are set, they will be provided by Spring container according to XML, Java or annotation based configurations.
2. Constructed object is immutable and returned to the client in a fully initializes state.

```java
class DependentService {
  private final Service1 service1;
  private final Service2 service2;

  public DepndentService(Service1 service1, Service2 service2) {
     this.service1 = service1;
     this.service2 = service2;
  }
}
```

## Setter Injection
It allows to inject a bean with a setter method

```java
class DependentService {
  priavate final Service1 service1;

  @Autowired
  public DependentService(Service1 service1) {
    this.service1 = service1;
  }
}
```

## Field Injection 
With @Autowired annotation
```java
class Dependent {
  @Autowired
  private Service1 service1;
}
```
