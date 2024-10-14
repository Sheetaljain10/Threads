package Synchronization.Explicit_lock.Fairness_of_lock;

public class Main1 {

    public static void main(String[] args) {
        UnfairLockExample example = new UnfairLockExample();
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
        thread2.start();
        thread3.start();
    }  
}
