package Synchronization.Explicit_lock.Fairness_of_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLockExample {
    private final Lock fairLock = new ReentrantLock(true);
    public void accessResource(){
        fairLock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " acquired the lock ");
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        finally{
            System.out.println(Thread.currentThread().getName() + " released the lock ");
            fairLock.unlock();
        }
    }
    
}

