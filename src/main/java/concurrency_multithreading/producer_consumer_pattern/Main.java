package concurrency_multithreading.producer_consumer_pattern;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        BaseBlockingQueue<Integer> boundedBuffer = new BaseBlockingQueue<>();

        Producer producer = new Producer(boundedBuffer);
        Consumer consumer1 = new Consumer(boundedBuffer);
        Consumer consumer2 = new Consumer(boundedBuffer);
        Consumer consumer3 = new Consumer(boundedBuffer);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
        new Thread(consumer3).start();

        Thread.sleep(5000); // After 5s have another comsumer
        Consumer consumer4 = new Consumer(boundedBuffer);
        new Thread(consumer4).start();
    }

    /*
    Producer và Consumer được kết nối thông qua BlockingQueue, nó không biết sự hiện diện của nhau, tách rời các mối quan tâm (separation of concern),
    giúp hệ thống thống có thiết kế tốt hơn, nên dễ dàng nâng cấp và mở rộng.

    Producer và Consumer không cần phải có sẵn cùng một lúc. Consumer có thể nhận các nhiệm vụ được sản xuất bởi Producer tại một thời điểm khác nhau.
     */
}