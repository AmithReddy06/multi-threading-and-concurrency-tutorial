class TaskA extends Thread{
    @Override
    public void run(){
        System.out.println("Task A is running");
    }
}

class TaskB implements Runnable{
    @Override
    public void run(){
        System.out.println("Task B is running");

    }
}



public class ClassAndInterface {
    public static void main(String[] args) {
        TaskA t1 = new TaskA();
        t1.start();

        Thread t2 = new Thread(new TaskB());
        t2.start();
        
    }
}