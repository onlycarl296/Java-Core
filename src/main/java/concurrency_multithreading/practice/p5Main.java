package concurrency_multithreading.practice;

// Write a Java program to illustrate the usage of the ReadWriteLock interface for concurrent read-write access to a shared resource.

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class p5Main {
    private static final int NUM_READERS = 3;
    private static final int NUM_WRITERS = 2;

    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        p5SharedResource sharedResource = new p5SharedResource();

        // Create and start the reader threads
        for (int i = 0; i < NUM_READERS; i++) {
            Thread readerThread = new Thread(new p5Reader(lock, sharedResource));
            readerThread.start();
        }

        // Create and start the writer threads
        for (int i = 0; i < NUM_WRITERS; i++) {
            Thread writerThread = new Thread(new p5Writer(lock, sharedResource));
            writerThread.start();
        }
    }

    /*
    A ReadWriteLock duy trì một cặp khóa liên quan, một cái là cho các hoạt động chỉ đọc và một cho ghi.
    Khóa đọc (Read lock) có thể được giữ đồng thời bởi nhiều thread, miễn là không có người ghi.
    Khóa ghi (write lock) là độc quyền, tức là chỉ có duy nhất luồng trong 1 thời điểm được chỉnh sửa

    Read Lock − If no thread has locked the ReadWriteLock for writing then multiple thread can access the read lock.

    Write Lock − If no thread is reading or writing, then one thread can access the write lock.
     */

}