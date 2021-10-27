# Decorator Pattern

A Decorator pattern can be used to `attach additional responsibilities to an object either statically or dynamically`. A
Decorator provides an enhanced interface to the original object.

## When to use

1. When we wish to add, enhance or even remove the behavior or state of objects
2. When we just want to modify the functionality of a single object of class and leave others unchanged

## Example

Suppose we have a Christmas tree object, and we want to decorate it. The *decoration does not change the object itself*
it’s just that in addition to the Christmas tree, we’re adding some decoration items like garland, tinsel, tree-topper,
bubble lights, etc.:

First, we’ll create a ChristmasTree interface and its implementation:

```java
public interface ChristmasTree {
    String decorate();
}
```

The implementation of this interface will look like:

```java
public class ChristmasTreeImpl implements ChristmasTree {
    @Override
    public String decorate() {
        return "Christmas tree";
    }
}
```

We’ll now create an abstract TreeDecorator class for this tree. This decorator will implement the ChristmasTree
interface as well as hold the same object. The implemented method from the same interface will simply call to decorate()
method from our interface:

```java
public abstract class TreeDecorator implements ChristmasTree {
    private ChristmasTree tree;

    @Override
    public String decorate() {
        return tree.decorate();
    }
}
```

We’ll now create some decorating element. These decorators will extend our abstract TreeDecorator class and will modify
its decorate() method according to our requirement:

```java
public class BubbleLights extends TreeDecorator {
    public BubbleLights(ChristmasTree tree) {
        super(tree);
    }

    public String decorate() {
        return super.decorate() + decorateWithBubbleLights();
    }

    private String decorateWithBubbleLights() {
        return " with Bubble Lights";
    }
}
```