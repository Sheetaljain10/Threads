package create_thread;

public class Int_test {
    public static void main(String[] args) {
        runnable_int obj = new runnable_int();
        Thread thr_obj = new Thread(obj);  //PASSING THE OBJECT OF NEW THREAD INTO THE THREAD CLASS.
        thr_obj.start();

        for(int i=0;i<50;i++){
            System.out.println("TESTING RUNNABLE INTERFACE....");
            System.out.println(Thread.currentThread().getName() + "\n");
        }
    }
}
