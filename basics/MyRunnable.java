class ThreadClass implements Runnable{
    @Override
    public void run(){
        System.out.println("Running using the Runnable interface");
    }
}

public class MyRunnable{
    public static void main(String[] args) {
        ThreadClass myRunnable = new ThreadClass(); // ThreadClass implements Runnable interface
        Thread t1 = new Thread(myRunnable); // *
        t1.start();

    

    }
}


// *
// you need an object of a class that implements Runnable interface.
// This object will be passed inside the thread constructor.