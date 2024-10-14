package ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class FutureTest2 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<Integer> future = executor.submit(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(" Exception: "+ e);
            }
            System.out.println("Hello world!!");
            return 42;
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(" Exception: "+ e);
        }

        future.cancel(false);
        System.out.println(future.isCancelled());
        System.out.println(future.isDone());        
        executor.shutdown();
    }
}
