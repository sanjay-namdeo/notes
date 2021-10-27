# Factory Method Design Pattern

This pattern `defines an interface for creating an object, but let subclasses decide which class to instantiate` The
Factory method lets a class defer instantiation to subclasses”.

This pattern delegates the responsibility of initializing a class from the client to a particular factory class by
creating a type of virtual constructor.

## How to design

To achieve this, we rely on a factory which provides us with the objects, hiding the actual implementation details. The
created objects are accessed using a common interface.

## When to use

1. When the implementation of an interface or an abstract class is expected to change frequently
2. When the current implementation cannot comfortably accommodate new change
3. When the initialization process is relatively simple, and the constructor only requires a handful of parameters

## Example

Let’s first create the Polygon interface:

```java
public interface Polygon {
    String getType();
}
```

Next, we’ll create a few implementations like Square, Triangle, etc. that implement this interface and return an object
of Polygon type.

Now we can create a factory that takes the number of sides as an argument and returns the appropriate implementation of
this interface:

```java
public class PolygonFactory {
    public Polygon getPolygon(int numberOfSides) {
        if (numberOfSides == 3) {
            return new Triangle();
        }
        if (numberOfSides == 4) {
            return new Square();
        }
        if (numberOfSides == 5) {
            return new Pentagon();
        }
        if (numberOfSides == 7) {
            return new Heptagon();
        } else if (numberOfSides == 8) {
            return new Octagon();
        }
        return null;
    }
}
```

Notice how the client can rely on this factory to give us an appropriate Polygon, without having to initialize the
object directly.