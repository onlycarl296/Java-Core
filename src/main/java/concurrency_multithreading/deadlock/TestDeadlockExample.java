package concurrency_multithreading.deadlock;

public class TestDeadlockExample {
    public static void main(String[] args) {
        final String hung = "Hung";
        final String lan = "Lan";
        // t1 tries to lock resource1 then resource2
        Thread t1 = new Thread() {
            public void run() {
                synchronized (hung) {
                    System.out.println("Den nha Lan ru di choi");

                    try { Thread.sleep(100);} catch (Exception e) {}

                    synchronized (lan) {
                        System.out.println("di choi");
                    }
                }
            }
        };

        // t2 tries to lock resource2 then resource1
        Thread t2 = new Thread() {
            public void run() {
                synchronized (lan) {
                    System.out.println("Den nha Hung hoi bai");

                    try { Thread.sleep(100);} catch (Exception e) {}

                    synchronized (hung) {
                        System.out.println("hoc bai");
                    }
                }
            }
        };


        t1.start();
        t2.start();
    }
}
