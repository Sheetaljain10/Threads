package ExecutorFramework;

import java.util.concurrent.*;
public class Executor_submit {
    public static void main(String[] args) throws InterruptedException , ExecutionException{
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<String> callable = ()->"THIS IS EXECUTOR SUBMIT"; 
        Future<String> future = executor.submit(callable);
        if(future.isDone()){
            System.out.println("Task is Done..!");
        }
        System.out.println(future.get());
        executor.shutdown();
        Thread.sleep(1000);
        System.out.println(executor.isTerminated());
        Future<?> future2 = executor.submit(()-> System.out.println("THIS RETURNS FUTURE EXPECTED OUTPUT UPON SUCCESSFUL IN GET() METHOD"), "SUCCESS");
        System.out.println(future2.get());
    }
}
