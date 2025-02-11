package concurrency_multithreading.java_concurrent;

import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {

    protected BlockingQueue<String> queue = null;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            queue.put("100");
//            Thread.sleep(1000);
            queue.put("200");
//            Thread.sleep(1000);
            queue.put("300");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
