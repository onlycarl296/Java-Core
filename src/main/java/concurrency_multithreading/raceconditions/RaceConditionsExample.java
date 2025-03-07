package concurrency_multithreading.raceconditions;

public class RaceConditionsExample {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread thread1 = new Thread(getRunnable(counter, "Thread1 final count:"));
        Thread thread2 = new Thread(getRunnable(counter, "Thread2 final count:"));

        thread1.start();
        thread2.start();
    }

    private static Runnable getRunnable(Counter counter, String message) {
        return () -> {
            synchronized (counter) {}
                for (int i = 0; i < 10000; i++) {
                counter.incAndGet();
            }
            System.out.println(message + counter.get());
        };
    }
}
