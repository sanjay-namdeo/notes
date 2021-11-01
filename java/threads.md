# Threads
## Life cycle
The `java.lang.Thread` class contains a static State enum – which defines its potential states. During any given point of time, the thread can only be in one of these states:

1. `NEW` – a newly created thread that has not yet started the execution
2. `RUNNABLE` – either running or ready for execution but it's waiting for resource allocation
3. `BLOCKED` – waiting to acquire a monitor lock to enter or re-enter a synchronized block/method
4. `WAITING` – waiting for some other thread to perform a particular action without any time limit
5. `TIMED_WAITING` – waiting for some other thread to perform a specific action for a specified period
6. `TERMINATED` – has completed its execution

### 1. New
A NEW Thread (or a Born Thread) is a thread that's been created but not yet started. It remains in this state until we start it using the start() method.

The following code snippet shows a newly created thread that's in the NEW state:
```java
Runnable runnable = new NewState();
Thread t = new Thread(runnable);
Log.info(t.getState());
```
Since we've not started the mentioned thread, the method t.getState() prints:
```bash
NEW
```
### 2. Runnable
When we've created a new thread and called the start() method on that, it's moved from NEW to RUNNABLE state. Threads in this state are either running or ready to run, but they're waiting for resource allocation from the system.

In a multi-threaded environment, the Thread-Scheduler (which is part of JVM) allocates a fixed amount of time to each thread. So it runs for a particular amount of time, then relinquishes the control to other RUNNABLE threads.

For example, let's add t.start() method to our previous code and try to access its current state:
```java
Runnable runnable = new NewState();
Thread t = new Thread(runnable);
t.start();
Log.info(t.getState());
```
This code is most likely to return the output as:
```bash
RUNNABLE
```
Note that in this example, it's not always guaranteed that by the time our control reaches t.getState(), it will be still in the RUNNABLE state.

It may happen that it was immediately scheduled by the Thread-Scheduler and may finish execution. In such cases, we may get a different output.


### 3. Blocked
A thread is in the BLOCKED state when it's currently not eligible to run. It enters this state when it is waiting for a monitor lock and is trying to access a section of code that is locked by some other thread.

Let's try to reproduce this state:
```java
public class BlockedState {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new DemoThreadB());
        Thread t2 = new Thread(new DemoThreadB());
        
        t1.start();
        t2.start();
        
        Thread.sleep(1000);
        
        Log.info(t2.getState());
        System.exit(0);
    }
}

class DemoThreadB implements Runnable {
    @Override
    public void run() {
        commonResource();
    }
    
    public static synchronized void commonResource() {
        while(true) {
            // Infinite loop to mimic heavy processing
            // 't1' won't leave this method
            // when 't2' try to enter this
        }
    }
}
```
In this code:

We've created two different threads – t1 and t2
t1 starts and enters the synchronized commonResource() method; this means that only one thread can access it; all other subsequent threads that try to access this method will be blocked from the further execution until the current one will finish the processing
When t1 enters this method, it is kept in an infinite while loop; this is just to imitate heavy processing so that all other threads cannot enter this method
Now when we start t2, it tries to enter the commonResource() method, which is already being accessed by t1, thus, t2 will be kept in the BLOCKED state
Being in this state, we call t2.getState() and get the output as:
```bash
BLOCKED
```
### 4. Waiting
A thread is in WAITING state when it's waiting for some other thread to perform a particular action. According to JavaDocs, any thread can enter this state by calling any one of the following three methods:

`object.wait()`
`thread.join()` or
`LockSupport.park()`
Note that in `wait()` and `join()` – we do not define any timeout period as that scenario is covered in the next section.

We have a separate tutorial that discusses in detail the use of `wait()`, `notify()` and `notifyAll()`.

For now, let's try to reproduce this state:
```java
public class WaitingState implements Runnable {
    public static Thread t1;

    public static void main(String[] args) {
        t1 = new Thread(new WaitingState());
        t1.start();
    }

    public void run() {
        Thread t2 = new Thread(new DemoThreadWS());
        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            Log.error("Thread interrupted", e);
        }
    }
}

class DemoThreadWS implements Runnable {
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            Log.error("Thread interrupted", e);
        }
        
        Log.info(WaitingState.t1.getState());
    }
}
```
Let's discuss what we're doing here:

We've created and started the t1
t1 creates a t2 and starts it
While the processing of t2 continues, we call t2.join(), this puts t1 in WAITING state until t2 has finished execution
Since t1 is waiting for t2 to complete, we're calling t1.getState() from t2
The output here is, as you'd expect:
```bash
WAITING
```
### 5. Timed Waiting
A thread is in TIMED_WAITING state when it's waiting for another thread to perform a particular action within a stipulated amount of time.

According to JavaDocs, there are five ways to put a thread on TIMED_WAITING state:

`thread.sleep(long millis)`
`wait(int timeout)` or `wait(int timeout, int nanos)`
`thread.join(long millis)`
`LockSupport.parkNanos`
`LockSupport.parkUntil`
To read more about the differences between `wait()` and `sleep()` in Java, have a look at this dedicated article here.

For now, let's try to quickly reproduce this state:
```java
public class TimedWaitingState {
    public static void main(String[] args) throws InterruptedException {
        DemoThread obj1 = new DemoThread();
        Thread t1 = new Thread(obj1);
        t1.start();
        
        // The following sleep will give enough time for ThreadScheduler
        // to start processing of thread t1
        Thread.sleep(1000);
        Log.info(t1.getState());
    }
}

class DemoThread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            Log.error("Thread interrupted", e);
        }
    }
}
```
Here, we've created and started a thread t1 which is entered into the sleep state with a timeout period of 5 seconds; the output will be:
```bash
TIMED_WAITING
```
### 6. Terminated
This is the state of a dead thread. It's in the TERMINATED state when it has either finished execution or was terminated abnormally.

We have a dedicated article that discusses different ways of stopping the thread.

Let's try to achieve this state in the following example:
```java
public class TerminatedState implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new TerminatedState());
        t1.start();
        // The following sleep method will give enough time for 
        // thread t1 to complete
        Thread.sleep(1000);
        Log.info(t1.getState());
    }
    
    @Override
    public void run() {
        // No processing in this block
    }
}
```
Here, while we've started thread t1, the very next statement Thread.sleep(1000) gives enough time for t1 to complete and so this program gives us the output as:
```bash
TERMINATED
```
In addition to the thread state, we can check the isAlive() method to determine if the thread is alive or not. For instance, if we call the isAlive() method on this thread:
```java
Assert.assertFalse(t1.isAlive());
```
It returns false. Put simply, a thread is alive if and only if it has been started and has not yet died.

## Implementation
### Runnable interface
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

### Extend Thread class
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
### Lambda Expression
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

[Reference - Baeldung](https://www.baeldung.com/java-thread-lifecycle)
