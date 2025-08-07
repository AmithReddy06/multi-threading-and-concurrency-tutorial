class ThreadClass implements Runnable{
    @Override
    public void run(){
        System.out.println("Running using the Runnable interface");
    }
}

public class MyRunnable{
    public static void main(String[] args) {
        ThreadClass myRunnable = new ThreadClass();
        Thread t1 = new Thread(myRunnable);
        t1.start();

    

    }
}