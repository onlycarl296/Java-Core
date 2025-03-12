package concurrency_multithreading.practice;

import java.util.concurrent.ConcurrentLinkedQueue;

// Write a Java program that utilizes the ConcurrentLinkedQueue class to implement a thread-safe queue.
public class p7Main {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        // Create and start the producer threads
        Thread producerThread1 = new Thread(new p7Producer(queue, "Producer-1"));
        Thread producerThread2 = new Thread(new p7Producer(queue, "Producer-2"));
        producerThread1.start();
        producerThread2.start();

        // Create and start the consumer threads
        Thread consumerThread1 = new Thread(new p7Consumer(queue, "Consumer-1"));
        Thread consumerThread2 = new Thread(new p7Consumer(queue, "Consumer-2"));
        consumerThread1.start();
        consumerThread2.start();
    }
}
