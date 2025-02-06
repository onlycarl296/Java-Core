package concurrency_multithreading.java_synchronized;

public class Test {
    private static int a = 0;

    public synchronized void log1(String msg1, String msg2) {

        for (int i = 1; i <= 100; i++) {
            a++;
            System.out.println(msg1 + "-" + msg2 + " > A: " + a);

//            try {
//                Thread.sleep(100);
//            } catch (Exception e) {
//            }
        }
    }

//    public static void log2(String msg1, String msg2) {
//        synchronized (Test.class) {
//            for (int i = 1; i <= 5; i++) {
//                a++;
//                System.out.println(msg1 + "-" + msg2 + " > A: " + a);
//
//                try {
//                    Thread.sleep(100);
//                } catch (Exception e) {
//                }
//            }
//        }
//    }
    public void log2(String msg1, String msg2) {
        synchronized (this) {
            for (int i = 1; i <= 100; i++) {
                a++;
                System.out.println(msg1 + "-" + msg2 + " > A: " + a);

//                try {
//                    Thread.sleep(100);
//                } catch (Exception e) {
//                }
            }
        }
    }

    public static void main(String[] args) {
        Test obj1 = new Test();
        Test obj2 = new Test();

        Thread t1 = new Thread() {
            public void run() {
                obj1.log1("Thread 1", "Log 1");
                // obj1.log2("Thread 1", "Log 2");
            }
        };

//        Thread t2 = new Thread() {
//            public void run() {
////                obj1.log1("Thread 2", "Log 1");
//                 log2("Thread 2", "Log 2");
//            }
//        };

        Thread t3 = new Thread() {
            public void run() {
                obj1.log2("Thread 3", "Log 1");
                // obj1.log2("Thread 3", "Log 2");
            }
        };

        t1.start();
//        t2.start();
        t3.start();
    }
}



