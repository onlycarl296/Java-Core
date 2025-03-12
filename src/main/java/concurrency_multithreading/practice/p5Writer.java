package concurrency_multithreading.practice;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;

public class p5Writer implements Runnable {
    private ReadWriteLock lock;
    private p5SharedResource sharedResource;
    private int counter = 0;
    private Random random = new Random();

    public p5Writer(ReadWriteLock lock, p5SharedResource sharedResource) {
        this.lock = lock;
        this.sharedResource = sharedResource;
    }

    public void run() {
        while (true) {
            lock.writeLock().lock();
            counter =random.nextInt(100);
            System.out.println("Writer " + Thread.currentThread().getName() + " is writing: "+ counter );

            // Write to the shared resource
            sharedResource.write("Writer " + Thread.currentThread().getName() + " writes: " + counter);

            lock.writeLock().unlock();

            // Delay between consecutive writes
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
