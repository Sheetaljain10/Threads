package Thread_methods;

public class Deamon_Thread extends Thread {
    @Override
    public void run() {
        while(true){
            System.out.println(" HELLO WORLD!");
        }
    }
    public static void main(String[] args) {
        Deamon_Thread dt = new Deamon_Thread();
        dt.setDaemon(true);
        Deamon_Thread user = new Deamon_Thread();
        user.start();
        dt.start();
        System.out.println("STATE OF MAIN FUNCTION: "  + Thread.currentThread().getState()); //THIS GET EXECUTED AND JVM IS LEFT .
    }
}
