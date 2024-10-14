package ExecutorFramework;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        int numberOfSubsystems = 4;
        CyclicBarrier barrier = new CyclicBarrier(numberOfSubsystems, new Runnable() {
            @Override
            public void run(){
                System.out.println("ALL SUBSYSTEMS ARE UP AND RUNNING. SYSTEM STARTUP COMPLETED.");
            }
        });

        Thread webServerThread = new Thread(new Subsystem("WEB SERVER", 2000, barrier));
        Thread databaseThread = new Thread(new Subsystem("DATABASE", 3000, barrier));
        Thread cacheThread = new Thread(new Subsystem("CACHE", 4000, barrier));
        Thread messagingServicThread = new Thread(new Subsystem("MESSAGING SERVICES", 3500, barrier));

        webServerThread.start();
        databaseThread.start();
        cacheThread.start();
        messagingServicThread.start();
    }
}
class Subsystem implements Runnable{
    private String name;
    private int initializationTime;
    private CyclicBarrier barrier;

    public Subsystem(String name , int initializationTime, CyclicBarrier barrier){
        this.name = name;
        this.initializationTime = initializationTime;
        this.barrier = barrier;
    }

    @Override
    public void run(){
        try {
            System.out.println(name + " initialization started.");
            Thread.sleep(initializationTime);
            System.out.println(name + " initialization completed.");
            barrier.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
