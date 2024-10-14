package Synchronization.Explicit_lock.Fairness_of_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnfairLockExample {
    private final Lock unfairLock = new ReentrantLock();
    public void accessResource(){
        unfairLock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " acquired the lock ");
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        finally{
            System.out.println(Thread.currentThread().getName() + " released the lock ");
            unfairLock.unlock();
        }
    }
    
}
