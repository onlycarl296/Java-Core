package concurrency_multithreading.practice;

import java.util.concurrent.locks.ReadWriteLock;

public class p5Reader implements Runnable {
    private ReadWriteLock lock;
    private p5SharedResource sharedResource;

    public p5Reader (ReadWriteLock lock, p5SharedResource sharedResource) {
        this.lock = lock;
        this.sharedResource = sharedResource;
    }

    public void run() {
        while (true) {
            lock.readLock().lock();

            // Read from the shared resource
            System.out.println("Reader " + Thread.currentThread().getName() + " reads: " + sharedResource.read());

            lock.readLock().unlock();

            // Delay between consecutive reads
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
