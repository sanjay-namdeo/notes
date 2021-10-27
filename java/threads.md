## Implement Runnable interface
```java
class Scratch implements Runnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new Scratch(), "t1");
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Running");
    }
}
```

## Extend Thread class
```java
class MyThread extends Thread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }

    @Override
    public void run() {
        System.out.println("Running yeh!");
    }
}
```
## Lambda Expression
By using a lambda expression, we can directly write the implementation for a method in Java.

In the below program, we can create a thread by implementing the Runnable interface using lambda expression. While using the lambda expressions, we can skip the new Runnable() and run() method because the compiler knows that Thread object takes a Runnable object and that contains only one method run() that takes no argument.
```java
public class LambdaThreadTest {
   public static void main(String[] args) {
      // Child thread
      new Thread(() -> { // Lambda Expression
         for(int i=1; i <= 5; i++) {
            System.out.println("Child Thread: "+ i);
            try {
               Thread.sleep(500);
            } catch(Exception e) {
               e.printStackTrace();
            }
         }
      }).start();
      // Main Thead
      for(int j=1; j < 5; j++) {
         System.out.println("Main Thread: "+ j);
         try {
            Thread.sleep(500);
         } catch(Exception e) {
            e.printStackTrace();
         }
      }
   }
}
```