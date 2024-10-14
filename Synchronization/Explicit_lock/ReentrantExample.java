package Synchronization.Explicit_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {

    private final Lock lock = new ReentrantLock();

    /*DEADLOCK : Inner method is waiting for outerr method to finish and vice versa. */
    
    // HERE, REENTRANTLOCK ALLOWS TO AQUIRE LOCK AGAIN BY SAME THREAD.
    // HERE , MAIN IS ONLY SINGLE THREAD THAT IS RUNNING.
    // PAIRS OF LOCK-UNLOCK MUST EXIST. ELSE EXCEPTION.

    public void outerMethod(){
        try{
            lock.lockInterruptibly(); // COUNT = 1
            System.out.println("Outer Method");
            innerMethod();
        }
        catch (Exception e){
        }
        finally{
            lock.unlock(); // COUNT = 0
        }
    }
    public void innerMethod(){
        lock.lock(); // COUNT = 2
        try{
            System.out.println("Inner Method");
        }
        finally{
            lock.unlock(); // COUNT = 1
        }
    }



    public static void main(String[] args) {
        ReentrantExample example = new ReentrantExample();
        example.outerMethod();
    }
}
