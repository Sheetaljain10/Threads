package Thread_methods;

public class MyThread2 extends Thread {
    public MyThread2(String name){
        super(name);
    }
    @Override
    public void run() {
        String p = "";
        try {
            Thread.sleep(1000);
            for(int i=1;i<=5;i++){
                p = p + ""; //Just for usage
                for(int j=0;j<=10000;j++){
                    p += "a";
                }
                System.out.println(Thread.currentThread().getName()+ " IS RUNNING......" + " PRIORITY: " + Thread.currentThread().getPriority() + " COUNT: " + i ); //OUTPUT: Thread-0 PRIORITY:5
                Thread.yield();
            }
        } catch (InterruptedException e) {
            System.out.println( Thread.currentThread().getName() + " INTERRUPTED: " + e);
        }
    }
    public static void main(String[] args) {
        MyThread2 low_p = new MyThread2("THREAD 1");
        MyThread2 med_p = new MyThread2("THREAD 2");
        MyThread2 high_p = new MyThread2("THREAD 3");
        low_p.setPriority(Thread.MIN_PRIORITY);
        med_p.setPriority(Thread.NORM_PRIORITY);
        high_p.setPriority(Thread.MAX_PRIORITY);
        low_p.start();
        med_p.start();
        high_p.start();
        high_p.interrupt();
    }
}
