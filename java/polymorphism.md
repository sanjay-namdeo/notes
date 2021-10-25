## Polymorphism

An ability to exist in multiple forms. It allows to perform a single operation in different ways.

### Compile-time
Also known as static binding. Achieved by function overloading and operator overloading. Java doesn't support operator
overloading.

```java
class MultiplyFun {
    static int Multiply(int a, int b) {
        return a * b;
    }

    static double Multiply(double a, double b) {
        return a * b;
    }
}
```

### Runtime
Also known as Dynamic binding OR Dynamic method dispatch. Function calls to overriden method is resolved at Runtime.

```java
class Parent {
    void Print() {
        System.out.println("parent class");
    }
}

class subclass1 extends Parent {
    void Print() {
        System.out.println("subclass1");
    }
}

class subclass2 extends Parent {
    void Print() {
        System.out.println("subclass2");
    }
}

class TestPolymorphism3 {
    public static void main(String[] args) {
        Parent a;

        a = new subclass1();
        a.Print();

        a = new subclass2();
        a.Print();
    }
}
```
