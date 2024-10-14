package create_thread;

public class Thread_class extends Thread {
    @Override
    public void run() {
        for(int i=0;i<50;i++){
            System.out.println("HELLO FROM THREAD CLASS....");
            System.out.println(Thread.currentThread().getName() + "\n");
        }
    }
}
