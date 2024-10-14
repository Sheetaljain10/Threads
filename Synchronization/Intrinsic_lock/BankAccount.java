package Synchronization.Intrinsic_lock;

public class BankAccount {
    private int balance = 100;

    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " is attempting to withdraw amount: " + amount );

        if(balance>=amount){
            System.out.println(Thread.currentThread().getName()+" is proceeding with withdrawal..");

            try{
                Thread.sleep(10000);  // DATABASE IMPLEMENTATION
            }
            catch(InterruptedException e){
            }

            System.out.println(Thread.currentThread().getName() + " withdraw successful. Remaining balance: " + balance);
        }
        else{
            System.out.println(Thread.currentThread().getName() + "INSUFFICIENT BALANCE");
        }
    }
}
