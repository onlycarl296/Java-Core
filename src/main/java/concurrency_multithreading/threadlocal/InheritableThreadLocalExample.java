package concurrency_multithreading.threadlocal;

public class InheritableThreadLocalExample {
    public static void main(String[] args) {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        InheritableThreadLocal<String> inheritableThreadLocal =
                new InheritableThreadLocal<>();

        Thread thread = new Thread(()->{
            System.out.println("===== Thread 1 ====");
            threadLocal.set("Thread1 -ThreadLocal");
            inheritableThreadLocal.set("Thread 1 - InheritableThreadLocal");

            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());

            Thread childThread = new Thread(()->{
                System.out.println("===== ChildThread ====");
                System.out.println(threadLocal.get());
                System.out.println(inheritableThreadLocal.get());
            });
            childThread.start();
        });

        thread.start();

    }
}
