import java.security.InvalidParameterException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceTest {
    public static void main(String[] args) {
        Task task = new Task(25);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> future = executorService.submit(task);

        try {
            System.out.println("Result : " + future.get());
        } catch (InvalidParameterException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}

class Task implements Callable<Integer> {
    private int num;

    public Task(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        if (num < 0) {
            throw new InvalidParameterException("Negative Number not allowed");
        }
        return num * num;
    }

}
