package Lambda_exp;

public class LambdaExpression {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println("THIS IS LAMBDA EXP."));
        t1.start();
    }
    
}
