package concurrency_multithreading.practice;

import java.util.concurrent.ConcurrentLinkedQueue;

public class p7Consumer implements Runnable {
    private ConcurrentLinkedQueue< String > queue;
    private String consumerName;

    public p7Consumer(ConcurrentLinkedQueue < String > queue, String consumerName) {
        this.queue = queue;
        this.consumerName = consumerName;
    }

    public void run() {
        while (true) {
            String item = queue.poll();
            if (item != null) {
                System.out.println(consumerName + " consumed: " + item);
            }

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

