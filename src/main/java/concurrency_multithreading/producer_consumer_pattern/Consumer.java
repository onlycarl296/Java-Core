package concurrency_multithreading.producer_consumer_pattern;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {

    private final BaseBlockingQueue<Integer> queue;

    Consumer(BaseBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                queue.take();
                System.out.println("Consumed resource - Queue size() = " + queue.size());
                Thread.sleep(ThreadLocalRandom.current().nextInt(50, 300)); // simulate time passing
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
