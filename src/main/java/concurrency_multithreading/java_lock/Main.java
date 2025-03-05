package concurrency_multithreading.java_lock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BaseReentrant baseReentrant = new BaseReentrant();
        baseReentrant.outer();
        baseReentrant.outer1();
    }
}
