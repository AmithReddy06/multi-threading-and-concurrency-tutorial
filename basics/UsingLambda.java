// when we do Runnable() { }, we are making an anonymous inner class. and then, inside we define run(). this means, we 
// a lambda expression can be used whenever a functional interface is expected.


// public class UsingLambda {
//     public static void main(String[] args) {
//         Thread t1 = new Thread(() -> {
//             for(int i=0;i<5;i++){
//                 System.out.println("T1:"+i);
//             }
//         });

//         Thread t2 = new Thread(() -> {
//             for(int i=100;i<105;i++){
//                 System.out.println("T2:"+i);
//             }
//         });

//         Thread t3 = new Thread(() ->  System.out.println("from t3"));  // in-line lambda, obviously needs a start() method to run as a thread.

//         t1.start();
//         t2.start();
//         t3.start();
//     }
// }


public class UsingLambda{
    public static void main(String[] args) {
        
        Thread t1 = new Thread(() -> {
            for(int i=1;i<6;i++){
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i=101;i<106;i++){
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        });

        Thread t3 = new Thread(() -> {
            for(int i=1000;i<1006;i++){
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}