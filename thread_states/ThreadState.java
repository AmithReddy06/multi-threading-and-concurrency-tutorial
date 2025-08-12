package thread_states;


public class ThreadState{
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("t1 running");
                Thread.sleep(1500);
                System.out.println("t1 ended");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        System.out.println("Before start: isAlive:"+t1.isAlive());
        t1.start();

        System.out.println("After starting: isAlive:"+t1.isAlive());

        Thread.sleep(500);
        System.out.println("While running: isAlive:"+t1.isAlive());
        t1.join();
        System.out.println("After running: isAlive:"+t1.isAlive());


    }
}


// expected output:
// Before start: isAlive:false
// t1 running
// After starting: isAlive:true
// While running: isAlive:true
// t1 ended
// After running: isAlive:false