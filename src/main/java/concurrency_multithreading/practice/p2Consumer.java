package concurrency_multithreading.practice;

import java.util.concurrent.ThreadLocalRandom;

public class p2Consumer implements Runnable{

    p2BlockingQueue<Integer> blockingQueue ;

    public p2Consumer(p2BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (true){
                System.out.println("Consumed resource - Queue size() = " + blockingQueue.size());
                blockingQueue.take();
                Thread.sleep(ThreadLocalRandom.current().nextInt(50, 300));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
