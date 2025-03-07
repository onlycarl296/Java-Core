package concurrency_multithreading.java_concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class DequeueMethods {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue =
                new ArrayBlockingQueue<>(3);

        //take() will block util element becomes available
        try{
            String element = blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //poll() returns null if no element is available
        String element2 = blockingQueue.poll();

        //poll( time, TimeUnit) blocks up util timeout
        //for an element to become available. If no element is available
        // before that time, null is returned
        try {
            String  element3 =blockingQueue.poll(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //removes the element if present in the BlockingQueue
        boolean wasRemoved =blockingQueue.remove("2");


    }
}
