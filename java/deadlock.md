### Deadlock
When two or more threads are waiting for each other to release the lock and get stuck for infinite time

### How to detect
1. Check for nested synchronized blocks and trying to get a lock on different objects
2. Check if there is one synchronized method called from another synchronized method and trying to get a lock on different objects
3. Take thread dump using kill -3 in Linux and using VisualVM in Windows. Then check which thread is a lock on which object.

### Deadlock situation
This method request two locks, first String and then Integer
```java
public void method1() {
   synchronized(String.class) {
      sout("Acquired lock on String.class object");

         synchronized(Integer.class) {
            sout("Acquired lock on Integer.class object");
         }
   }
}
```

This method also requests the same two locks but in exactly opposite order i.e. first Integer and then String. This creates potential deadlock if one thread holds String lock and the other holds Integer lock and they wait for each other, forever.
```java
public void method2() {
   synchronized(Integer.class) {
      sout("Acquired lock on Integer.class");

      synchronized(String.class) {
         sout("Acquired lock on String.class");
      }
   }
}
```

If method1() and method2() both will be called by two or more threads, there is a good chance of deadlock because if thread1 acquired lock on string object while executing method1() and thread2 acquired lock on Integer object while executing method2, both will be waiting for each other to release the lock on Integer and String to proceed further which will never happen.

### How to avoid deadlock
If you have looked above code carefully, then we may have figured out that the real reason for the deadlock is the way they are requesting locks if we provide ordered access, then the problem will be resolved.

```java
public void method1() {
   synchronized(Integer.class) {
      sout("Acquired lock on Integer.class object");

      synchronized(String.class) {
         sout("Acquired lock on String.class object");
      }
   }
}

public void method2() {
   synchronized(Integer.class) {
      sout("Acquired lock on Integer.class object");

      synchronized(String.class) {
         sout("Acquired lock on String.class");
      }
   }
}
```

Both the methods are not requesting lock-in same order, first Integer and then String. We could also do reverse.