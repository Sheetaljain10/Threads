package Synchronization.Explicit_lock.Fairness_of_lock;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        FairLockExample example = new FairLockExample();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                example.accessResource();
            }
        };

        Thread thread1 = new Thread(task,"Thread 1");
        Thread thread2 = new Thread(task,"Thread 2");
        Thread thread3 = new Thread(task,"Thread 3");

        thread1.start();
        Thread.sleep(50);
        thread2.start();
        Thread.sleep(50);
        thread3.start();
        Thread.sleep(50);
    }   
}