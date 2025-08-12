package thread_states;

public class SleepJoin{
    public static void main(String[] args) throws InterruptedException {
        
        Thread t1 = new Thread(() ->{
            try {
                System.out.println("t1 started");
                Thread.sleep(2000);
                System.out.println("t1 stopped");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("t2 started");
                Thread.sleep(1000);
                System.out.println("t2 stopped");
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        
        });


        t1.start();
        t2.start();

        System.out.println("main waits for t1 to finish");
        t1.join(); 

        System.out.println("main waits for t2 to finish");
        t2.join();

        System.out.println("Main finished after T1 and T2");

        // what is happening:
        // line 33 runs.
        // join blocks main method
        // t1 starts, sleeps 2 secs
        // paralelly: t2 starts, sleeps for 1 sec and finishes - TERMINATED
        // after 2 secs, t2 wakes up, fisnihes
        // now, main thread restarts


    }
}



