package Synchronization;

public class Counter {
    private int count = 0;

    //CRITICAL SECTION -  TWO WAYS OF USING SYNCHRONIZED KEYWORD.
    public synchronized void increment(){
        synchronized(this){
            count++;
        }
    }

    public int getCount(){
        return count;
    }

}
