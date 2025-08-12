public class WithoutLambda{
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run(){
                System.out.println("running thread with an anyonymous class' object ");
            }
        });

        t1.start();
        
    }
}