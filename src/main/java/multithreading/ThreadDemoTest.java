package multithreading;

public class ThreadDemoTest {
    public static void main(String[] args) {
        System.out.println("Main thread running... ");

        ThreadDemo T1 = new ThreadDemo("Thread-1-HR-Database");
        T1.start();

        ThreadDemo T2 = new ThreadDemo("Thread-2-Send-Email");
        T2.start();

        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true); // Set the thread as a daemon thread
        daemonThread.start();


        System.out.println("==&gt; Main thread stopped!!! ");
        System.out.println(T1.getPriority());
        System.out.println(T2.getPriority());

        System.out.println("Main thread is going to sleep...");
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished, exiting...");
    }
}
