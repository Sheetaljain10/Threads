package ExecutorFramework;

import java.util.concurrent.*;
public class CompletableFutureExample2 {
    public static void main(String[] args) {
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()->{
                try{
                    Thread.sleep(5000);
                    System.out.println("This is worker block ");
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                return "OK";
        });

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(()->{
                try{
                    Thread.sleep(5000);
                    System.out.println("This is worker block 2");
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                return "OK";
        });

        CompletableFuture<Void> voidCompletableFuture =  CompletableFuture.allOf(cf1,cf2);
        voidCompletableFuture.join(); //RETURNS RESULT / EXCEPTION.

        try {
            voidCompletableFuture.get();
        } catch (Exception e) {
        }

        System.out.println("THIS IS MAIN THREAD.");
    }
    
}
