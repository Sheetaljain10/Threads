package ExecutorFramework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutor {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        
        ScheduledFuture <?> scheduledFuture1 = scheduler.scheduleAtFixedRate(()-> System.out.println("TASK EXECUTED AFTER EVERY 5 SECONDS !"),
        5, 
        5, 
        TimeUnit.SECONDS);

        ScheduledFuture <?> scheduledFuture2 = scheduler.scheduleWithFixedDelay(()-> System.out.println("TASK EXECUTED AFTER EVERY 5 SECONDS DELAY FROM PREVIOUS TASK !"),
        5, 
        5, 
        TimeUnit.SECONDS);

        scheduler.schedule(()-> {
            System.out.println("INITIATING SHUTDOWN....");
            scheduler.shutdown();
        }, 
        20, TimeUnit.SECONDS);

        try {
            System.out.println(scheduledFuture1.get()+"  "+scheduledFuture2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
