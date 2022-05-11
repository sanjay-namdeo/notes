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

---
**Output** - Unreachable Code

```java
public class Demo {
    public static int method1() {
        try {
            throw new ArithmeticException();
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }

    public static void main(String[] args) {
        int result = method1();
        System.out.println(result);
    }
}
```

---
**Output** - 3

```java
public class Demo {
    public static int method1() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }

    public static void main(String[] args) {
        int result = method1();
        System.out.println(result);
    }
}
```

---
**Output** - Unreachable code

```java
public class Demo {
    public static int method1() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
        return 4;
    }

    public static void main(String[] args) {
        int result = method1();
        System.out.println(result);
    }
}
``` 

---
**Output** - 3

```java
public class Demo {
    public static int method1() {
        try {
            int a = 15 / 0;
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }

    public static void main(String[] args) {
        int result = method1();
        System.out.println(result);
    }
}
```

---
**Output** - Not Equal

```java
public class Demo {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("hello");
        StringBuilder sb2 = new StringBuilder("hello");

        if (sb1.equals(sb2)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }
} 
```

---
**Output** - Cannot make a static reference to the non-static field a

```java
class OuterClass {
    int a = 10;
    static int b = 20;
    private static int c = 30;

    static class InnerClass {
        void print() {
            System.out.println("Outer class a : " + a);
            System.out.println("Outer class b : " + b);
            System.out.println("Outer class c : " + c);
        }
    }
}
```
---
**Output** - <br/>outer_x : 10<br/>outer_y : 20<br/>outer_z : 30<br/>

```java
class OuterClass {
    static int outer_x = 10;
    int outer_y = 20;
    private int outer_z = 30;

    class InnerClass {
        void print() {
            System.out.println("outer_x : " + outer_x);
            System.out.println("outer_y : " + outer_y);
            System.out.println("outer_z : " + outer_z);
        }
    }
}

class Scratch {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.print();
    }
}
```