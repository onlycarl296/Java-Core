package concurrency_multithreading.practice;

//Write a Java program to demonstrate Semaphore usage for thread synchronization.
public class p3Main {
    private static p3Semaphore semaphore = new p3Semaphore(4);

    public static void main(String[] args) {
        System.out.println("Total available Semaphore permits: " + semaphore.availablePermits());
        for (int i = 1; i <= 6; i++) {
            p3WorkingThread atmWorker = new p3WorkingThread(semaphore, "AMT " + i);

            Thread thread = new Thread(atmWorker);
            thread.start();
        }
    }
}
