package Thread_Lifecycle;

public class Mythread extends Thread {
    @Override
    public void run(){
        System.out.println("RUNNING");
        try{
            Thread.sleep(2000);
        }
        catch (InterruptedException e){

        }
    }
    public static void main(String[] args) throws InterruptedException {
        Mythread t1 = new Mythread();
        System.out.println(t1.getState()); //Start
        t1.start();
        System.out.println(t1.getState()); //RUNNABLE

        Thread.sleep(100);
        System.out.println(t1.getState());
        t1.join(); //Main is witing for t1 to terminate.
        System.out.println(t1.getState());
    }
}
