package ExecutorFramework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
                try{
                    Thread.sleep(5000);
                    System.out.println("This is worker block ");
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                return "OK";
        });

        String s = null;

        //COMMENT AND SEE.
        s = completableFuture.getNow("FINE IF NO RESULT");

        try {
            s = completableFuture.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        catch (ExecutionException e){
            throw new RuntimeException(e);
        }
        System.out.println(s);
        System.out.println("THIS IS MAIN THREAD.");
    }
    
}
