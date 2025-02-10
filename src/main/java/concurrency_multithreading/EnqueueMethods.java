package concurrency_multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class EnqueueMethods {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue =
                new ArrayBlockingQueue<>(3);

        //put() will block util there is space
        // inside the Blockingqueue for element
        try{
            blockingQueue.put("1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //add will throw IllegalStateException if
        //no space available in BlockingQueue
        try {
            blockingQueue.add("1");
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }

        //offer() returns false if no space
        boolean wasEnqueued =blockingQueue.offer("2");

        //offer(o, time, TimeUnit) blocks for time if no space,
        // then returns false if still no space
        try {
            boolean wasEnqueued2 =blockingQueue.offer("3", 1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
