package sync;

public class SynchronizedBankMethod {
    static class BankAccount {
        private int balance;

        public BankAccount(int initial) {
            this.balance = initial;
        }

        // Not synchronized -> race condition possible
        public synchronized void withdraw(int amount) {
            if (balance >= amount) {
                // Read-modify-write with artificial delay
                int newBalance = balance - amount;
                try { Thread.sleep(1); } catch (InterruptedException ignored) {}
                balance = newBalance;
            } else {
                System.out.println(Thread.currentThread().getName() + ": Insufficient funds");
            }
        }

        public int getBalance() { return balance; }
    }

    static class WithdrawalTask implements Runnable {
        private final BankAccount account;
        private final int amount;
        private final int times;

        public WithdrawalTask(BankAccount account, int amount, int times) {
            this.account = account;
            this.amount = amount;
            this.times = times;
        }

        @Override
        public void run() {
            for (int i = 0; i < times; i++) {
                account.withdraw(amount);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(1000);

        int threads = 20;
        int withdrawAmount = 10;
        int times = 5; // each thread withdraws 10 * 10 = 100 total, 100 * 10 = 1000

        Thread[] t = new Thread[threads];
        for (int i = 0; i < threads; i++) {
            t[i] = new Thread(new WithdrawalTask(account, withdrawAmount, times), "T-" + i);
            t[i].start();
        }

        for (Thread thread : t) thread.join();

        System.out.println("Expected final balance:  0");
        System.out.println("Actual final balance: " + account.getBalance());
    }
}
