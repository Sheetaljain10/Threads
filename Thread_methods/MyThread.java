package Thread_methods;

public class MyThread extends Thread{
    @Override
    public void run() { //METHOD 4
        for(int i=1;i<=5;i++){
            try {
                Thread.sleep(1000); //METHOD 3
            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.println(i);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        t1.start(); //METHOD 1
        t1.join(); //METHOD 2
        System.out.println("t1 is done");
    }    
}
