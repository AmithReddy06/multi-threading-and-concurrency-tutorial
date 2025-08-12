 // extending Thread class
 class MyThread extends Thread {
    @Override
    public void run(){
        System.out.println("Thread running with Thread class");
    }
}

public class Threads{
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
