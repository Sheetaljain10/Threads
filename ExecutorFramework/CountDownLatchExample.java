package ExecutorFramework;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        int n = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(n);

        //without executorservice.
        // for(int i = 0; i < n; i++) {
        //     new Thread(new DependentService(latch)).start(); // Change Callable function to runnable.
        // }

        CountDownLatch latch = new CountDownLatch(n); //THIS ISN'T REUSABLE.
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        latch.await(5, TimeUnit.SECONDS); // AFTER 5 seconds , MAIN SATRTS EXECUTION.
        System.out.println("This is Main Thread..");
        
        // executorService.shutdownNow();
        executorService.shutdown();
    }
}

class DependentService implements Callable<String> {
    private final CountDownLatch latch;
    public DependentService(CountDownLatch latch) {
        this.latch = latch;
    }
    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(6000);
            System.out.println(Thread.currentThread().getName() + " service started.");
        } finally {
            latch.countDown();
        }
        return "ok";
    }
}