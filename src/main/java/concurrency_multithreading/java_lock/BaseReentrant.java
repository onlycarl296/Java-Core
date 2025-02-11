package concurrency_multithreading.java_lock;

public class BaseReentrant {
    ReentrantLock lock = new ReentrantLock();

    public void outer() throws InterruptedException {
        lock.lock();
        inner();
        lock.unlock();
    }

    public void inner() throws InterruptedException {
        lock.lock();
        //do something
        lock.unlock();
    }
}
