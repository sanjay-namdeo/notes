**Output** - Exception IOException is not compatible with throws clause in Parent.hello()
```java
class Parent {
    public void hello() {
        System.out.println("Parent class hello method");
    }
}

class Child extends Parent {
    public void hello() throws IOException {
        System.out.println("Child class hello method");
    }
}
```
---
**Output** - Runtime exception
```java
public class Demo {
    public static void method1() {
        method2();
    }

    public static void method2() {
        throw new ArithmeticException("ArithmeticException from method2");
    }

    public static void main(String[] args) {
        method1();
    }
}
```