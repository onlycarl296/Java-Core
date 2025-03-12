package concurrency_multithreading.practice;

import java.util.Date;
import java.util.concurrent.*;

//Write a Java program that uses the ScheduledExecutorService interface to schedule tasks for execution at a specified time or with a fixed delay.
public class p10Main {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        // Schedule a task to run after a delay of 2 seconds
        executor.schedule(new Task(), 2, TimeUnit.SECONDS);

        // Schedule a task to run after a delay of 3 seconds and repeat every 5 seconds
        executor.scheduleAtFixedRate(new Task(), 3, 5, TimeUnit.SECONDS);

        // Wait for scheduled tasks to complete
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Shutdown the executor
        executor.shutdown();
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("Task executed at: " + new Date());
        }
    }
}
