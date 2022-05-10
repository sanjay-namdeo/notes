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