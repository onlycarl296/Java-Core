package concurrency_multithreading.practice;

import java.util.concurrent.ConcurrentLinkedQueue;

public class p7Producer implements Runnable {
    private ConcurrentLinkedQueue< String > queue;
    private String producerName;
    private int counter;

    public p7Producer(ConcurrentLinkedQueue < String > queue, String producerName) {
        this.queue = queue;
        this.producerName = producerName;
        this.counter = 0;
    }

    public void run() {
        while (true) {
            String item = producerName + "-Item-" + counter++;
            queue.offer(item);
            System.out.println("Produced: " + item);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
