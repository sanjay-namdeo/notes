## Thread Pool

The purpose of having separate dedicated thread-pools is so that an activity doesn't get starved for threads because
other activities took all the threads.

> If a service has its own thread-pool, then it is assured of having a certain number of threads at its disposal, and it's not as sensitive to demands made by other services.

With the multiple dedicated thread-pools if a service needs too many threads then it has to wait for threads to be
available, introducing back-pressure into the system so that it degrades gradually, and since other parts have their own
thread pools they have a chance to catch their parts up. So the idea is that the system should have more stable
characteristics as load changes. In the case you describe having a separate thread-pool for scheduled tasks makes sure
that those tasks get run regardless of how busy the rest of the system is.

The multiple thread-pools would require tuning to make sure each pool had enough threads and not too many. With a single
thread-pool you wouldn't need the tuning and might make better use of all the threads sometimes, but you might not have
the predictability of knowing some important task would get the threads it needed to finish in a timely manner.

> Java provides the Executor framework which is centered around the Executor interface, its sub-interface –ExecutorService and the class-ThreadPoolExecutor, which implements both of these interfaces. By using the executor, one only has to implement the Runnable objects and send them to the executor to execute.
They allow you to take advantage of threading, but focus on the tasks that you want the thread to perform, instead of thread mechanics.

To use thread pools, we first create an object of ExecutorService and pass a set of tasks to it. ThreadPoolExecutor class allows to set the core and maximum pool size.The runnable that are run by a particular thread are executed sequentially.

### Executor Thread Pool Methods
|Method|Description|
|---|---|
|newFixedThreadPool(int)|Creates a fixed size thread pool.|
|newCachedThreadPool()|Creates a thread pool that creates new threads as needed, but will reuse previously constructed threads when they are available|
|newSingleThreadExecutor()|Creates a single thread.|
### Steps to create  a FixedThreadPool

1. Create a task(Runnable Object) to execute
2. Create Executor Pool using Executors
3. Pass tasks to Executor Pool
4. Shutdown the Executor Pool

```java
// Java program to illustrate
// ThreadPool

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Task class to be executed (Step 1)
class Task implements Runnable {
    private String name;

    public Task(String s) {
        name = s;
    }

    // Prints task name and sleeps for 1s
    // This Whole process is repeated 5 times
    public void run() {
        try {
            for (int i = 0; i <= 5; i++) {
                Date d = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                if (i == 0) {
                    System.out.println("Initialization Time for"
                            + " task name - " + name + " = " + ft.format(d));
                    //prints the initialization time for every task
                } else {
                    System.out.println("Executing Time for task name - " +
                            name + " = " + ft.format(d));
                    // prints the execution time for every task
                }
                Thread.sleep(1000);
            }
            System.out.println(name + " complete");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Test {
    // Maximum number of threads in thread pool
    static final int MAX_T = 3;

    public static void main(String[] args) {
        // creates five tasks
        Runnable r1 = new Task("task 1");
        Runnable r2 = new Task("task 2");
        Runnable r3 = new Task("task 3");
        Runnable r4 = new Task("task 4");
        Runnable r5 = new Task("task 5");

        // creates a thread pool with MAX_T no. of
        // threads as the fixed pool size(Step 2)
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

        // passes the Task objects to the pool to execute (Step 3)
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);
        pool.execute(r5);

        // pool shutdown ( Step 4)
        pool.shutdown();
    }
}
```
The output the main method would be as follows-
```
Output:
Initialization Time for task name - task 2 = 02:32:56
Initialization Time for task name - task 1 = 02:32:56
Initialization Time for task name - task 3 = 02:32:56
Executing Time for task name - task 1 = 02:32:57
Executing Time for task name - task 2 = 02:32:57
Executing Time for task name - task 3 = 02:32:57
Executing Time for task name - task 1 = 02:32:58
Executing Time for task name - task 2 = 02:32:58
Executing Time for task name - task 3 = 02:32:58
Executing Time for task name - task 1 = 02:32:59
Executing Time for task name - task 2 = 02:32:59
Executing Time for task name - task 3 = 02:32:59
Executing Time for task name - task 1 = 02:33:00
Executing Time for task name - task 3 = 02:33:00
Executing Time for task name - task 2 = 02:33:00
Executing Time for task name - task 2 = 02:33:01
Executing Time for task name - task 1 = 02:33:01
Executing Time for task name - task 3 = 02:33:01
task 2 complete
task 1 complete
task 3 complete
Initialization Time for task name - task 5 = 02:33:02
Initialization Time for task name - task 4 = 02:33:02
Executing Time for task name - task 4 = 02:33:03
Executing Time for task name - task 5 = 02:33:03
Executing Time for task name - task 5 = 02:33:04
Executing Time for task name - task 4 = 02:33:04
Executing Time for task name - task 4 = 02:33:05
Executing Time for task name - task 5 = 02:33:05
Executing Time for task name - task 5 = 02:33:06
Executing Time for task name - task 4 = 02:33:06
Executing Time for task name - task 5 = 02:33:07
Executing Time for task name - task 4 = 02:33:07
task 5 complete
task 4 complete
```

[Reference - Geeks for Geeks](https://www.geeksforgeeks.org/thread-pools-java/#:~:text=To%20use%20thread%20pools%2C%20we%20first%20create%20a,3%20threads.%20Task%20Queue%20%3D%205%20Runnable%20Objects)