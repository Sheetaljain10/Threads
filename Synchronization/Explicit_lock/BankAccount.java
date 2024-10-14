package Synchronization.Explicit_lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;

    private final Lock lock = new ReentrantLock();  //Lock class implementation. final , so no one changes it.

    public void withdraw(int amount){

        // lock.lock(); similar to synchronized.

        System.out.println(Thread.currentThread().getName() + " is attempting to withdraw amount: " + amount );
        try {
            if(lock.tryLock(1000,TimeUnit.MILLISECONDS)){
                if(balance >= amount){
                    try{
                    System.out.println(Thread.currentThread().getName()+" is proceeding with withdrawal..");
                    Thread.sleep(3000);  // DATABASE IMPLEMENTATION
                    balance-=amount;
                    System.out.println(Thread.currentThread().getName() + " withdraw successful. Remaining balance: " + balance);
                }
                catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                finally{
                    lock.unlock(); 
                }
            }
            else{
                    System.out.println(Thread.currentThread().getName() + "INSUFFICIENT BALANCE");
                }
            }
            else{
                System.out.println(Thread.currentThread().getName() + " Couldn't aquire the lock, Will try again later!!");
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

        if(Thread.currentThread().isInterrupted()){
            System.out.println("MAINTAINANCE CODE");
        }
    }
}
