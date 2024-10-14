package create_thread;

public class Class_Test {
    public static void main(String[] args) {
        Thread_class obj = new Thread_class();
        obj.start();
        for(int i=0;i<50;i++){
            System.out.println("TESTING THREAD CLASS....");
            System.out.println(Thread.currentThread().getName() + "\n");
        }
    }
}
