package concurrency_multithreading.practice;

import java.util.concurrent.ThreadLocalRandom;

public class p2Producer implements Runnable{
    p2BlockingQueue<Integer> blockingQueue ;

    public p2Producer(p2BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (true){
                Integer value = produce();
                blockingQueue.put(value);
                System.out.println("Producer "+ value+" have been created "+ blockingQueue.size());
            }
        }catch (InterruptedException e){
            System.out.println(e);
        }

    }

    private Integer produce() throws InterruptedException {
//        Thread.sleep(50); // simulate time to produce the data
        return ThreadLocalRandom.current().nextInt(1, 100);
    }
}
