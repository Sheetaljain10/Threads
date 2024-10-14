package ExecutorFramework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main2 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable <Integer>  task1 = () -> {
            Thread.sleep(1000);
            System.out.println("TASK 1");
            return 1;
        };

        Callable <Integer> task2 = () -> {
            Thread.sleep(500);
            System.out.println("TASK 2");
            return 2;
        };

        Callable <Integer> task3 = () -> {
            System.out.println("TASK 3");
            return 3;
        };

        List<Callable<Integer>> list = Arrays.asList(task1,task2,task3);

        List<Future<Integer>> futures = null;

        System.out.println("THIS DEALS WITH INVOKEANY() FUNCTION ");
        
        try {
            Integer i = executor.invokeAny(list);
            System.out.println(i);
        } catch (Exception e) {
        }
        
        System.out.println("THIS DEALS WITH INVOKEALL() FUNCTION ");

        try {
            futures = executor.invokeAll(list, 1 , TimeUnit.SECONDS);            
        } catch (Exception e) {
        
        }

        for(Future<Integer> f: futures){
            try {
                System.out.println(f.get());
            }catch (CancellationException e){

            } catch (ExecutionException e){

            } catch (InterruptedException e) {
            }
        }

        executor.shutdown();
        System.out.println("HELLO WORLD");
    }    
}
