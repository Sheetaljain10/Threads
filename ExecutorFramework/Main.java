package ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis(); //This provides milliseconds since 1 JAN 1970.
        // Thread[] threads = new Thread[9]; // MANUAL MULTITHREADING.

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i=1 ; i<10;i++){
            int finalI = i;
            // threads[i-1] = () -> res = factorial(finalI);
            
            executor.submit(()->{
                long res = factorial(finalI);
                System.out.println(res);
            });
         }

         executor.shutdown();

         try {
            while (!executor.awaitTermination(10,TimeUnit.MILLISECONDS)) {
                //INFINITE WAIT, if all threads doesn't execute in given timeout.
                System.out.println("WAITING...");
            }
         } catch (Exception e) {
            throw new RuntimeException(e);
         }
            
        //TO WAIT FOR ALL THREADS TO COMPLETE.
        // for(Thread thread : threads){
        //     try {
        //         thread.join();
        //     } catch (InterruptedException e) {
        //         Thread.currentThread().interrupt();
        //     }
        // }
        System.out.println("Total time: " + (System.currentTimeMillis() - startTime));
    }

    private static long factorial(int n){
        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e ){
            throw new RuntimeException(e);
        }

        long res = 1;
        for(int i=1;i<=n;i++){
            res *= i;
        }
        return res;
    }
}
