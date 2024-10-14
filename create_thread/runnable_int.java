package create_thread;

public class runnable_int implements Runnable {
    @Override 
    public void run(){
        for(int i=0;i<50;i++){
            System.out.println("HI FROM RUNNABLE INTERFACE");
            System.out.println(Thread.currentThread().getName() + "\n");
        }
    }
}
