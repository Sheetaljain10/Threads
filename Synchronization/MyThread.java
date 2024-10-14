package Synchronization;

public class MyThread extends Thread {
    private Counter  Counter = new Counter();

    public MyThread(Counter Counter){
        this.Counter = Counter;
    }
    @Override
    public void run(){
        for(int i=0;i<1000;i++){
            Counter.increment();
        }
    }   
}
