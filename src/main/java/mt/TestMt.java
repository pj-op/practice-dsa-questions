package mt;

class PrintOddAndEvenUsingMultiThreading implements Runnable {
    int count = 1;

    @Override
    public void run() {
        while (count < 10) {
            if (count % 2 == 0 && Thread.currentThread().getName().equals("even")) {
                synchronized (this) {
                    System.out.println(Thread.currentThread().getName() + " " + count);
                    count++;
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            if (count % 2 != 0 && Thread.currentThread().getName().equals("odd")) {
                synchronized (this) {
                    System.out.println(Thread.currentThread().getName() + " " + count);
                    count++;
                    this.notify();
                }
            }
        }
    }
}

public class TestMt {
    public static void main(String[] args) {
        PrintOddAndEvenUsingMultiThreading p = new PrintOddAndEvenUsingMultiThreading();
        Thread t1 = new Thread(p, "even");
        Thread t2 = new Thread(p, "odd");
        t1.start();
        t2.start();
    }
}