package thread_states;

public class ThreadStateTracker {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            try {
                System.out.println("T1: Running, will sleep for 1s");
                Thread.sleep(1000); // TIMED_WAITING
                System.out.println("T1: Woke up, finishing...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("State before start: " + t1.getState()); 
        System.out.println("isAlive before start: " + t1.isAlive()); 

        t1.start();
        System.out.println("State after start: " + t1.getState()); 
        System.out.println("isAlive after start: " + t1.isAlive()); 

        Thread.sleep(200); 
        System.out.println("State while T1 is sleeping: " + t1.getState()); 


        t1.join();
        System.out.println("State after finish: " + t1.getState()); 
        System.out.println("isAlive after finish: " + t1.isAlive()); 
}
}