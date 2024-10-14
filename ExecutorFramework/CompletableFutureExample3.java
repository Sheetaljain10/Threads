package ExecutorFramework;

import java.util.concurrent.*;
public class CompletableFutureExample3 {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(3);
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(()->{
                try{
                    Thread.sleep(5000);
                    System.out.println("This is worker block ");
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                return "OK";
        },executor).orTimeout(1,TimeUnit.SECONDS).exceptionally(S -> "Timeout occurred");

        try {
            System.out.println(cf.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("THIS IS MAIN THREAD.");
    }
}
