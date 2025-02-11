package concurrency_multithreading.java_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    /*
    private int count = 0;

    public int inc(){
        synchronized(this){
            return ++count;
        }
    }
    Block synchronized(this) trong hàm inc() đảm bảo rằng chỉ một thread có thể được truy xuất
    và trả về ++count ở một thời điểm
     */

    private Lock lock = new ReentrantLock();
    private int count = 0;

    public void inc(){
        try {
            lock.lock();
            this.count++;
        }finally {
            lock.unlock();
        }

    }
}
