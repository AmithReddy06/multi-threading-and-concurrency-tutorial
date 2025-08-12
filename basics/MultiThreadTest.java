class PrintNumbers extends Thread{
    private int start;

    public PrintNumbers(int start){
        this.start = start;
    }

    @Override
    public void run(){
        for(int i= start; i< start+5;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}

public class MultiThreadTest {
    public static void main(String[] args) {
        PrintNumbers t1 = new PrintNumbers(5);
        PrintNumbers t2 = new PrintNumbers(10);
        PrintNumbers t3 = new PrintNumbers(20);


        // if you don't want order:
        t1.start();
        t2.start();
        t3.start();
        // When you call start(), it tells the JVM to create a new 
        // OS-level thread, and then calls the thread's run() method.. if we driectly use run(), no thread is created.


        // if order needed:
        // t1.start();
        // try {
        //     t1.join();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();

        // }        
        // t2.start();
        // try {
        //     t1.join();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();

        // }          
        // t3.start();
        // try {
        //     t1.join();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();

        // }          
    }
}
