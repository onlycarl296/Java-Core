package concurrency_multithreading.practice;


//Write a Java program to create a producer-consumer scenario using the wait() and notify()
// methods for thread synchronization.
public class p2Main {
    public static void main(String[] args) {
        p2BlockingQueue<Integer> blockingQueue = new p2BlockingQueue<>();

        p2Producer producer1 = new p2Producer(blockingQueue);
        p2Consumer consumer1 = new p2Consumer(blockingQueue);
        p2Consumer consunmer2 = new p2Consumer(blockingQueue);

        Thread thread1 = new Thread(producer1);
        Thread thread2 = new Thread(consumer1);
        Thread thread3 = new Thread(consumer1);

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
