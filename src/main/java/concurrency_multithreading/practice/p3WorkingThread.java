package concurrency_multithreading.practice;

public class p3WorkingThread implements Runnable{
    private p3Semaphore semaphore;
    private String name;

    public p3WorkingThread(p3Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    public void run() {
        try {
            System.out.println(name + ": acquiring lock...");
            System.out.println(name + ": available Semaphore permits now: " + semaphore.availablePermits());
            semaphore.acquire();
            System.out.println(name + ": got the permit!");

            try {
                System.out.println(name + ": is performing operation, available Semaphore permits : "
                        + semaphore.availablePermits());
                Thread.sleep(100); // simulate time to work
            } finally {
                // calling release() after a successful acquire()
                System.out.println(name + ": releasing lock...");
                semaphore.release();
                System.out.println(name + ": available Semaphore permits now: " + semaphore.availablePermits());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
