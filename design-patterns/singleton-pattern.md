# Singleton Design Pattern

It stats that `only one instance of the object exists throughout the Java Virtual Machine`.

> A Singleton class also provides one unique global access point to the object so that each subsequent call to the access point returns only that particular object.

### How to design

1. Make constructor as Private
2. Write a static method that has return type object of this singleton class.

### When to Use

1. For resources that are expensive to create (like database connection objects)
2. It’s good practice keeping all loggers as Singletons which increases performance
3. Classes which provide access to configuration settings for the application
4. Classes that contain resources that are accessed in shared mode

### Example

```java
public class Singleton {
    private Singleton() {
    }

    private static class SingletonHolder {
        public static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
```

Here, we’ve created a static inner class that holds the instance of the Singleton class. `It creates the instance only
when someone calls the getInstance() method and not when the outer class is loaded.`

This is a widely used approach for a Singleton class as `it does not require synchronization, is thread safe, enforces
lazy initialization and has comparatively less boilerplate`.

Also, note that the `constructor has the private access modifier`. This is a requirement for creating a Singleton since a
public constructor would mean anyone could access it and start creating new instances.