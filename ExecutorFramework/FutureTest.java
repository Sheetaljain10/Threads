package ExecutorFramework;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<Integer> future = executor.submit(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(" Exception: "+ e);
            }
            return 42;
        });

        Integer i = null;

        try {
            i = future.get(1,TimeUnit.SECONDS);
            System.out.println(future.isDone());
            System.out.println(i);
        } catch (CancellationException | TimeoutException | InterruptedException | ExecutionException e) {
            System.out.println(" Exeception: " + e);
        }
        executor.shutdown();
    }
}
